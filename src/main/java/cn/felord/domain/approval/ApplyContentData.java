/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
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
 * TODO
 *
 * @param <V> the type parameter
 * @author dax
 * @since 2023 /5/26
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "control", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextApplyContentData.class, names = {"Text", "Textarea", "Tips"}),
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
})
@ToString
@Getter
public abstract class ApplyContentData<V> {
    private final ApprovalCtrlType control;
    private final String id;
    private final V value;
    private final List<ApprovalTitle> title;
    private final Integer hidden;


    /**
     * Instantiates a new Apply content data.
     *
     * @param control the control
     * @param id      the id
     * @param title   the title
     * @param value   the value
     * @param hidden  the hidden
     */
    public ApplyContentData(ApprovalCtrlType control, String id, List<ApprovalTitle> title, V value, Integer hidden) {
        this.control = control;
        this.id = id;
        this.value = value;
        this.title = title;
        this.hidden = hidden;
    }

    /**
     * From apply content data.
     *
     * @param <V>      the type parameter
     * @param property the property
     * @param value    the value
     * @return the apply content data
     */
    public static <V extends ContentDataValue> ApplyContentData<V> from(CtrlProperty property, V value) {
        return new ApplyContentData<V>(property.getControl(), property.getId(), property.getTitle(), value, null) {
        };
    }
}
