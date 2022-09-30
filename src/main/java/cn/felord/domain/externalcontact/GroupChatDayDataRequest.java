package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2021/9/23 14:28
 */
@Data
public class GroupChatDayDataRequest {
     private final Instant dayBeginTime;
     private Instant dayEndTime;
     private final OwnerFilter ownerFilter;
}
