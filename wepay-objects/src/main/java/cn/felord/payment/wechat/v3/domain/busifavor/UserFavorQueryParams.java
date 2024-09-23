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
package cn.felord.payment.wechat.v3.domain.busifavor;

import cn.felord.payment.wechat.enumeration.CouponState;

import java.util.HashMap;

/**
 * 根据过滤条件查询用户券API查询参数
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
public class UserFavorQueryParams extends HashMap<String, String> {


    /**
     * Instantiates a new User busi favor query params.
     *
     * @param appid 与当前调用接口商户号有绑定关系的appid。支持小程序appid与公众号appid。
     */
    public UserFavorQueryParams(String appid) {
        this.put("appid", appid);
    }

    /**
     * 商户券批次号
     *
     * @param stockId the stock id
     * @return the user favor query params
     */
    public UserFavorQueryParams stockId(String stockId) {
        this.put("stock_id", stockId);
        return this;
    }

    /**
     * 券状态
     *
     * @param couponState the coupon state
     * @return the user favor query params
     */
    public UserFavorQueryParams couponState(CouponState couponState) {
        this.put("coupon_state", couponState.name());
        return this;
    }

    /**
     * 创建批次的商户号
     *
     * @param creatorMerchant the creator merchant
     * @return the user favor query params
     */
    public UserFavorQueryParams creatorMerchant(String creatorMerchant) {
        this.put("creator_merchant", creatorMerchant);
        return this;
    }

    /**
     * 批次归属商户号
     *
     * @param belongMerchant the belong merchant
     * @return the user favor query params
     */
    public UserFavorQueryParams belongMerchant(String belongMerchant) {
        this.put("belong_merchant", belongMerchant);
        return this;
    }

    /**
     * 批次发放商户号
     *
     * @param senderMerchant the sender merchant
     * @return the user favor query params
     */
    public UserFavorQueryParams senderMerchant(String senderMerchant) {
        this.put("sender_merchant", senderMerchant);
        return this;
    }

    /**
     * 分页页码
     *
     * @param offset the offset
     * @return the user favor query params
     */
    public UserFavorQueryParams offset(long offset) {
        this.put("offset", String.valueOf(offset));
        return this;
    }

    /**
     * 分页大小
     *
     * @param limit the limit
     * @return the user favor query params
     */
    public UserFavorQueryParams limit(long limit) {
        this.put("limit", String.valueOf(limit));
        return this;
    }
}
