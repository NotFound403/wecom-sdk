package cn.felord.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author n1
 * @since 2021/6/16 9:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccessTokenResponse extends WeComResponse {
    private String accessToken;
    private Integer expiresIn;
}
