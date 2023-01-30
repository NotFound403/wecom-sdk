package cn.felord.domain.contactbook.user;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Duration;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDetailResponse extends WeComResponse {
    private String userid;
    private String openid;
    private String externalUserid;
    private String userTicket;
    private Duration expiresIn;
}
