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

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.domain.WechatPayResponse;
import cn.felord.payment.wechat.v3.domain.certificate.TenpayCertificate;
import retrofit2.http.GET;

import java.util.List;

/**
 * 获取平台证书列表API
 *
 * @author dax
 * @since 2024/8/6
 */
interface InternalCertificateApi {

    /**
     * 获取商户当前可用的平台证书列表。微信支付提供该接口，帮助商户后台系统实现平台证书的平滑更换。
     *
     * @return the Wepay Response
     * @throws PayException the pay exception
     */
    @GET("v3/certificates")
    WechatPayResponse<List<TenpayCertificate>> certificates() throws PayException;
}
