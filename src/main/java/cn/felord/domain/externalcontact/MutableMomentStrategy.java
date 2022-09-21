package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author dax
 * @since 2021/7/12 15:17
 */
@Data
public class MutableMomentStrategy {
    private Integer strategyId;
    private String strategyName;
    private List<String> adminList;
    private MomentStrategyPrivilege privilege;
    private Set<StrategyRange> rangeAdd;
    private Set<StrategyRange> rangeDel;

}
