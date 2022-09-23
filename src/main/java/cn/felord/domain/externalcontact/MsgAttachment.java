package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MsgAttachType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:12
 */
@AllArgsConstructor
@Getter
public abstract class MsgAttachment {
    private final MsgAttachType msgtype;
}
