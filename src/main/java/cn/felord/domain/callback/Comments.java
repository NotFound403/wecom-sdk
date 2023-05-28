package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.time.Instant;

/**
 * TODO
 *
 * @author dax
 * @since 2023/5/27
 */
@Data
public class Comments {
    @XStreamAlias("CommentUserInfo")
    private UserId commentUserInfo;
    @XStreamAlias("CommentTime")
    private Instant commentTime;
    @XStreamAlias("CommentContent")
    private String commentContent;
    @XStreamAlias("CommentId")
    private String commentId;
}

