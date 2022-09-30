package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/9/23 14:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserBehaviorDataResponse extends WeComResponse {
    private List<BehaviorData> behaviorData;
}
