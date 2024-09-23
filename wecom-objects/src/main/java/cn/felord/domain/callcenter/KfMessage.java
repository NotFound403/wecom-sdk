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

package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfMsgOrigin;
import cn.felord.enumeration.KfMsgType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;


/**
 * 读取消息
 *
 * @author dax
 * @since 2021/12/8 17:50
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "msgtype", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextKfMessage.class, name = "text"),
        @JsonSubTypes.Type(value = ImageKfMessage.class, name = "image"),
        @JsonSubTypes.Type(value = VoiceKfMessage.class, name = "voice"),
        @JsonSubTypes.Type(value = VideoKfMessage.class, name = "video"),
        @JsonSubTypes.Type(value = FileKfMessage.class, name = "file"),
        @JsonSubTypes.Type(value = LocationKfMessage.class, name = "location"),
        @JsonSubTypes.Type(value = LinkKfMessage.class, name = "link"),
        @JsonSubTypes.Type(value = BusinessCardKfMessage.class, name = "business_card"),
        @JsonSubTypes.Type(value = MiniprogramKfMessage.class, name = "miniprogram"),
        @JsonSubTypes.Type(value = MenuKfMessage.class, name = "msgmenu"),
        @JsonSubTypes.Type(value = ChannelsShopProductKfMessage.class, name = "channels_shop_product"),
        @JsonSubTypes.Type(value = ChannelsShopOrderKfMessage.class, name = "channels_shop_order"),
        @JsonSubTypes.Type(value = MergedKfMessage.class, name = "merged_msg"),
        @JsonSubTypes.Type(value = ChannelsKfMessage.class, name = "channels"),
        @JsonSubTypes.Type(value = KfMessage.class, name = "meeting"),
        @JsonSubTypes.Type(value = KfMessage.class, name = "schedule"),
        @JsonSubTypes.Type(value = EventKfMessage.class, name = "event")
})
@ToString
@Getter
public class KfMessage {
    private final KfMsgType msgtype;
    private final String msgid;
    private final String openKfid;
    private final String externalUserid;
    private final Instant sendTime;
    private final KfMsgOrigin origin;
    private final String servicerUserid;

    @JsonCreator
    public KfMessage(@JsonProperty("msgtype") KfMsgType msgtype,
                     @JsonProperty("msgid") String msgid,
                     @JsonProperty("open_kfid") String openKfid,
                     @JsonProperty("external_userid") String externalUserid,
                     @JsonProperty("send_time") Instant sendTime,
                     @JsonProperty("origin") KfMsgOrigin origin,
                     @JsonProperty("servicer_userid") String servicerUserid) {
        this.msgtype = msgtype;
        this.msgid = msgid;
        this.openKfid = openKfid;
        this.externalUserid = externalUserid;
        this.sendTime = sendTime;
        this.origin = origin;
        this.servicerUserid = servicerUserid;
    }
}
