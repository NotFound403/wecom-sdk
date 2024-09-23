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

import cn.felord.domain.wedoc.smartsheet.AbstractFilterCondition;
import cn.felord.domain.wedoc.smartsheet.BoolFilterCondition;
import cn.felord.domain.wedoc.smartsheet.DateTimeFilterCondition;
import cn.felord.domain.wedoc.smartsheet.NumberFilterCondition;
import cn.felord.domain.wedoc.smartsheet.StringFilterCondition;
import cn.felord.domain.wedoc.smartsheet.UserFilterCondition;
import com.fasterxml.jackson.core.JacksonException;
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
 * @author dax
 * @since 2024/9/4
 */
public class FilterConditionDeserializer extends JsonDeserializer<AbstractFilterCondition> {

    private static final Map<String, Class<? extends AbstractFilterCondition>> CLASS_HASH_MAP = new HashMap<>();

    static {
        CLASS_HASH_MAP.put("bool_value", BoolFilterCondition.class);
        CLASS_HASH_MAP.put("date_time_value", DateTimeFilterCondition.class);
        CLASS_HASH_MAP.put("number_value", NumberFilterCondition.class);
        CLASS_HASH_MAP.put("string_value", StringFilterCondition.class);
        CLASS_HASH_MAP.put("user_value", UserFilterCondition.class);
    }

    @Override
    public AbstractFilterCondition deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        p.nextToken();
        String currentName = p.getParsingContext().getCurrentName();
        JsonNode condition = p.getCodec().readTree(p);
        Class<? extends AbstractFilterCondition> configClazz = CLASS_HASH_MAP.get(currentName);
        return configClazz != null ? readTreeAsValue(ctxt, condition, configClazz) : null;
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
