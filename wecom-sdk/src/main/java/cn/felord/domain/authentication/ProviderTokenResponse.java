package cn.felord.domain.authentication;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author n1
 * @since 2021/6/16 9:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProviderTokenResponse extends AbstractTokenResponse {
    private String providerAccessToken;

    @Override
    public String getToken() {
        return providerAccessToken;
    }
}
