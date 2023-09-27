package cn.felord.domain.checkin;

import lombok.Data;

import java.time.Instant;

@Data
public class DeviceCheckinData {
    private Instant checkinTime;
    private String deviceName;
    private String deviceSn;
    private String userid;
}