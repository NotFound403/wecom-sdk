package cn.felord.mp.domain.card;

import lombok.Data;

@Data
public class CardUpdateUserRequest {
    private String recordBonus;
    private String customFieldValue1;
    private String code;
    private Integer balance;
    private Integer addBalance;
    private String customFieldValue2;
    private NotifyOptional notifyOptional;
    private Integer bonus;
    private String recordBalance;
    private Integer addBonus;
    private String backgroundPicUrl;
    private String cardId;
}