package cn.felord.domain.dial;

import lombok.Data;

@Data
public class Callee {
    /**
     * 被叫用户的通话时长，单位为分钟
     */
    private Integer duration;
    /**
     * 被叫用户的userid
     */
    private String userid;
    /**
     * 被叫用户的号码，当被叫用户为外部用户时返回
     */
    private String phone;
}