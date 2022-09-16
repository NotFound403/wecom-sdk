package cn.felord.domain.externalcontact;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/12 17:23
 */
@AllArgsConstructor
@Getter
public abstract class StrategyCorpTagIterator implements CorpTagIterator {
    private final String strategyId;
}
