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

import okhttp3.Headers;

import java.net.URI;

/**
 * 签名生成与校验
 *
 * @author xiafang
 * @since 2023 /8/10 16:39
 */
public interface WechatPaySigner {


    /**
     * 生成请求签名
     *
     * @param appId 应用ID
     * @param uri        请求URI
     * @param httpMethod 请求方法
     * @param body       请求体
     * @return the string
     */
    String sign(String appId, URI uri, String httpMethod, String body);

    /**
     * 生成签名
     *
     * @param appId        the app id
     * @param orderedComponents the ordered components
     * @return the string
     */
    String sign(String appId, String... orderedComponents);

    /**
     * 签名验证
     *
     * @param responseHeaders the response headers
     * @param body            the body
     * @param tenpayKey       the tenpay key
     * @return the boolean
     */
    boolean verify(Headers responseHeaders, String body, TenpayKey tenpayKey);

}
