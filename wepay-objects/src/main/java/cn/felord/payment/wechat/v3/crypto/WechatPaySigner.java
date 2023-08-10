package cn.felord.payment.wechat.v3.crypto;

import java.net.URI;

/**
 * 签名生成与校验
 *
 * @author xiafang
 * @since 2023 /8/10 16:39
 */
public interface WechatPaySigner {


    /**
     * 生成签名
     *
     * @param merchantId 商户ID
     * @param uri        请求URI
     * @param httpMethod 请求方法
     * @param body       请求体
     * @return the string
     */
    String sign(String merchantId, URI uri, String httpMethod, String body);

    /**
     * 签名验证
     *
     * @param params the params
     * @return the boolean
     */
    boolean verify(ResponseSignVerifyParams params);

}
