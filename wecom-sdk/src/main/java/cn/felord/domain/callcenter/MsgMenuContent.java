package cn.felord.domain.callcenter;

import cn.felord.enumeration.MsgMenuContentType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dax
 * @since 2023/6/3
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ClickMsgMenuContent.class, name = "click"),
        @JsonSubTypes.Type(value = ViewMsgMenuContent.class, name = "view"),
        @JsonSubTypes.Type(value = MiniprogramMsgMenuContent.class, name = "miniprogram"),
})
@AllArgsConstructor
@Getter
public abstract class MsgMenuContent {
    private final MsgMenuContentType type;
}
