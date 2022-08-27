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
public class AgentConfigResponse extends JSignatureResponse {
    private String corpid;
    private String agentid;
}
