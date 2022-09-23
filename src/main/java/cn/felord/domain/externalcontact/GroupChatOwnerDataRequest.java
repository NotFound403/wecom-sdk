package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2022/9/23 14:28
 */
@Data
public class GroupChatOwnerDataRequest {
     private final Instant dayBeginTime;
     private Instant dayEndTime;
     private final OwnerFilter ownerFilter;
     private Long orderBy;
     private Long orderAsc;
     private Long offset;
     private Long limit;
}
