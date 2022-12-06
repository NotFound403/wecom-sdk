package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MsgAttachType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:12
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "msgtype", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FileMsgAttachment.class, name = "file"),
        @JsonSubTypes.Type(value = ImageMsgAttachment.class, name = "image"),
        @JsonSubTypes.Type(value = LinkMsgAttachment.class, name = "link"),
        @JsonSubTypes.Type(value = MiniprogramMsgAttachment.class, name = "miniprogram"),
        @JsonSubTypes.Type(value = VideoMsgAttachment.class, name = "video"),
})
@AllArgsConstructor
@Getter
public abstract class MsgAttachment {
    private final MsgAttachType msgtype;
}
