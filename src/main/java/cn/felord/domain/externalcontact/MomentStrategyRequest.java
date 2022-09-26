
package cn.felord.domain.externalcontact;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/12 15:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MomentStrategyRequest extends MomentStrategyDetail{
    private List<StrategyRange> range;
}
