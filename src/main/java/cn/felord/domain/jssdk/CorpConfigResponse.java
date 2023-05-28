package cn.felord.domain.jssdk;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author felord.cn
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CorpConfigResponse extends JSignatureResponse {
    private final boolean beta = true;
    private final boolean debug = false;
    private String appId;
}
