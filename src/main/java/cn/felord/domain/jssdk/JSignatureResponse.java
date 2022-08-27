package cn.felord.domain.jssdk;

import lombok.Data;

/**
 * @author dax
 */
@Data
public class JSignatureResponse {
    private String timestamp;
    private String nonceStr;
    private String signature;
}
