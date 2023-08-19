package cn.felord.mp.domain.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type User card info.
 *
 * @author dax
 * @since 2023 /8/19
 */
@ToString
@Getter
public class UserCardInfo {
    /**
     * 单张卡券code
     */
    private final String code;
    /**
     * 卡券ID代表一类卡券。自定义code卡券必填。
     */
    private final String cardId;

    /**
     * Instantiates a new User card info.
     *
     * @param code the code
     */
    public UserCardInfo(String code) {
        this(code, null);
    }

    /**
     * Instantiates a new User card info.
     *
     * @param code   the code
     * @param cardId the card id
     */
    @JsonCreator
    public UserCardInfo(@JsonProperty("code") String code, @JsonProperty("card_id") String cardId) {
        this.code = code;
        this.cardId = cardId;
    }
}
