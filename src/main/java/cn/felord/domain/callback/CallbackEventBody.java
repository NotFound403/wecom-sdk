package cn.felord.domain.callback;

import cn.felord.enumeration.CallbackEvent;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.time.Instant;
import java.util.List;

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


    @XStreamAlias("NewUserID")
    private final String newUserId;
    @XStreamAlias("Name")
    private final String name;
    @XStreamAlias("Department")
    private final String department;
    @XStreamAlias("MainDepartment")
    private final Integer mainDepartment;
    @XStreamAlias("IsLeaderInDept")
    private final String isLeaderInDept;
    @XStreamAlias("Position")
    private final String position;
    @XStreamAlias("Mobile")
    private final String mobile;
    @XStreamAlias("Gender")
    private final Integer Gender;
    @XStreamAlias("Email")
    private final String email;
    @XStreamAlias("Status")
    private final Integer status;
    @XStreamAlias("Avatar")
    private final String avatar;
    @XStreamAlias("Alias")
    private final String alias;
    @XStreamAlias("Address")
    private final String address;
    @XStreamAlias("ExtAttr")
    private final List<Item> extAttr;

    @XStreamAlias("Id")
    private final Integer id;
    @XStreamAlias("ParentId")
    private final String parentId;
    @XStreamAlias("Order")
    private final Integer order;

    @XStreamAlias("TagId")
    private Integer contactTagId;
    @XStreamAlias("AddUserItems")
    private final String addUserItems;
    @XStreamAlias("DelUserItems")
    private final String delUserItems;
    @XStreamAlias("AddPartyItems")
    private final String addPartyItems;
    @XStreamAlias("DelPartyItems")
    private final String delPartyItems;

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
    private final Integer memChangeCnt;

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

    @XStreamAlias("Item")
    @Data
    public static class Item {
        @XStreamAlias("Type")
        private Integer type;
        @XStreamAlias("Name")
        private String name;
        @XStreamAlias("Web")
        private Web web;
        @XStreamAlias("Text")
        private Text text;

        @Data
        public static class Web {
            @XStreamAlias("Title")
            private String title;
            @XStreamAlias("Url")
            private String url;
        }

        @Data
        public static class Text {
            @XStreamAlias("Value")
            private String value;
        }
    }
}
