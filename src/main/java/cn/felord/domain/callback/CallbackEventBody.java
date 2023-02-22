package cn.felord.domain.callback;

import cn.felord.enumeration.CallbackEvent;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * 回调对象
 *
 * @author felord
 * @since 2021/10/12 21:23
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
    private String userId;


    @XStreamAlias("NewUserID")
    private String newUserId;
    @XStreamAlias("Name")
    private String name;
    @XStreamAlias("Department")
    private String department;
    @XStreamAlias("MainDepartment")
    private Long mainDepartment;
    @XStreamAlias("IsLeaderInDept")
    private String isLeaderInDept;
    @XStreamAlias("Position")
    private String position;
    @XStreamAlias("Mobile")
    private String mobile;
    @XStreamAlias("Gender")
    private Integer Gender;
    @XStreamAlias("Email")
    private String email;
    @XStreamAlias("Status")
    private Integer status;
    @XStreamAlias("Avatar")
    private String avatar;
    @XStreamAlias("Alias")
    private String alias;
    @XStreamAlias("Address")
    private String address;
    @XStreamAlias(value = "ExtAttr", impl = List.class)
    private List<CallbackExtAttrItem> extAttr;

    @XStreamAlias("Id")
    private Integer id;
    @XStreamAlias("ParentId")
    private String parentId;
    @XStreamAlias("Order")
    private Integer order;

    @XStreamAlias("TagId")
    private Integer contactTagId;
    @XStreamAlias("AddUserItems")
    private String addUserItems;
    @XStreamAlias("DelUserItems")
    private String delUserItems;
    @XStreamAlias("AddPartyItems")
    private String addPartyItems;
    @XStreamAlias("DelPartyItems")
    private String delPartyItems;

    @XStreamAlias("ExternalUserID")
    private String externalUserId;
    @XStreamAlias("State")
    private String state;
    @XStreamAlias("WelcomeCode")
    private String welcomeCode;
    @XStreamAlias("Source")
    private String source;
    @XStreamAlias("FailReason")
    private String failReason;

    @XStreamAlias("ChatId")
    private String chatId;
    @XStreamAlias("UpdateDetail")
    private String updateDetail;
    @XStreamAlias("JoinScene")
    private Integer joinScene;
    @XStreamAlias("QuitScene")
    private Integer quitScene;
    @XStreamAlias("MemChangeCnt")
    private Integer memChangeCnt;

    @XStreamAlias("Id")
    private String tagId;
    @XStreamAlias("TagType")
    private String tagType;
    @XStreamAlias("StrategyId")
    private Integer strategyId;

    @XStreamAlias("CalId")
    private String calId;
    @XStreamAlias("ScheduleId")
    private String scheduleId;
    @XStreamAlias("Token")
    private String token;
    @XStreamAlias("OpenKfId")
    private String openKfId;

    @XStreamAlias("EventKey")
    private String eventKey;
    @XStreamAlias("TaskId")
    private String taskId;
    @XStreamAlias("CardType")
    private String cardType;
    @XStreamAlias("ResponseCode")
    private String responseCode;
    @XStreamAlias("SelectedItems")
    private CallbackSelectedItems selectedItems;
}
