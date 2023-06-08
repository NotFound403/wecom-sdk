package cn.felord.domain.callcenter;

import lombok.Data;

/**
 * @author xiafang
 * @since 2023/6/7 14:07
 */
@Data
public class KfExternalUser {
    private String external_userid;
    private String nickname;
    private String avatar;
    private int gender;
    private String unionid;
    private KfEnterSessionContext enterSessionContext;
}
