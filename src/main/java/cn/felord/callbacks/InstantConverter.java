package cn.felord.callbacks;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

import java.time.Instant;
import java.time.format.DateTimeParseException;

/**
 * @author xiafang
 * @since 2022/10/12 22:15
 */
class InstantConverter extends AbstractSingleValueConverter {
    @Override
    public boolean canConvert(final Class type) {
        return Instant.class == type;
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
