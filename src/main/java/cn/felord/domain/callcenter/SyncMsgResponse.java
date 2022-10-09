package cn.felord.domain.callcenter;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/12/8 17:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SyncMsgResponse extends WeComResponse {
    private String next_cursor;
    private Integer has_more;
    private List<KfMsg> msgList;
}
