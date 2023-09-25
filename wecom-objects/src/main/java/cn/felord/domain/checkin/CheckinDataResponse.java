package cn.felord.domain.checkin;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CheckinDataResponse extends WeComResponse {
    private List<CheckindataItem> checkindata;
}