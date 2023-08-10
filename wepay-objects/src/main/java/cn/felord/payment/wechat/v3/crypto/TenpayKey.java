package cn.felord.payment.wechat.v3.crypto;

import cn.felord.payment.PayException;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyType;
import lombok.Getter;

import java.security.PublicKey;
import java.util.Objects;

/**
 * 微信平台证书
 *
 * @author dax
 * @since 2023 /8/10 13:54
 */
@Getter
public class TenpayKey {
    private final String serialNumber;
    private final JWK tenPayJwk;

    /**
     * Instantiates a new Tenpay public key.
     *
     * @param serialNumber the serial number
     * @param tenPayJwk    the tenPay jwk
     */
    public TenpayKey(String serialNumber, JWK tenPayJwk) {
        this.serialNumber = serialNumber;
        this.tenPayJwk = tenPayJwk;
    }

    /**
     * To public key
     *
     * @return the public key
     */
    public PublicKey toPublicKey() {
        try {
            if (Objects.equals(KeyType.RSA, tenPayJwk.getKeyType())) {
                return tenPayJwk.toRSAKey().toPublicKey();
            } else {
                throw new PayException("Not Support KeyType");
            }
        } catch (JOSEException e) {
            throw new PayException("Fail to load key", e);
        }
    }

    @Override
    public String toString() {
        return "TenpayKey{" +
                ", serialNumber='" + serialNumber + '\'' +
                ", tenPayJwk=[PROTECTED]" +
                '}';
    }
}
