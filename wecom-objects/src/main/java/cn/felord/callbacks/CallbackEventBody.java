/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.callbacks;

import cn.felord.callback.XmlEntity;
import cn.felord.domain.callback.ApprovalInfo;
import cn.felord.domain.callback.BatchJob;
import cn.felord.domain.callback.CallbackArticle;
import cn.felord.domain.callback.CallbackButton;
import cn.felord.domain.callback.CallbackExtAttr;
import cn.felord.domain.callback.CallbackResource;
import cn.felord.domain.callback.CallbackSelectedItems;
import cn.felord.domain.callback.CallbackVideo;
import cn.felord.domain.callback.CorpIds;
import cn.felord.domain.callback.GroupIds;
import cn.felord.domain.callback.Items;
import cn.felord.domain.common.MediaId;
import cn.felord.domain.corpay.miniapppay.callback.RefundCallbackData;
import cn.felord.domain.corpay.miniapppay.callback.TransactionCallbackData;
import cn.felord.enumeration.CallbackChangeType;
import cn.felord.enumeration.CallbackEvent;
import cn.felord.enumeration.ChatGroupJoinScene;
import cn.felord.enumeration.ChatGroupQuitScene;
import cn.felord.enumeration.NotifyType;
import cn.felord.enumeration.PayCallbackEventType;
import cn.felord.enumeration.UpdateDetailType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * 回调对象
 *
 * @author felord
 * @since 2021/10/12 21:23
 */
@XStreamAlias("xml")
@Data
public class CallbackEventBody implements XmlEntity {
    private String msgSignature;
    private String timeStamp;
    private String nonce;
    private String encrypt;
    private String originalXml;
    // xml 中解析的agentid 不一定匹配 比如旧的企业助手为 0
    private String xmlAgentId;
    @XStreamAlias("ToUserName")
    private final String toUserName;
    @XStreamAlias("FromUserName")
    private final String fromUserName;
    @XStreamAlias("CreateTime")
    private final Instant createTime;
    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("Event")
    private CallbackEvent event;
    @XStreamAlias("ChangeType")
    private final CallbackChangeType changeType;
    @XStreamAlias("AgentID")
    private String agentId;
    @XStreamAlias("ApprovalInfo")
    private ApprovalInfo approvalInfo;

    @XStreamAlias("ChainId")
    private String chainId;

    @XStreamAlias("Content")
    private String content;
    @XStreamAlias("MsgId")
    private String msgId;
    @XStreamAlias("Image")
    private MediaId image;
    @XStreamAlias("Voice")
    private MediaId voice;
    @XStreamAlias("Video")
    private CallbackVideo video;
    @XStreamAlias("ArticleCount")
    private Integer articleCount;
    @XStreamAlias(value = "Articles", impl = List.class)
    private List<CallbackArticle> articles;
    @XStreamAlias("Button")
    private CallbackButton Button;

    @XStreamAlias("MediaId")
    private String mediaId;
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;
    @XStreamAlias("PicUrl")
    private String picUrl;
    @XStreamAlias("Format")
    private String format;
    @XStreamAlias("Location_X")
    private String latitudeX;
    @XStreamAlias("Location_Y")
    private String longitudeY;
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
    private Integer gender;
    @XStreamAlias("Email")
    private String email;
    @XStreamAlias("Status")
    private Integer status;
    @XStreamAlias("Avatar")
    private String avatar;
    @XStreamAlias("Alias")
    private String alias;
    @XStreamAlias("Telephone")
    private String telephone;
    @XStreamAlias("Address")
    private String address;
    @XStreamAlias(value = "ExtAttr")
    private CallbackExtAttr extAttr;
    /**
     * 和企业客户标签事件 tagId 冲突 统一用 idOrTagId
     */
    @XStreamAlias("Id")
    private String idOrTagId;
    @XStreamAlias("ParentId")
    private Long parentId;
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

    @XStreamAlias("GroupIds")
    private GroupIds groupIds;
    @XStreamAlias("CorpIds")
    private CorpIds corpIds;

    @XStreamAlias("ChatId")
    private String chatId;
    @XStreamAlias("UpdateDetail")
    private UpdateDetailType updateDetail;
    @XStreamAlias("JoinScene")
    private ChatGroupJoinScene joinScene;
    @XStreamAlias("QuitScene")
    private ChatGroupQuitScene quitScene;
    @XStreamAlias("MemChangeCnt")
    private Integer memChangeCnt;
    @XStreamAlias("MemChangeList")
    private Items memChangeList;
    @XStreamAlias("LastMemVer")
    private String lastMemVer;
    @XStreamAlias("CurMemVer")
    private String curMemVer;

    //  tagId -> idOrTagId;
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
    @XStreamImplicit(itemFieldName = "AuthAddOpenKfId")
    private List<String> authAddOpenKfIds;
    @XStreamImplicit(itemFieldName = "AuthDelOpenKfId")
    private List<String> authDelOpenKfIds;

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
    @XStreamImplicit(itemFieldName = "DocId")
    private List<String> docIds;
    @XStreamImplicit(itemFieldName = "FormId")
    private List<String> formIds;

    @XStreamAlias("Location")
    private String latitude;
    @XStreamAlias("Location")
    private String longitude;
    @XStreamAlias("Precision")
    private String precision;

    @XStreamAlias("BatchJob")
    private BatchJob batchJob;

    @XStreamAlias("LinkId")
    private String linkId;
    @XStreamAlias("ExpireTime")
    private Instant expireTime;
    @XStreamAlias("ExpireQuotaNum")
    private Long expireQuotaNum;

    @XStreamAlias("notify_type")
    private NotifyType notifyType;
    @XStreamAlias("create_time")
    private OffsetDateTime payCreateTime;
    @XStreamAlias("event_type")
    private PayCallbackEventType eventType;
    @XStreamAlias("resource_type")
    private String resourceType;
    @XStreamAlias("resource")
    private CallbackResource resource;
    @XStreamAlias("summary")
    private String summary;
    private TransactionCallbackData transactionCallbackData;
    private RefundCallbackData refundCallbackData;

    @XStreamAlias("Mode")
    private Integer mode;

    @XStreamAlias("LivingId")
    private String livingId;

    @XStreamAlias("BookingId")
    private String bookingId;
    @XStreamAlias("MeetingRoomId")
    private String meetingRoomId;
}
