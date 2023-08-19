package cn.felord.mp.domain.card;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Card consume request.
 *
 * @author dax
 * @since 2023 /8/18
 */
@ToString
@Getter
public class UserCardRequest extends UserCardInfo {

    /**
     * 是否校验code核销状态，填入true和false时的code异常状态返回数据不同。
     */
    private final boolean checkConsume;


    /**
     * Instantiates a new User card request.
     *
     * @param code         the code
     * @param checkConsume the check consume
     */
    public UserCardRequest(String code, boolean checkConsume) {
        super(code);
        this.checkConsume = checkConsume;
    }

    /**
     * Instantiates a new User card request.
     *
     * @param code         the code
     * @param checkConsume the check consume
     * @param cardId       the card id
     */
    public UserCardRequest(String code, boolean checkConsume, String cardId) {
        super(code, cardId);
        this.checkConsume = checkConsume;
    }
}