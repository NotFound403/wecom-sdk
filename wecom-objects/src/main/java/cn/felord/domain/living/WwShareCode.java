package cn.felord.domain.living;

import lombok.Data;

/**
 * The WwShareCode
 *
 * @author dax
 * @since 2023 /11/23
 */
@Data
public class WwShareCode {
    /**
     * “推广产品”直播观众跳转小程序商城时会在小程序path中带上ww_share_code=xxxxx参数，ww_share_code五分钟内有效
     */
    private final String wwShareCode;
}