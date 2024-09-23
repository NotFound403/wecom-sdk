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

package cn.felord.payment.wechat.enumeration;

/**
 * 商家券code模式枚举
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
public enum CouponCodeMode {

    /**
     * 系统分配券code。（固定22位纯数字）
     *
     * @since 1.0.4.RELEASE
     */
    WECHATPAY_MODE,
    /**
     * 商户发放时接口指定券code。
     *
     * @since 1.0.4.RELEASE
     */
    MERCHANT_API,
    /**
     * 商户上传自定义code，发券时系统随机选取上传的券code。
     *
     * @since 1.0.4.RELEASE
     */
    MERCHANT_UPLOAD
}
