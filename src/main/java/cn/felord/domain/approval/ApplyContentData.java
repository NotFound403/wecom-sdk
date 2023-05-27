package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalCtrlType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedHashMap;
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
        @JsonSubTypes.Type(value = TextValue.class, names = {"Text", "Textarea"}),
        @JsonSubTypes.Type(value = NumberValue.class, name = "Number"),
        @JsonSubTypes.Type(value = MoneyValue.class, name = "Money"),
        @JsonSubTypes.Type(value = DateValue.class, name = "Date"),
        @JsonSubTypes.Type(value = SelectorConfig.class, name = "Selector"),
        @JsonSubTypes.Type(value = ContactValue.class, name = "Contact"),
        @JsonSubTypes.Type(value = FileValue.class, name = "File"),
        @JsonSubTypes.Type(value = TableValue.class, name = "Table"),
        @JsonSubTypes.Type(value = LinkedHashMap.class, names = {"Vacation", "Attendance", "PunchCorrection", "DateRange", "Location", "RelatedApproval"}),
        @JsonSubTypes.Type(value = FormulaValue.class, name = "Formula"),
})
@ToString
@Getter
public class ApplyContentData<V extends ContentDataValue> extends TemplateContentData<V> {
    private final List<ApprovalTitle> title;
    private final Integer hidden;

    @JsonCreator
    public ApplyContentData(@JsonProperty("control") ApprovalCtrlType control,
                            @JsonProperty("id") String id,
                            @JsonProperty("title") List<ApprovalTitle> title,
                            @JsonProperty("value") V value,
                            @JsonProperty("hidden") Integer hidden) {
        super(control, id, value);
        this.title = title;
        this.hidden = hidden;
    }
}
