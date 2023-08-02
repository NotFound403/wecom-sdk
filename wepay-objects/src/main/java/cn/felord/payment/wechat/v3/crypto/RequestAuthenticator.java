package cn.felord.payment.wechat.v3.crypto;

import java.net.URI;

/**
 * The interface Request authenticator.
 *
 * @author felord.cn
 * @since 2.0.0
 */
public interface RequestAuthenticator {

    /**
     * Auth header string.
     *
     * @param merchantId the merchant id
     * @param uri        the uri
     * @param httpMethod the http method
     * @param body       the body
     * @return the string
     */
    String authHeader(String merchantId, URI uri, String httpMethod, String body);
}
