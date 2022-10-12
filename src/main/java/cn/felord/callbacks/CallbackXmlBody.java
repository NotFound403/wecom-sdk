package cn.felord.callbacks;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author xiafang
 * @since 2022/10/10 14:21
 */
@XStreamAlias("xml")
@Data
class CallbackXmlBody {
    @XStreamAlias("ToUserName")
    private final String toUserName;
    @XStreamAlias("Encrypt")
    private final String encrypt;
    @XStreamAlias("AgentID")
    private final String agentId;
}
