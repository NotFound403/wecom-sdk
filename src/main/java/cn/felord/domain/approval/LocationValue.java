package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/5/27
 */
@ToString
@Getter
public class LocationValue implements ContentDataValue {

    private final Wrapper location;

    @JsonCreator
    public LocationValue(@JsonProperty("location") Wrapper location) {
        this.location = location;
    }

    /**
     * The type Wrapper.
     */
    @Data
    public static class Wrapper {
        private String latitude;
        private String longitude;
        private String title;
        private String address;
        private Instant time;
    }
}
