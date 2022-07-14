package cn.felord.domain.jssdk;

import lombok.Data;
import org.springframework.lang.Nullable;

/**
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
@Data
public class JSignature {
    private String corpId;
    @Nullable
    private String agentId;
    private String timestamp;
    private String noncestr;
    private String url;
    private String signature;
}
