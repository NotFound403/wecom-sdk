package cn.felord.domain.callcenter;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/6/6
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class UpgradeServiceConfig extends WeComResponse {
    private KFMemberRange memberRange;
    private KfGroupchatRange groupchatRange;
}
