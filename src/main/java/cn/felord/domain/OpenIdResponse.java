package cn.felord.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author n1
 * @since 2021/6/17 17:09
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OpenIdResponse extends WeComResponse{
    private String openid;
}
