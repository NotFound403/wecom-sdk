/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.payment.wechat.v3.retrofit;

/**
 * The enum Http headers.
 *
 * @author dax
 * @since 2024/8/4
 */
public enum HttpHeaders {
    /**
     * Content type http headers.
     */
    CONTENT_TYPE("Content-Type"),
    /**
     * Authorization http headers.
     */
    AUTHORIZATION("Authorization"),
    /**
     * Accept http headers.
     */
    ACCEPT("Accept"),
    /**
     * User agent http headers.
     */
    USER_AGENT("User-Agent"),
    /**
     * Meta http headers.
     */
    META("Meta"),
    /**
     * Request id http headers.
     */
    REQUEST_ID("Request-ID"),
    /**
     * Wechat pay serial http headers.
     */
    WECHAT_PAY_SERIAL("Wechatpay-Serial"),
    /**
     * Wechat pay signature http headers.
     */
    WECHAT_PAY_SIGNATURE("Wechatpay-Signature"),
    /**
     * Wechatpay signature type http headers.
     */
    WECHAT_PAY_SIGNATURE_TYPE("Wechatpay-Signature-Type"),
    /**
     * Wechat pay timestamp http headers.
     */
    WECHAT_PAY_TIMESTAMP("Wechatpay-Timestamp"),
    /**
     * Wechat pay nonce http headers.
     */
    WECHAT_PAY_NONCE("Wechatpay-Nonce");
    private final String headerName;

    HttpHeaders(String headerName) {
        this.headerName = headerName;
    }

    /**
     * Header name string.
     *
     * @return the string
     */
    public String headerName() {
        return headerName;
    }
}
