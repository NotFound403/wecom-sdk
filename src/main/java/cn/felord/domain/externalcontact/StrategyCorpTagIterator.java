package cn.felord.domain.externalcontact;

import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/12 19:23
 */
@Getter
public class StrategyCorpTagIterator {
    private final String strategyId;

    public StrategyCorpTagIterator() {
        this(null);
    }

    public StrategyCorpTagIterator(String strategyId) {
        this.strategyId = strategyId;
    }
}
