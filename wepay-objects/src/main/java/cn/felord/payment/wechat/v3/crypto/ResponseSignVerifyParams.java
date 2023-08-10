/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.payment.wechat.v3.crypto;

import lombok.Getter;

/**
 * 响应签名对象
 *
 * @author dax
 * @since 2023 /8/10 16:44
 */
@Getter
public class ResponseSignVerifyParams {
    private final String merchantId;
    /**
     * response.headers['Wechatpay-Serial']    当前使用的微信平台证书序列号
     */
    private final String wechatpaySerial;
    /**
     * response.headers['Wechatpay-Signature']   微信平台签名
     */
    private final String wechatpaySignature;
    /**
     * response.headers['Wechatpay-Signature-Type']   微信平台签名方式
     */
    private final AuthType wechatpaySignatureType;
    /**
     * response.headers['Wechatpay-Timestamp']  微信服务器的时间戳
     */
    private final String wechatpayTimestamp;
    /**
     * response.headers['Wechatpay-Nonce']   微信服务器提供的随机串
     */
    private final String wechatpayNonce;
    /**
     * response.body 微信服务器的响应体
     */
    private final String body;

    /**
     * Instantiates a new Response sign verify params.
     *
     * @param merchantId             the merchant id
     * @param wechatpaySerial        the wechatpay serial
     * @param wechatpaySignature     the wechatpay signature
     * @param wechatpaySignatureType the wechatpay signature type
     * @param wechatpayTimestamp     the wechatpay timestamp
     * @param wechatpayNonce         the wechatpay nonce
     * @param body                   the body
     */
    public ResponseSignVerifyParams(String merchantId,
                                    String wechatpaySerial,
                                    String wechatpaySignature,
                                    String wechatpaySignatureType,
                                    String wechatpayTimestamp,
                                    String wechatpayNonce,
                                    String body) {
        this.merchantId = merchantId;
        this.wechatpaySerial = wechatpaySerial;
        this.wechatpaySignature = wechatpaySignature;
        this.wechatpaySignatureType = AuthType.fromSignType(wechatpaySignatureType);
        this.wechatpayTimestamp = wechatpayTimestamp;
        this.wechatpayNonce = wechatpayNonce;
        this.body = body;
    }
}
