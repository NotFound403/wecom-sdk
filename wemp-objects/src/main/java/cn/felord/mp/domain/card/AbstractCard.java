package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.CardType;
import lombok.Getter;

/**
 * @author xiafang
 * @since 2023/8/18 16:01
 */
@Getter
public class AbstractCard {
    private final CardType cardType;

    public AbstractCard(CardType cardType) {
        this.cardType = cardType;
    }
}
