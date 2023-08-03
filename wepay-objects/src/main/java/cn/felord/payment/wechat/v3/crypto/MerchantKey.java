package cn.felord.payment.wechat.v3.crypto;

import cn.felord.payment.PayException;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyType;
import lombok.Data;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Objects;

/**
 * 商户证书对象
 *
 * @author felord.cn
 * @since 2.0.0
 */
@Data
public final class MerchantKey {
    private final String merchantId;
    private final JWK jwk;


    /**
     * 获取私钥
     *
     * @return the private key
     */
    public PrivateKey toPrivateKey() {
        try {
            if (Objects.equals(KeyType.RSA, jwk.getKeyType())) {
                return jwk.toRSAKey().toPrivateKey();
            } else {
                //TODO SM3
                return jwk.toECKey().toPrivateKey();
            }
        } catch (JOSEException e) {
            throw new PayException("Fail to load key", e);
        }
    }

    public PublicKey toPublicKey() {
        try {
            if (Objects.equals(KeyType.RSA, jwk.getKeyType())) {
                return jwk.toRSAKey().toPublicKey();
            } else {
                //TODO SM3
                return jwk.toECKey().toPublicKey();
            }
        } catch (JOSEException e) {
            throw new PayException("Fail to load key", e);
        }
    }

    /**
     * Obtain serial number string.
     *
     * @return the string
     */
    public String obtainSerialNumber() {
        return jwk.toPublicJWK()
                .getParsedX509CertChain()
                .get(0)
                .getSerialNumber()
                .toString(16)
                .toUpperCase();
    }

}
