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
    @XStreamAlias("AgentID")
    private String agentId;

    @XStreamAlias("Content")
    private String content;
    @XStreamAlias("MsgId")
    private String msgId;
    @XStreamAlias("MediaId")
    private String mediaId;
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;
    @XStreamAlias("PicUrl")
    private String picUrl;
    @XStreamAlias("Format")
    private String format;
    @XStreamAlias("Location_X")
    private String latitude;
    @XStreamAlias("Location_Y")
    private String longitude;
    @XStreamAlias("Scale")
    private Integer scale;
    @XStreamAlias("Label")
    private String label;
    @XStreamAlias("AppType")
    private String appType;
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("Url")
    private String url;


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
    @XStreamAlias("Token")
    private final String token;
    @XStreamAlias("OpenKfId")
    private final String openKfId;
}
