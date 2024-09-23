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

import cn.felord.enumeration.ApprovalCtrlType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * ApplyContentData
 *
 * <ol>
 *     <li>文本、多行文本、说明文字对应 {@link TextValue}</li>
 *     <li>数字对应 {@link NumberValue}</li>
 *     <li>金额对应 {@link MoneyValue}</li>
 *     <li>日期对应 {@link DateValue}</li>
 *     <li>单选/多选对应 {@link SelectorValue}</li>
 *     <li>成员/部门对应 {@link ContactValue}</li>
 *     <li>附件对应 {@link FileValue}</li>
 *     <li>明细对应 {@link TableValue}，注意明细比较复杂，条目类型要对应模板配置</li>
 *     <li>位置对应 {@link LocationValue}</li>
 *     <li>关联审批单对应 {@link RelatedApprovalValue}</li>
 *     <li>公式对应 {@link FormulaValue}</li>
 *     <li>时长对应 {@link DateRangeValue}</li>
 *     <li>手机号码对应 {@link PhoneNumberValue}</li>
 *     <li>假勤组件-请假组件对应 {@link VacationValue}</li>
 *     <li>假勤组件-出差/外出/加班组件对应 {@link AttendanceValue}</li>
 *     <li>补卡组件对应 {@link PunchCorrectionValue}</li>
 *     <li>收款账户对应 {@link BankAccountValue}</li>
 * </ol>
 *
 * @param <V> the type parameter
 * @author dax
 * @since 2024/5/26
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "control", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextApplyContentData.class, name = "Text"),
        @JsonSubTypes.Type(value = TextApplyContentData.class, name = "Textarea"),
        @JsonSubTypes.Type(value = TextApplyContentData.class, name = "Tips"),
        @JsonSubTypes.Type(value = NumberApplyContentData.class, name = "Number"),
        @JsonSubTypes.Type(value = MoneyApplyContentData.class, name = "Money"),
        @JsonSubTypes.Type(value = DateApplyContentData.class, name = "Date"),
        @JsonSubTypes.Type(value = SelectorApplyContentData.class, name = "Selector"),
        @JsonSubTypes.Type(value = ContactApplyContentData.class, name = "Contact"),
        @JsonSubTypes.Type(value = FileApplyContentData.class, name = "File"),
        @JsonSubTypes.Type(value = TableApplyContentData.class, name = "Table"),
        @JsonSubTypes.Type(value = VacationApplyContentData.class, name = "Vacation"),
        @JsonSubTypes.Type(value = AttendanceApplyContentData.class, name = "Attendance"),
        @JsonSubTypes.Type(value = PunchCorrectionApplyContentData.class, name = "PunchCorrection"),
        @JsonSubTypes.Type(value = DateRangeApplyContentData.class, name = "DateRange"),
        @JsonSubTypes.Type(value = LocationApplyContentData.class, name = "Location"),
        @JsonSubTypes.Type(value = RelatedApprovalApplyContentData.class, name = "RelatedApproval"),
        @JsonSubTypes.Type(value = FormulaApplyContentData.class, name = "Formula"),
        @JsonSubTypes.Type(value = PhoneNumberApplyContentData.class, name = "PhoneNumber"),
        @JsonSubTypes.Type(value = WedriveFileApplyContentData.class, name = "WedriveFile"),
        @JsonSubTypes.Type(value = BankAccountApplyContentData.class, name = "BankAccount")
})
@ToString
@Getter
public abstract class ApplyContentData<V> {
    private final ApprovalCtrlType control;
    private final String id;
    private final V value;
    private final List<ApprovalTitle> title;


    /**
     * Instantiates a new Apply content data.
     *
     * @param control the control
     * @param id      the id
     * @param title   the title
     * @param value   the value
     */
    ApplyContentData(ApprovalCtrlType control, String id, List<ApprovalTitle> title, V value) {
        this.control = control;
        this.id = id;
        this.value = value;
        this.title = title;
    }

    /**
     * 拉取审批单配置填充数据时使用
     *
     * @param <V>      the type parameter
     * @param property 配置
     * @param value    配置对应的值
     * @return the apply content data
     */
    public static <V extends ContentDataValue> ApplyContentData<V> from(CtrlProperty property, V value) {
        return new ApplyContentData<V>(property.getControl(), property.getId(), property.getTitle(), value) {
        };
    }
}
