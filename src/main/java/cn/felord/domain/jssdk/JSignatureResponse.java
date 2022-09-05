package cn.felord.domain.jssdk;

import lombok.Data;

/**
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
@Data
public class JSignatureResponse {
    private String timestamp;
    private String nonceStr;
    private String signature;
}
