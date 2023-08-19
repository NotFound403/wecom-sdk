package cn.felord.mp.domain.card;

import cn.felord.mp.domain.MpResponse;
import cn.felord.mp.enumeration.UserCardStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type User card response.
 *
 * @author dax
 * @since 2023 /8/18 18:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserCardResponse extends MpResponse {
    private String openid;
    private UserCard card;
    private boolean canConsume;
    private UserCardStatus userCardStatus;
}