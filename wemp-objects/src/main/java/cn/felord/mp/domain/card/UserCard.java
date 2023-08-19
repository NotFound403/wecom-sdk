package cn.felord.mp.domain.card;

import lombok.Data;

import java.time.Instant;

@Data
public class UserCard {
    private Instant beginTime;
    private Instant endTime;
    private String cardId;
}