package cn.felord.callbacks;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author felord
 * @since 2021/10/10 14:21
 */
@XStreamAlias("xml")
@Data
class CallbackXmlResponse implements CallbackResponse {
    @XStreamAlias("Encrypt")
    private final String encrypt;
    @XStreamAlias("MsgSignature")
    private final String msgSignature;
    @XStreamAlias("TimeStamp")
    private final String timeStamp;
    @XStreamAlias("Nonce")
    private final String nonce;
}
