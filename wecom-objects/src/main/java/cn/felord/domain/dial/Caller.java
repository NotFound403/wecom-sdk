package cn.felord.domain.dial;

import lombok.Data;

@Data
public class Caller {
    /**
     * 主叫用户的通话时长，单位为分钟
     */
    private Integer duration;
    /**
     * 主叫用户的userid
     */
    private String userid;
}