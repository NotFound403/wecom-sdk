package cn.felord.domain.externalcontact;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

/**
 * @author dax
 * @since 2021/9/23 14:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupChatDataByDay extends GroupChatData {
    private Instant statTime;
}
