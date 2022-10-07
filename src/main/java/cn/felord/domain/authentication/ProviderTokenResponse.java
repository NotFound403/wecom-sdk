package cn.felord.domain.authentication;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author n1
 * @since 2021/6/16 9:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProviderTokenResponse extends WeComResponse {
    private String providerAccessToken;
    private Integer expiresIn;
}
