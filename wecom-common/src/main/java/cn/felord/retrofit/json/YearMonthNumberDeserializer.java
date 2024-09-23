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

package cn.felord.retrofit.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.JSR310DateTimeDeserializerBase;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * The type Year month number deserializer.
 *
 * @author dax
 * @since 2024/9/26
 */
public class YearMonthNumberDeserializer extends JSR310DateTimeDeserializerBase<YearMonth> {
    /**
     * NOTE: only {@code public} so that use via annotations (see [modules-java8#202])
     * is possible
     */
    public YearMonthNumberDeserializer() // public since 2.12
    {
        this(DateTimeFormatter.ofPattern("u-MM"));
    }

    /**
     * Instantiates a new Year month number deserializer.
     *
     * @param formatter the formatter
     */
    public YearMonthNumberDeserializer(DateTimeFormatter formatter) {
        super(YearMonth.class, formatter);
    }

    /**
     * Since 2.11
     *
     * @param base     the base
     * @param leniency the leniency
     */
    protected YearMonthNumberDeserializer(YearMonthNumberDeserializer base, Boolean leniency) {
        super(base, leniency);
    }

    @Override
    protected YearMonthNumberDeserializer withDateFormat(DateTimeFormatter dtf) {
        return new YearMonthNumberDeserializer(dtf);
    }

    @Override
    protected YearMonthNumberDeserializer withLeniency(Boolean leniency) {
        return new YearMonthNumberDeserializer(this, leniency);
    }

    @Override
    protected YearMonthNumberDeserializer withShape(JsonFormat.Shape shape) {
        return this;
    }

    @Override
    public YearMonth deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        if (parser.hasToken(JsonToken.VALUE_STRING)) {
            return _fromString(parser, context, parser.getText());
        }
        // 30-Sep-2020, tatu: New! "Scalar from Object" (mostly for XML)
        if (parser.isExpectedStartObjectToken()) {
            return _fromString(parser, context,
                    context.extractScalarFromObject(parser, this, handledType()));
        }
        if (parser.isExpectedStartArrayToken()) {
            JsonToken t = parser.nextToken();
            if (t == JsonToken.END_ARRAY) {
                return null;
            }
            if ((t == JsonToken.VALUE_STRING || t == JsonToken.VALUE_EMBEDDED_OBJECT)
                    && context.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                final YearMonth parsed = deserialize(parser, context);
                if (parser.nextToken() != JsonToken.END_ARRAY) {
                    handleMissingEndArrayForSingle(parser, context);
                }
                return parsed;
            }
            if (t != JsonToken.VALUE_NUMBER_INT) {
                _reportWrongToken(context, JsonToken.VALUE_NUMBER_INT, "years");
            }
            int year = parser.getIntValue();
            int month = parser.nextIntValue(-1);
            if (month == -1) {
                if (!parser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
                    _reportWrongToken(context, JsonToken.VALUE_NUMBER_INT, "months");
                }
                month = parser.getIntValue();
            }
            if (parser.nextToken() != JsonToken.END_ARRAY) {
                throw context.wrongTokenException(parser, handledType(), JsonToken.END_ARRAY,
                        "Expected array to end");
            }
            return YearMonth.of(year, month);
        }
        if (parser.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
            return (YearMonth) parser.getEmbeddedObject();
        }
        if (parser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
            return _fromString(parser, context, parser.getText());
        }
        return _handleUnexpectedToken(context, parser,
                JsonToken.VALUE_STRING, JsonToken.START_ARRAY);
    }

    /**
     * From string year month.
     *
     * @param p       the p
     * @param ctxt    the ctxt
     * @param string0 the string 0
     * @return the year month
     * @throws IOException the io exception
     */
    protected YearMonth _fromString(JsonParser p, DeserializationContext ctxt,
                                    String string0) throws IOException {
        String string = string0.trim();
        if (string.isEmpty()) {
            // 22-Oct-2020, tatu: not sure if we should pass original (to distinguish
            //   b/w empty and blank); for now don't which will allow blanks to be
            //   handled like "regular" empty (same as pre-2.12)
            return _fromEmptyString(p, ctxt, string);
        }
        try {
            return YearMonth.parse(string, _formatter);
        } catch (DateTimeException e) {
            return _handleDateTimeException(ctxt, e, string);
        }
    }
}
