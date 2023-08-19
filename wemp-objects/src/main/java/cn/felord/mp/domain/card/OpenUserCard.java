package cn.felord.mp.domain.card;

import lombok.Data;

/**
 * @author dax
 * @since 2023/8/19
 */
@Data
public class OpenUserCard {
    private final String openid;
    private final String cardId;
}
