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

import com.thoughtworks.xstream.InitializationException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * A single value converter for a special enum type using its string representation.
 *
 * @author J&ouml;rg Schaible
 * @since 1.4.5
 */
public class EventEnumConverter<T extends Enum<T>> extends AbstractSingleValueConverter {

    private final Class<T> enumType;
    private final Map<String, T> strings;


    public EventEnumConverter(Class<T> type) {
        this(type, extractStringMap(type));
    }

    public EventEnumConverter(Class<T> type, Map<String, T> strings) {
        enumType = type;
        this.strings = strings;
    }


    private static <T extends Enum<T>> Map<String, T> extractStringMap(Class<T> type) {
        checkType(type);
        return EnumSet.allOf(type)
                .stream()
                .collect(Collectors.toMap(t -> t.name().toLowerCase(), Function.identity()));
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
