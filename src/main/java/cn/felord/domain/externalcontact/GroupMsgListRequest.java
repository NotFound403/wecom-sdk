package cn.felord.domain.externalcontact;

import cn.felord.enumeration.ChatType;
import cn.felord.enumeration.ListFilterType;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2021/10/19 19:43
 */
@Data
public class GroupMsgListRequest {
    private final Instant startTime;
    private final Instant endTime;
    private final ChatType chatType;
    private String creator;
    private String cursor;
    private ListFilterType filterType;
    private Integer limit;
}
