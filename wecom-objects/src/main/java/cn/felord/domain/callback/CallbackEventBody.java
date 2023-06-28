/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.callback;

import cn.felord.domain.common.MediaId;
import cn.felord.enumeration.CallbackEvent;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
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
public class CallbackEventBody implements Xml {
    private String msgSignature;
    private String timeStamp;
    private String nonce;
    private String encrypt;
    private String originalXml;

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
    private String xmlAgentId;

    @XStreamAlias("ApprovalInfo")
    private ApprovalInfo approvalInfo;

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
    private Integer gender;
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
}
