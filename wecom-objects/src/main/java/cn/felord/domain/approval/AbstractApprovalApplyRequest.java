/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.domain.approval;

import cn.felord.WeComException;
import cn.felord.enumeration.ApprovalCtrlType;
import cn.felord.enumeration.ApproverNodeMode;
import cn.felord.enumeration.UseTemplateApprover;
import cn.felord.utils.CollectionUtils;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author dax
 * @since 2024/4/17
 */
@ToString
@Getter
public abstract class AbstractApprovalApplyRequest {
    private final String creatorUserid;
    private final String templateId;
    private final UseTemplateApprover useTemplateApprover;
    private final ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData;
    private final List<Summary> summaryList;
    private Long chooseDepartment;

    AbstractApprovalApplyRequest(String creatorUserid,
                                 String templateId,
                                 UseTemplateApprover useTemplateApprover,
                                 ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData,
                                 List<Summary> summaryList) {
        this.creatorUserid = creatorUserid;
        this.templateId = templateId;
        this.useTemplateApprover = useTemplateApprover;
        this.applyData = applyData;
        this.summaryList = summaryList;
    }

    /**
     * 提单者提单部门id，不填默认为主部门
     *
     * @param chooseDepartment the choose department
     * @return the approval apply request
     */
    public AbstractApprovalApplyRequest chooseDepartment(Long chooseDepartment) {
        this.chooseDepartment = chooseDepartment;
        return this;
    }

    /**
     * 填充审批模板数据
     * <p>
     * 用来填充数据，降低使用难度
     * <ul>
     *     <li>creatorUserid，审批发起人企微ID，此审批申请将以此员工身份提交，发起人需在应用可见范围内</li>
     *     <li>templateId，企业微信审批模板id，可通过浏览器链接中获取</li>
     *     <li>dataValues，模板中你设计的字段填充值，在列表中索引位置要『按顺序』对应，并且类型{@link ApprovalCtrlType}要和{@link ContentDataValue}实现一致
     *         <ol>
     *             <li>文本、多行文本、说明文字对应 {@link TextValue}</li>
     *             <li>数字对应 {@link NumberValue}</li>
     *             <li>金额对应 {@link MoneyValue}</li>
     *             <li>日期对应 {@link DateValue}</li>
     *             <li>单选/多选对应 {@link SelectorValue}</li>
     *             <li>成员/部门对应 {@link ContactValue}</li>
     *             <li>附件对应 {@link FileValue}，通过上传临时素材接口{@code MediaApi.uploadMedia}获得mediaid</li>
     *             <li>明细对应 {@link ListContentDataValue}，注意明细比较复杂，条目类型要对应模板配置</li>
     *             <li>位置对应 {@link LocationValue}</li>
     *             <li>关联审批单对应 {@link RelatedApprovalValue}</li>
     *             <li>公式对应 {@link FormulaValue}</li>
     *             <li>时长对应 {@link DateRangeValue}</li>
     *             <li>手机号码对应 {@link PhoneNumberValue}</li>
     *             <li>假勤组件-请假组件对应 {@link VacationValue}</li>
     *             <li>假勤组件-出差/外出/加班组件对应 {@link AttendanceValue}</li>
     *             <li>补卡组件对应 {@link PunchCorrectionValue}</li>
     *             <li>收款账户对应 {@link BankAccountValue}</li>
     *         </ol>
     *     </li>
     *     <li>summaryTexts，摘要信息，最多三行，且每行不超过20个字</li>
     *     <li>approvers，审批节点，包含人和层签方式{@link ApproverNodeMode}（1或签、2会签）</li>
     *     <li>notifyType，抄送方式：
     *         <ol>
     *             <li>提单时抄送（默认值）</li>
     *             <li>单据通过后抄送</li>
     *             <li>提单和单据通过后抄送</li>
     *         </ol>
     *     </li>
     * </ul>
     *
     * @param controls   模板控件集合，通过获取审批模板详情接口获取
     * @param dataValues 审批业务项填充值，按模板顺序
     * @return 最终的审批单数据格式 apply data
     */
    static ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData(List<TmpControl<? extends ControlConfig>> controls,
                                                                                List<? extends ContentDataValue> dataValues) {
        //必须保证 dataValues 和 controls 对应
        int ctrlSize = controls.size();
        int valueSize = dataValues.size();

        if (ctrlSize != valueSize) {
            throw new WeComException("controls size do not match dataValues size");
        }

        List<ApprovalContentData<? extends ContentDataValue>> contents = IntStream.range(0, ctrlSize)
                .mapToObj(index ->
                        toControlValue(controls.get(index), dataValues.get(index))
                ).collect(Collectors.toList());
        // 业务数据
        return new ApplyData<>(contents);
    }

    private static ApprovalContentData<ContentDataValue> toControlValue(TmpControl<? extends ControlConfig> tmpControl,
                                                                        ContentDataValue dataValue) {
        ControlConfig config = tmpControl.getConfig();
        // 处理明细数据
        if (config != null && config.getClass().isAssignableFrom(TableConfig.class)) {
            ListContentDataValue internalValue = (ListContentDataValue) dataValue;
            if (internalValue == null) {
                throw new IllegalArgumentException("approval internalValue must not be null");
            }
            List<List<? extends ContentDataValue>> tableValues = internalValue.getValues();
            if (CollectionUtils.isEmpty(tableValues)) {
                throw new IllegalArgumentException("approval table values must not be empty");
            }
            TableConfig tableConfig = (TableConfig) config;
            List<TableCtrlProperty> children = tableConfig.getTable()
                    .getChildren();
            List<TableValue.Wrapper> collect = tableValues.stream()
                    .map(tableVal ->
                            {
                                int tableValSize = tableVal.size();
                                if (tableValSize != children.size()) {
                                    throw new IllegalArgumentException("table controls size do not match table dataValues size");
                                }
                                return IntStream.range(0, tableValSize)
                                        .mapToObj(index ->
                                                ApplyContentData.from(children.get(index).getProperty(), tableVal.get(index)))
                                        .collect(Collectors.toList());
                            }
                    )
                    .map(TableValue.Wrapper::new)
                    .collect(Collectors.toList());
            return tmpControl.getProperty().toData(new TableValue(collect));
        }
        return tmpControl.getProperty().toData(dataValue);
    }
}
