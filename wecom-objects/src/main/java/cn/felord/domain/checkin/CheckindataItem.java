package cn.felord.domain.checkin;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class CheckindataItem {
    private Instant checkinTime;
    private String wifiname;
    private String notes;
    private String locationDetail;
    private Integer groupid;
    private String userid;
    private String groupname;
    private String deviceid;
    private String checkinType;
    private String exceptionType;
    private String locationTitle;
    private String wifimac;
    private List<String> mediaids;
    private Integer timelineId;
    private Integer scheduleId;
    private Integer lng;
    private Integer lat;
    private Instant schCheckinTime;
}