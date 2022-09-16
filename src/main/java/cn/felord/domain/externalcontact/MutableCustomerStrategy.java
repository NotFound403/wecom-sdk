package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;
import java.util.Set;

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
    private Set<CustomerStrategyRange> rangeAdd;
    private Set<CustomerStrategyRange> rangeDel;

}
