package cn.felord.domain.corpgroup;

import lombok.Data;

/**
 * @author dax
 * @since 2023/10/13
 */
@Data
public class ChainRuleAddRequest {
    private final String chainId;
    private final RuleInfo ruleInfo;
}
