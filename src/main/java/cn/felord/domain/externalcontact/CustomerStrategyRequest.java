package cn.felord.domain.externalcontact;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2021/7/12 15:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerStrategyRequest extends CustomerStrategyDetail{
    private CustomerStrategyRange range;
}
