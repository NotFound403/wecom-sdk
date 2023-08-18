package cn.felord.mp.domain.card;

import lombok.Data;

import java.util.List;

@Data
public class CardLandingRequest {
    private String pageTitle;
    private Boolean canShare;
    private String banner;
    private List<CardIdInfo> cardList;
    private String scene;
}