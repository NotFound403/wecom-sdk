package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MsgAttachType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2021/4/22 14:53
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class MiniprogramMsgAttachment extends MsgAttachment {
    private final Miniprogram miniprogram;

    @JsonCreator
    public MiniprogramMsgAttachment(@JsonProperty("miniprogram") Miniprogram miniprogram) {
        super(MsgAttachType.MINIPROGRAM);
        this.miniprogram = miniprogram;
    }
}
