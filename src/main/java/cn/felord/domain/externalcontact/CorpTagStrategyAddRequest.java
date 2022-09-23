package cn.felord.domain.externalcontact;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/12 17:51
 */
@AllArgsConstructor
@Getter
public class CorpTagStrategyAddRequest {
    private final Integer strategyId;
    private String groupId;
    private String groupName;
    private Long order;
    private Set<CorpTagBase> tag;
}