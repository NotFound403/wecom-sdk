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
package cn.felord.xml.convert;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

import java.util.Arrays;
import java.util.Objects;


/**
 * A single value converter for a special enum type using its string representation.
 *
 * @author J&ouml;rg Schaible
 * @since 1.4.5
 */
public class NumberEnumConverter<T extends Enum<T> & CallbackNumberEnum> extends AbstractSingleValueConverter {
    private final Class<T> enumType;

    public NumberEnumConverter(Class<T> type) {
        this.enumType = type;
    }

    @Override
    public boolean canConvert(Class type) {
        return type != null && enumType.isAssignableFrom(type);
    }

    @Override
    public String toString(Object obj) {
        if (Objects.isNull(obj)) {
            return null;
        }
        CallbackNumberEnum callbackNumberEnum = (CallbackNumberEnum) obj;
        return String.valueOf(callbackNumberEnum.getType());
    }

    @Override
    public Object fromString(String str) {
        return Arrays.stream(enumType.getEnumConstants())
                .filter(enumInstance ->
                        Objects.equals(String.valueOf(enumInstance.getType()), str))
                .findAny()
                .orElse(null);
    }
}
