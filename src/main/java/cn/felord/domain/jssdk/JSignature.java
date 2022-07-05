package cn.felord.domain.jssdk;

import lombok.Data;

/**
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
@Data
public class JSignature {
    private String timestamp;
    private String noncestr;
    private String url;
    private String signature;
}
