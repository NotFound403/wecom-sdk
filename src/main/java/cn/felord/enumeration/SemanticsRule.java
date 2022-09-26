package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Range type.
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum SemanticsRule {

    /**
     * Phone semantics rule.
     */
    PHONE(1),

    /**
     * Email semantics rule.
     */
    EMAIL(2),
    /**
     * Red envelope semantics rule.
     */
    RED_ENVELOPE(3),
    ;

    private final int rule;

    SemanticsRule(int rule) {
        this.rule = rule;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getRule() {
        return rule;
    }

    /**
     * Deserialize range type.
     *
     * @param rule the rule
     * @return the range type
     */
    @JsonCreator
    public static SemanticsRule deserialize(int rule) {
        return Arrays.stream(SemanticsRule.values())
                .filter(contactType -> contactType.rule == rule)
                .findFirst()
                .orElse(null);
    }

}
