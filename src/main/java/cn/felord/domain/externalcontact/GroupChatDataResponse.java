package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/9/23 14:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupChatDataResponse<D extends GroupChatData> extends WeComResponse {
    private Long total;
    private Long nextOffset;
    private List<D> items;
}
