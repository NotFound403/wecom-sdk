/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package cn.felord.convert;

import com.thoughtworks.xstream.InitializationException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

import java.util.Map;
import java.util.Objects;


/**
 * A single value converter for a special enum type using its string representation.
 *
 * @author J&ouml;rg Schaible
 * @since 1.4.5
 */
public class EventEnumConverter<T extends Enum<T>> extends AbstractSingleValueConverter {

    private final Class<T> enumType;
    private final Map<String, T> strings;


    public EventEnumConverter(Class<T> type, Map<String, T> strings) {
        enumType = type;
        this.strings = strings;
    }


    private static <T> void checkType(Class<T> type) {
        if (!Enum.class.isAssignableFrom(type) && type != Enum.class) {
            throw new InitializationException("Converter can only handle enum types");
        }
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
        Enum<?> eventEnum = (Enum<?>) obj;
        return eventEnum.name().toLowerCase();
    }

    @Override
    public Object fromString(String str) {
        if (str == null) {
            return null;
        }
        return strings.get(str);
    }
}
