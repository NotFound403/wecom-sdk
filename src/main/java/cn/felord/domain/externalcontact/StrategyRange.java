package cn.felord.domain.externalcontact;

import cn.felord.enumeration.RangeType;
import lombok.Data;

/**
 * @author dax
 * @since 2021/7/12 15:03
 */
@Data
public class StrategyRange {
    private RangeType type;
    private String userid;
    private Integer partyid;
}
