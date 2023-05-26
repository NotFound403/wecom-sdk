package cn.felord.jackson;

import cn.felord.ObjectMapperFactory;
import cn.felord.domain.approval.*;
import cn.felord.enumeration.ApprovalCtrlType;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author xiafang
 * @since 2023/5/26 16:18
 */
public class MyJsonDeserializer extends JsonDeserializer<TemplateContent> {
    private static final ObjectMapper mapper = ObjectMapperFactory.create();

    @Override
    public TemplateContent deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

        // 读取 JSON 数据中的 type 属性，用于决定具体类型
        JsonNode node = p.getCodec().readTree(p);
        ArrayNode controls1 = (ArrayNode) node.get("controls");
        Iterator<JsonNode> elements = controls1.elements();
        List<TmpControl<?>> controls = new ArrayList<>();
        while (elements.hasNext()) {
            JsonNode property = elements.next().get("property");
            TmpControl<?> tmpControl = this.toTmpControl(property);
            if (tmpControl != null) {
                controls.add(tmpControl);
            }
        }

        TemplateContent templateContent = new TemplateContent();
        templateContent.setControls(controls);
        return templateContent;
    }


    private TmpControl<?> toTmpControl(JsonNode property) throws JsonProcessingException {
        System.out.println("property = " + property);
        String control = property.get("control").asText();
        TypeReference<?> typeReference = configClass(control);
        Type type = typeReference.getType();
        Class<?> aClass = TypeFactory.rawClass(type);
        return (TmpControl<?>) mapper.treeToValue(property, aClass);
    }


    TypeReference<?> configClass(String control) {
        ApprovalCtrlType ctrlType = ApprovalCtrlType.deserialize(control);
        TypeReference<?> type = new TypeReference<TmpControl<EmptyConfig>>() {
        };
        if (Objects.equals(ApprovalCtrlType.DATE, ctrlType)) {
            type = new TypeReference<TmpControl<DateConfig>>() {
            };
        }
        if (Objects.equals(ApprovalCtrlType.SELECTOR, ctrlType)) {
            type = new TypeReference<TmpControl<SelectorConfig>>() {
            };
        }
        if (Objects.equals(ApprovalCtrlType.CONTACT, ctrlType)) {
            type = new TypeReference<TmpControl<ContactConfig>>() {
            };
        }
        if (Objects.equals(ApprovalCtrlType.FILE, ctrlType)) {
            type = new TypeReference<TmpControl<FileConfig>>() {
            };
        }
        if (Objects.equals(ApprovalCtrlType.TABLE, ctrlType)) {
            type = new TypeReference<TmpControl<TableConfig>>() {
            };
        }
        return type;
    }

//    @JsonSubTypes.Type(value = EmptyTmpControl.class, names = {"Text", "Textarea", "Number", "Money", "Tips"}),
//    @JsonSubTypes.Type(value = DateTmpControl.class, name = "Date"),
//    @JsonSubTypes.Type(value = SelectorTmpControl.class, name = "Selector"),
//    @JsonSubTypes.Type(value = ContactTmpControl.class, name = "Contact"),
//    @JsonSubTypes.Type(value = FileTmpControl.class, name = "File"),
//    @JsonSubTypes.Type(value = TableTmpControl.class, name = "Table"),
//    @JsonSubTypes.Type(value = AttendanceTmpControl.class, name = "Attendance"),
//    @JsonSubTypes.Type(value = VacationTmpControl.class, name = "Vacation"),
//    @JsonSubTypes.Type(value = LocationTmpControl.class, name = "Location"),
//    @JsonSubTypes.Type(value = RelatedApprovalTmpControl.class, name = "RelatedApproval"),
//    @JsonSubTypes.Type(value = DateRangeTmpControl.class, name = "DateRange")
}
