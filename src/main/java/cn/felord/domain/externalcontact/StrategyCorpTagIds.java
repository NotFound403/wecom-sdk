package cn.felord.domain.externalcontact;

import lombok.Getter;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/12 16:46
 */
@Getter
public class StrategyCorpTagIds extends StrategyCorpTagIterator {
    private final Set<String> tagId;

    public StrategyCorpTagIds(String strategyId, Set<String> tagId) {
        super(strategyId);
        this.tagId = tagId;
    }
}
