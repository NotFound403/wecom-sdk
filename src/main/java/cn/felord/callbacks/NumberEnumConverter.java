/*
 * Copyright (C) 2013, 2016, 2018 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 *
 * Created on 14. March 2013 by Joerg Schaible
 */
package cn.felord.callbacks;

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
