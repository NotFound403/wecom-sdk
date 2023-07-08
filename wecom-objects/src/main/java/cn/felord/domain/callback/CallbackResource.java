package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author dax
 * @since 2023/7/7 11:46
 */
@Data
public class CallbackResource {
    /**
     * 对开启结果数据进行加密的加密算法，目前只支持AEAD_AES_256_GCM。
     */
    @XStreamAlias("algorithm")
    private String algorithm;
    /**
     * Base64编码后的开启/停用结果数据密文。
     */
    @XStreamAlias("ciphertext")
    private String ciphertext;
    /**
     * 附加数据。
     */
    @XStreamAlias("associated_data")
    private String associatedData;
    /**
     * 加密使用的随机串。
     */
    @XStreamAlias("nonce")
    private String nonce;
}
