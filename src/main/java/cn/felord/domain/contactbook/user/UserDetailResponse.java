package cn.felord.domain.contactbook.user;

import com.fasterxml.jackson.annotation.JsonAlias;
import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDetailResponse extends WeComResponse {
    @JsonAlias("UserId")
    private String userId;
    @JsonAlias("DeviceId")
    private String deviceId;
    private String userTicket;
    @JsonAlias("OpenId")
    private String openId;
    private String externalUserid;
}
