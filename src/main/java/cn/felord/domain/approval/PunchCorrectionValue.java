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
public class PunchCorrectionValue implements ContentDataValue {
    private final Wrapper punchCorrection;

    @JsonCreator
    public PunchCorrectionValue(@JsonProperty("punchCorrection") Wrapper punchCorrection) {
        this.punchCorrection = punchCorrection;
    }

    /**
     * The type Wrapper.
     */
    @Data
    public static class Wrapper {
        private String state;
        private Instant time;

    }

}
