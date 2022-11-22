package cn.felord.domain.callback;

import cn.felord.enumeration.CallbackEvent;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.time.Instant;

/**
 * @author felord
 * @since 2022/10/12 21:23
 */
@XStreamAlias("xml")
@Data
public class CallbackEventBody {
    @XStreamAlias("ToUserName")
    private final String toUserName;
    @XStreamAlias("FromUserName")
    private final String fromUserName;
    @XStreamAlias("CreateTime")
    private final Instant createTime;
    @XStreamAlias("MsgType")
    private final String msgType;
    @XStreamAlias("Event")
    private final CallbackEvent event;
    @XStreamAlias("ChangeType")
    private final String changeType;
    private String agentId;

    @XStreamAlias("UserID")
    private final String userId;
    @XStreamAlias("ExternalUserID")
    private final String externalUserId;
    @XStreamAlias("State")
    private final String state;
    @XStreamAlias("WelcomeCode")
    private final String welcomeCode;
    @XStreamAlias("Source")
    private final String source;
    @XStreamAlias("FailReason")
    private final String failReason;

    @XStreamAlias("ChatId")
    private final String chatId;
    @XStreamAlias("UpdateDetail")
    private final String updateDetail;
    @XStreamAlias("JoinScene")
    private final Integer joinScene;
    @XStreamAlias("QuitScene")
    private final Integer quitScene;
    @XStreamAlias("MemChangeCnt")
    private final Integer MemChangeCnt;

    @XStreamAlias("Id")
    private final String tagId;
    @XStreamAlias("TagType")
    private final String tagType;
    @XStreamAlias("StrategyId")
    private final Integer strategyId;

    @XStreamAlias("CalId")
    private final String calId;
    @XStreamAlias("ScheduleId")
    private final String scheduleId;
}
