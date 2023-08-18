package cn.felord.mp.domain.card;

import lombok.Data;

@Data
public class Card {
    private MemberCardInfo memberCard;
    private String cardType;
}