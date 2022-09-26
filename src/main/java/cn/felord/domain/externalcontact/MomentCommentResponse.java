package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/10/20 13:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MomentCommentResponse extends WeComResponse {
    private List<InteractionUser> commentList;
    private List<InteractionUser> likeList;

}
