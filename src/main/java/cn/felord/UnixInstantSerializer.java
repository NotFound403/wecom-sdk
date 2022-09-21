package cn.felord;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;

/**
 * @author dax
 * @since 2021/10/20 10:30
 */
class UnixInstantSerializer extends JsonSerializer<Instant> {
    static final UnixInstantSerializer INSTANCE = new UnixInstantSerializer();

    @Override
    public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            gen.writeNumber(value.getEpochSecond());
        }
    }
}
