package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;

import java.time.Instant;

/**
 * The type User add event callback response.
 *
 * @author xiafang
 * @since 2022 /10/13 16:43
 */
@Getter
public class UserAddEventCallbackResponse extends XmlCallbackResponse {
    @XStreamAlias("UserID")
    private final String userId;
    @XStreamAlias("Department")
    private final String department;

    public UserAddEventCallbackResponse(String toUserName, String fromUserName, Instant createTime, String msgType, String event, String changeType, String userId, String department) {
        super(toUserName, fromUserName, createTime, msgType, event, changeType);
        this.userId = userId;
        this.department = department;
    }
}
