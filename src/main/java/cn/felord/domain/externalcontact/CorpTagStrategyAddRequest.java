package cn.felord.domain.externalcontact;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/12 19:51
 */
@AllArgsConstructor
@Getter
public class CorpTagStrategyAddRequest {
    private final Integer strategyId;
    private String groupId;
    private String groupName;
    private Long order;
    private List<CorpTagBase> tag;
}
