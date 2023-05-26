package cn.felord.domain.approval;

import cn.felord.jackson.MyJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.ToString;

/**
 * 控件
 *
 * @author xiafang
 * @since 2023/5/25 14:42
 */
@ToString
@Getter
/*@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "property.control", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmptyTmpControl.class, names = {"Text", "Textarea", "Number", "Money", "Tips"}),
        @JsonSubTypes.Type(value = DateTmpControl.class, name = "Date"),
        @JsonSubTypes.Type(value = SelectorTmpControl.class, name = "Selector"),
        @JsonSubTypes.Type(value = ContactTmpControl.class, name = "Contact"),
        @JsonSubTypes.Type(value = FileTmpControl.class, name = "File"),
        @JsonSubTypes.Type(value = TableTmpControl.class, name = "Table"),
        @JsonSubTypes.Type(value = AttendanceTmpControl.class, name = "Attendance"),
        @JsonSubTypes.Type(value = VacationTmpControl.class, name = "Vacation"),
        @JsonSubTypes.Type(value = LocationTmpControl.class, name = "Location"),
        @JsonSubTypes.Type(value = RelatedApprovalTmpControl.class, name = "RelatedApproval"),
        @JsonSubTypes.Type(value = DateRangeTmpControl.class, name = "DateRange")
})*/
@JsonDeserialize(using = MyJsonDeserializer.class)
public class TmpControl<C> {
    private final CtrlProperty property;
    private final C config;

    @JsonCreator
    public TmpControl(@JsonProperty("property") CtrlProperty property, @JsonProperty("config") C config) {
        this.property = property;
        this.config = config;
    }
}
