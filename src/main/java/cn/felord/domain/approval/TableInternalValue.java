package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalCtrlType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * TODO
 * The type Table internal value.
 *
 * @param <V> the type parameter
 * @author dax
 * @since 2023 /5/27 14:14
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
public class TableInternalValue<V extends ContentDataValue> {
    private final ApprovalCtrlType control;
    private final String id;
    private final List<ApprovalTitle> title;
    private final V value;

    public TableInternalValue(@JsonProperty("control") ApprovalCtrlType control,
                              @JsonProperty("id") String id,
                              @JsonProperty("title") List<ApprovalTitle> title,
                              @JsonProperty("value") V value) {
        this.control = control;
        this.id = id;
        this.title = title;
        this.value = value;
    }

    /**
     * From table value . wrapper . table internal value.
     *
     * @param <V>      the type parameter
     * @param property the property
     * @param value    the value
     * @return the table value . wrapper . table internal value
     */
    public static <V extends ContentDataValue> TableInternalValue<V> from(CtrlProperty property, V value) {
        return new TableInternalValue<>(property.getControl(), property.getId(), property.getTitle(), value);
    }
}