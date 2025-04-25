/*
 * Copyright (c) 2025. felord.cn
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

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;

import java.io.IOException;

/**
 * @author dax
 * @since 2025/4/25
 */
public abstract class AbstractJsonDeserializer<T> extends JsonDeserializer<T> {


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
