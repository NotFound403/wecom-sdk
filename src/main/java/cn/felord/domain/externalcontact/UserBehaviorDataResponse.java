package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author dax
 * @since 2022/9/23 14:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserBehaviorDataResponse extends WeComResponse {
    private Set<BehaviorData> behaviorData;
}
