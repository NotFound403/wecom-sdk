package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/12 15:18
 */
@Data
public class MomentStrategyPrivilege {
    private Boolean viewMomentList;
    private Boolean sendMoment;
    private Boolean manageMomentCoverAndSign;
}
