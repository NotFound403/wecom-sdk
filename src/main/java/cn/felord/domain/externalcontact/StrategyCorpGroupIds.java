package cn.felord.domain.externalcontact;

import lombok.Getter;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/12 16:46
 */
@Getter
public class StrategyCorpGroupIds extends StrategyCorpTagIterator {
    private final Set<String> groupId;

    public StrategyCorpGroupIds(String strategyId, Set<String> groupId) {
        super(strategyId);
        this.groupId = groupId;
    }
}
