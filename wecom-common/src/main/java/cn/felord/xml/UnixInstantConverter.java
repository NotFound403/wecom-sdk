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

package cn.felord.xml;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

import java.time.Instant;
import java.time.format.DateTimeParseException;

/**
 * @author felord
 * @since 2021/10/12 22:15
 */
public class UnixInstantConverter extends AbstractSingleValueConverter {
    @Override
    public boolean canConvert(final Class type) {
        return Instant.class == type;
    }

    @Override
    public String toString(Object obj) {
        Instant instant = (Instant) obj;
        return String.valueOf(instant.toEpochMilli());
    }

    @Override
    public Instant fromString(final String str) {
        try {
            return Instant.ofEpochSecond(Long.parseLong(str));
        } catch (final DateTimeParseException ex) {
            final ConversionException exception = new ConversionException("Cannot parse value as instant", ex);
            exception.add("value", str);
            throw exception;
        }
    }
}
