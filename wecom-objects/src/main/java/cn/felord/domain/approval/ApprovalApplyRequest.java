/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalNotifyType;
import cn.felord.enumeration.UseTemplateApprover;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ApprovalApplyRequest
 *
 * @author dax
 * @since 2023 /5/25
 */
@ToString
@Getter
public class ApprovalApplyRequest {
    private final String creatorUserid;
    private final String templateId;
    private final UseTemplateApprover useTemplateApprover;
    private Long chooseDepartment;
    private List<Approver> approver;
    private List<String> notifyer;
    private ApprovalNotifyType notifyType;
    private final ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData;
    private final List<Summary> summaryList;


    /**
     * 填充审批模板数据
     * <p>
     * 用来填充数据，降低使用难度
     *
     * @param controls   模板控件集合，通过获取审批模板详情接口获取
     * @param dataValues 审批业务项填充值，按模板顺序
     * @return 最终的审批单数据格式
     */
    public static ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData(List<? extends TmpControl<?>> controls, List<? extends ContentDataValue> dataValues) {
        //必须保证 dataValues 和 controls 对应
        List<ApprovalContentData<? extends ContentDataValue>> contents = IntStream.range(0, controls.size())
                .mapToObj(index ->
                        toDataValue(controls.get(index), dataValues.get(index))
                ).collect(Collectors.toList());
        // 业务数据
        return new ApplyData<>(contents);
    }

    /**
     * 通过接口指定审批人，不抄送
     *
     * @param creatorUserid the creator userid
     * @param templateId    the template id
     * @param approver      the approver
     * @param applyData     the apply data
     * @param summaryList   the summary list
     * @return the approval apply request
     */
    public static ApprovalApplyRequest approverMode(String creatorUserid,
                                                    String templateId,
                                                    List<Approver> approver,
                                                    ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData,
                                                    List<Summary> summaryList) {

        return approverMode(creatorUserid, templateId, approver, Collections.emptyList(), null, applyData, summaryList);
    }

    /**
     * 通过接口指定审批人、抄送人
     *
     * @param creatorUserid the creator userid
     * @param templateId    the template id
     * @param approver      the approver
     * @param notifyer      the notifyer
     * @param notifyType    the notify type
     * @param applyData     the apply data
     * @param summaryList   the summary list
     * @return the approval apply request
     */
    public static ApprovalApplyRequest approverMode(String creatorUserid,
                                                    String templateId,
                                                    List<Approver> approver,
                                                    List<String> notifyer,
                                                    ApprovalNotifyType notifyType,
                                                    ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData,
                                                    List<Summary> summaryList) {
        return new ApprovalApplyRequest(creatorUserid, templateId, applyData, summaryList, UseTemplateApprover.APPROVER_MODE)
                .approver(approver)
                .notifyer(notifyer)
                .notifyType(notifyType);
    }

    /**
     * 在企微控制台指定抄送人、审批人
     *
     * @param creatorUserid the creator userid
     * @param templateId    the template id
     * @param applyData     the apply data
     * @param summaryList   the summary list
     * @return the approval apply request
     */
    public static ApprovalApplyRequest backendMode(String creatorUserid,
                                                   String templateId,
                                                   ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData,
                                                   List<Summary> summaryList) {
        return new ApprovalApplyRequest(creatorUserid, templateId, applyData, summaryList, UseTemplateApprover.BACKEND_MODE);
    }

    private static ApprovalContentData<ContentDataValue> toDataValue(TmpControl<?> tmpControl, ContentDataValue dataValue) {
        Object config = tmpControl.getConfig();
        ContentDataValue v;
        // 处理明细数据
        if (config != null && config.getClass().isAssignableFrom(TableConfig.class)) {
            ListContentDataValue internalValue = (ListContentDataValue) dataValue;
            List<? extends ContentDataValue> tableValues = internalValue.getValues();
            TableConfig tableConfig = (TableConfig) config;
            List<TableCtrlProperty> children = tableConfig.getTable()
                    .getChildren();
            List<ApplyContentData<?>> applyContentData = IntStream.range(0, children.size())
                    .mapToObj(index ->
                            ApplyContentData.from(children.get(index).getProperty(), tableValues.get(index)))
                    .collect(Collectors.toList());
            TableValue.Wrapper wrapper = new TableValue.Wrapper();
            wrapper.setList(applyContentData);
            v = new TableValue(Collections.singletonList(wrapper));
        } else {
            v = dataValue;
        }
        return tmpControl.getProperty().toData(v);
    }


    /**
     * Instantiates a new Approval apply request.
     *
     * @param creatorUserid       the creator userid
     * @param templateId          the template id
     * @param applyData           the apply data
     * @param summaryList         the summary list
     * @param useTemplateApprover the use template approver
     */
    ApprovalApplyRequest(String creatorUserid, String templateId, ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData, List<Summary> summaryList, UseTemplateApprover useTemplateApprover) {
        this.creatorUserid = creatorUserid;
        this.templateId = templateId;
        this.applyData = applyData;
        this.summaryList = summaryList;
        this.useTemplateApprover = useTemplateApprover;
    }

    /**
     * 提单者提单部门id，不填默认为主部门
     *
     * @param chooseDepartment the choose department
     * @return the approval apply request
     */
    public ApprovalApplyRequest chooseDepartment(Long chooseDepartment) {
        this.chooseDepartment = chooseDepartment;
        return this;
    }

    /**
     * 审批流程信息，用于指定审批申请的审批流程，支持单人审批、多人会签、多人或签，可能有多个审批节点，仅use_template_approver为0时生效。
     *
     * @param approver the approver
     * @return the approval apply request
     */
    ApprovalApplyRequest approver(List<Approver> approver) {
        this.approver = approver;
        return this;
    }

    /**
     * 抄送人节点userid列表，仅use_template_approver为0时生效。
     *
     * @param notifyer the notifyer
     * @return the approval apply request
     */
    ApprovalApplyRequest notifyer(List<String> notifyer) {
        this.notifyer = notifyer;
        return this;
    }

    /**
     * 抄送方式：1-提单时抄送（默认值）； 2-单据通过后抄送；3-提单和单据通过后抄送。仅use_template_approver为0时生效。
     *
     * @param notifyType the notify type
     * @return the approval apply request
     */
    ApprovalApplyRequest notifyType(ApprovalNotifyType notifyType) {
        this.notifyType = notifyType;
        return this;
    }
}
