package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;

import java.util.Set;

/**
 * @author xiafang
 * @since 2022/9/23 14:46
 */
@Data
public class GroupChatDataResponse<D extends GroupChatData> extends WeComResponse {
    private Long total;
    private Long nextOffset;
    private Set<D> items;
}
