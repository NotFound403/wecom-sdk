package cn.felord.payment.wechat.v3.crypto;

/**
 * The enum Request auth type.
 *
 * @author felord.cn
 * @since 2.0.0
 */
public enum RequestAuthType {
    /**
     * SHA256-RSA2048签名算法
     */
    SHA256_RSA2048("SHA256withRSA", "WECHATPAY2-SHA256-RSA2048 ");

    private final String alg;
    private final String authPrefix;

    RequestAuthType(String alg, String authPrefix) {
        this.alg = alg;
        this.authPrefix = authPrefix;
    }

    /**
     * Gets alg.
     *
     * @return the alg
     */
    public String getAlg() {
        return alg;
    }

    /**
     * Auth prefix string.
     *
     * @param token the token
     * @return the string
     */
    public String toAuthHeader(String token) {
        return authPrefix.concat(token);
    }
}
