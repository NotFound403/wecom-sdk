package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.time.Instant;

/**
 * @author xiafang
 * @since 2022/10/12 21:23
 */
@XStreamAlias("xml")
@Data
public class XmlCallbackResponse {
    @XStreamAlias("ToUserName")
    private final String toUserName;
    @XStreamAlias("FromUserName")
    private final String fromUserName;
    @XStreamAlias(value = "CreateTime")
    private final Instant createTime;
    @XStreamAlias("MsgType")
    private final String msgType;
    @XStreamAlias("Event")
    private final String event;
    @XStreamAlias("ChangeType")
    private final String changeType;
    @XStreamAlias("UserID")
    private final String userId;
    @XStreamAlias("ExternalUserID")
    private final String externalUserId;
}
