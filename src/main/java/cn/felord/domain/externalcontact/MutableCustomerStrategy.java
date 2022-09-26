package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/12 15:17
 */
@Data
public class MutableCustomerStrategy {
    private Integer strategyId;
    private String strategyName;
    private List<String> adminList;
    private CustomerStrategyPrivilege privilege;
    private List<StrategyRange> rangeAdd;
    private List<StrategyRange> rangeDel;

}
