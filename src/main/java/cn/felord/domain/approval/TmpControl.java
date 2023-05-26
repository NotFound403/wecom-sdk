package cn.felord.domain.approval;

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
/*@JsonSubTypes({
        @JsonSubTypes.Type(value = EmptyConfig.class, names = {"Text", "Textarea", "Number", "Money", "Tips"}),
        @JsonSubTypes.Type(value = DateConfig.class, name = "Date"),
        @JsonSubTypes.Type(value = SelectorConfig.class, name = "Selector"),
        @JsonSubTypes.Type(value = ContactConfig.class, name = "Contact"),
        @JsonSubTypes.Type(value = FileConfig.class, name = "File"),
        @JsonSubTypes.Type(value = TableConfig.class, name = "Table"),
        @JsonSubTypes.Type(value = AttendanceConfig.class, name = "Attendance"),
        @JsonSubTypes.Type(value = VacationConfig.class, name = "Vacation"),
        @JsonSubTypes.Type(value = LocationConfig.class, name = "Location"),
        @JsonSubTypes.Type(value = RelatedApprovalConfig.class, name = "RelatedApproval"),
        @JsonSubTypes.Type(value = DateRangeConfig.class, name = "DateRange")
})*/
@JsonDeserialize(using = TmpControlDeserializer.class)
public class TmpControl<C> {
    private final CtrlProperty property;
    private final C config;

    @JsonCreator
    public TmpControl(@JsonProperty("property") CtrlProperty property, @JsonProperty("config") C config) {
        this.property = property;
        this.config = config;
    }
}
