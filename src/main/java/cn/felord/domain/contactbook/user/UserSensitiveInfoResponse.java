package cn.felord.domain.contactbook.user;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserSensitiveInfoResponse extends WeComResponse {
   private String userid;
   private String gender;
   private String avatar;
   private String qrCode;
   private String mobile;
   private String email;
   private String bizMail;
   private String address;
}
