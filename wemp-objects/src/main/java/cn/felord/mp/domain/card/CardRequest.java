package cn.felord.mp.domain.card;

import lombok.Data;

@Data
public class CardRequest<C extends AbstractCard> {
    private final C card;
}