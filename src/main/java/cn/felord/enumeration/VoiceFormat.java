package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Voice format.
 *
 * @author dax
 * @since 2021 /9/8 11:14
 */
public enum VoiceFormat {
    /**
     * Amr voice format.
     */
    AMR(0),
    /**
     * Silk voice format.
     */
    SILK(1);

    private final int type;

    VoiceFormat(int type) {

        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue

    public int getType() {
        return type;
    }

    /**
     * Deserialize voice format.
     *
     * @param type the type
     * @return the voice format
     */
    @JsonCreator
    public static VoiceFormat deserialize(int type) {
        return Arrays.stream(VoiceFormat.values())
                .filter(multiStyle -> multiStyle.type == type)
                .findFirst()
                .orElse(null);
    }
}
