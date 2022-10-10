package cn.felord.callbacks;

import lombok.Data;

/**
 * @author xiafang
 * @since 2022/10/9 15:36
 */
@Data
public class XmlDecryptMsg {
    private final String msgSignature;
    private final String timeStamp;
    private final String nonce;
    private final String xmlBody;
}
