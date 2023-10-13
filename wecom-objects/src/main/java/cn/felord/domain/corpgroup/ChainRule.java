package cn.felord.domain.corpgroup;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Chain rule.
 *
 * @author dax
 * @since 2023 /10/13
 */
@ToString
@Getter
public class ChainRule {
    private final Integer ruleId;
    private final String chainId;

    /**
     * Instantiates a new Chain rule.
     *
     * @param ruleId  the rule id
     * @param chainId the chain id
     */
    ChainRule(Integer ruleId, String chainId) {
        this.ruleId = ruleId;
        this.chainId = chainId;
    }

    /**
     * From chain rule.
     *
     * @param ruleId  the rule id
     * @param chainId the chain id
     * @return the chain rule
     */
    public static ChainRule from(int ruleId, String chainId) {
        return new ChainRule(ruleId, chainId);
    }

}