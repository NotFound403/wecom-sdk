package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Objects;

/**
 * The enum Template card type.
 *
 * @author felord
 * @since 2022 /11/23 9:17
 */
public enum TemplateCardType {

    /**
     * Text notice template card type.
     */
    TEXT_NOTICE("text_notice"),
    /**
     * News notice template card type.
     */
    NEWS_NOTICE("news_notice"),
    /**
     * Button interaction template card type.
     */
    BUTTON_INTERACTION("button_interaction"),
    /**
     * Vote interaction template card type.
     */
    VOTE_INTERACTION("vote_interaction"),
    /**
     * Multiple interaction template card type.
     */
    MULTIPLE_INTERACTION("multiple_interaction");

    private final String type;

    TemplateCardType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }

    /**
     * Deserialize range type.
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static TemplateCardType deserialize(String type) {
        return Arrays.stream(TemplateCardType.values())
                .filter(contactType -> Objects.equals(contactType.type, type))
                .findFirst()
                .orElse(null);
    }
}
