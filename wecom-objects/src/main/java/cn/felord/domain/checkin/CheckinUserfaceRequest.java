package cn.felord.domain.checkin;

import lombok.Data;

@Data
public class CheckinUserfaceRequest {
    private final String userid;
    private final String userface;
}