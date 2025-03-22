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

package cn.felord.enumeration;

import cn.felord.xml.convert.CallbackTagTypeConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * The enum Callback tag type.
 *
 * @author dax
 * @since 2024 /12/27
 */
@XStreamConverter(CallbackTagTypeConverter.class)
public enum CallbackTagType {
    /**
     * Tag group callback tag type.
     */
    TAG_GROUP("tag_group"),
    /**
     * Tag callback tag type.
     */
    TAG("tag");

    private final String type;

    CallbackTagType(String type) {
        this.type = type;
    }

    /**
     * Event string.
     *
     * @return the string
     */
    public String type() {
        return type;
    }
}
