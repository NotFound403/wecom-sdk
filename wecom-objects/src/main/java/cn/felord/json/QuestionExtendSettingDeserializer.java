package cn.felord.json;

import cn.felord.domain.approval.*;
import cn.felord.domain.wedoc.form.QuestionExtendSetting;
import cn.felord.enumeration.ApprovalCtrlType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dax
 * @since 2023/8/4 15:44
 */
public class QuestionExtendSettingDeserializer extends JsonDeserializer<QuestionExtendSetting> {

    private static final Map<ApprovalCtrlType, Class<?>> CONTROL_MAP = new HashMap<>();

    static {
        CONTROL_MAP.put(ApprovalCtrlType.TEXT, EmptyConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.TEXTAREA, EmptyConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.NUMBER, EmptyConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.MONEY, EmptyConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.TIPS, EmptyConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.DATE, DateConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.SELECTOR, SelectorConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.CONTACT, ContactConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.TABLE, TableConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.ATTENDANCE, AttendanceConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.VACATION, VacationConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.LOCATION, LocationConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.RELATED_APPROVAL, RelatedApprovalConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.FORMULA, FormulaConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.PHONE_NUMBER, EmptyConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.DATE_RANGE, DateRangeConfig.class);
    }

    @Override
    public QuestionExtendSetting deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode treeNode = p.getCodec().readTree(p);
//        treeNode.
        return null;
    }
}
