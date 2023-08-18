package cn.felord.mp.domain.card;

import lombok.Data;

@Data
public class CardUpdateUserResponse {
    private Integer errcode;
    private String errmsg;
    private String openid;
    private Long resultBalance;
    private Long resultBonus;
}