package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;
import java.util.Set;

/**
 * @author dax
 * @since 2021/7/12 19:06
 */
@Data
public class UserBehaviorDataRequest {
     private final Instant startTime;
     private final Instant endTime;
     private Set<String> userid;
     private Set<Integer> partyid;
}
