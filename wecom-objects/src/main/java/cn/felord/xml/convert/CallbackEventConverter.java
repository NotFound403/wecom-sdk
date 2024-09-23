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

import cn.felord.enumeration.CallbackEvent;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

import java.util.Arrays;
import java.util.Objects;


/**
 * CallbackEvent
 *
 * @author dax
 * @since 1.1.1
 */
public class CallbackEventConverter extends AbstractSingleValueConverter {

    @Override
    public boolean canConvert(Class type) {
        return type != null && CallbackEvent.class.isAssignableFrom(type);
    }

    @Override
    public String toString(Object obj) {
        if (Objects.isNull(obj)) {
            return null;
        }
        CallbackEvent eventEnum = (CallbackEvent) obj;
        return eventEnum.type();
    }

    @Override
    public Object fromString(String str) {
        return Arrays.stream(CallbackEvent.values())
                .filter(callbackEvent -> Objects.equals(callbackEvent.type(), str))
                .findFirst()
                .orElse(null);
    }
}
