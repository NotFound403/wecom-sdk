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

package cn.felord.json;

import cn.felord.domain.approval.*;
import cn.felord.enumeration.ApprovalCtrlType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Tmp control deserializer.
 *
 * @author dax
 * @since 2024/5/26
 */
public class TmpControlDeserializer extends JsonDeserializer<TmpControl<?>> {
    private static final Map<ApprovalCtrlType, Class<? extends ControlConfig>> CONTROL_MAP = new HashMap<>();

    static {
        CONTROL_MAP.put(ApprovalCtrlType.TEXT, EmptyConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.TEXTAREA, EmptyConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.NUMBER, EmptyConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.MONEY, EmptyConfig.class);
        CONTROL_MAP.put(ApprovalCtrlType.TIPS, TipsConfig.class);
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
        //TODO  DOC  WE_DRIVE_FILE
        CONTROL_MAP.put(ApprovalCtrlType.BANK_ACCOUNT, EmptyConfig.class);
    }


    @Override
    public TmpControl<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode treeNode = p.getCodec().readTree(p);
        JsonNode property = treeNode.get("property");
        CtrlProperty ctrlProperty = readTreeAsValue(ctxt, property, CtrlProperty.class);
        ApprovalCtrlType control = ctrlProperty.getControl();
        JsonNode configNode = treeNode.get("config");
        Class<? extends ControlConfig> configClazz = CONTROL_MAP.get(control);
        ControlConfig config = configClazz != null ? readTreeAsValue(ctxt, configNode, configClazz) : new EmptyConfig();
        return new TmpControl<>(ctrlProperty, config);
    }


    /**
     * 兼容2.4版本，2.13版本请直接修改为{@link DeserializationContext#readTreeAsValue(JsonNode, Class)}
     *
     * @param <T>        the type parameter
     * @param context    the context
     * @param n          the n
     * @param targetType the target type
     * @return the t
     * @throws IOException the io exception
     */
    public <T> T readTreeAsValue(DeserializationContext context, JsonNode n, Class<T> targetType) throws IOException {
        if (n == null) {
            return null;
        }
        try (TreeTraversingParser p = _treeAsTokens(context, n)) {
            return context.readValue(p, targetType);
        }
    }

    private TreeTraversingParser _treeAsTokens(DeserializationContext context, JsonNode n) throws IOException {
        // Not perfect but has to do...
        ObjectCodec codec = (context == null) ? null : context.getParser().getCodec();
        TreeTraversingParser p = new TreeTraversingParser(n, codec);
        // important: must initialize...
        p.nextToken();
        return p;
    }

}
