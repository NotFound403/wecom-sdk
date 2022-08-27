package cn.felord.domain.jssdk;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xiafang
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CorpConfigResponse extends JSignatureResponse {
    private final Boolean beta = true;
    private final Boolean debug = false;
    private String appId;
}
