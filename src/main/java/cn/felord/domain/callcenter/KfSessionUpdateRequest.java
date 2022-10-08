package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfServiceState;
import lombok.Data;

/**
 * @author dax
 * @since 2022/9/30 14:09
 */
@Data
public class KfSessionUpdateRequest {
    private final String openKfid;
    private final String externalUserid;
    private final KfServiceState serviceState;
    private String servicerUserid;

}
