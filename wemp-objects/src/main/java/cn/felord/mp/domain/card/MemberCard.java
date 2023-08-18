package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.CardType;
import lombok.Getter;

/**
 * 会员卡
 *
 * @author xiafang
 * @since 2023/8/18 16:15
 */
@Getter
public class MemberCard extends AbstractCard {
    private final MemberCardInfo memberCard;

    public MemberCard(MemberCardInfo memberCard) {
        super(CardType.MEMBER_CARD);
        this.memberCard = memberCard;
    }
}
