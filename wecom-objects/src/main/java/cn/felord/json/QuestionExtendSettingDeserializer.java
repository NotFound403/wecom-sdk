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

import cn.felord.domain.wedoc.form.*;
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
 * @since 2023/8/4 15:44
 */
public class QuestionExtendSettingDeserializer extends JsonDeserializer<QuestionExtendSetting> {

    private static final Map<String, Class<? extends QuestionExtendSetting>> CLASS_HASH_MAP = new HashMap<>();

    static {
        CLASS_HASH_MAP.put("text_setting", TextQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("radio_setting", RadioQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("checkbox_setting", CheckboxQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("location_setting", LocationQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("image_setting", ImageQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("file_setting", FileQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("date_setting", DateQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("time_setting", TimeQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("temperature_setting", TemperatureQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("department_setting", DepartmentQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("member_setting", MemberQuestionExtendSetting.class);
        CLASS_HASH_MAP.put("duration_setting", DurationQuestionExtendSetting.class);
    }

    @Override
    public QuestionExtendSetting deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        p.nextToken();
        String currentName = p.getParsingContext().getCurrentName();
        JsonNode settings = p.getCodec().readTree(p);
        Class<? extends QuestionExtendSetting> configClazz = CLASS_HASH_MAP.get(currentName);
        return configClazz != null ? readTreeAsValue(ctxt, settings, configClazz) : null;
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
