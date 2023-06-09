package cn.felord.domain.authentication;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type Abstract token response.
 *
 * @author dax
 * @since 2023 /5/24 17:22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractTokenResponse extends WeComResponse {
    private Integer expiresIn;

    /**
     * Gets token.
     *
     * @return the token
     */
    public abstract String getToken();
}
