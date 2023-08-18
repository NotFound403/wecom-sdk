package cn.felord.mp.domain.card;

import lombok.Data;

@Data
public class CardLandingResponse {
    private Integer errcode;
    private String errmsg;
    private String url;
    private String pageId;
}