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

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

/**
 * 核销用户券请求参数
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
@ToString
@Getter
public class FavorUseParams {
    /**
     * 券code
     */
    private final String couponCode;
    /**
     * 批次号
     */
    private final String stockId;
    /**
     * 公众账号ID
     */
    private final String appid;
    /**
     * 请求核销时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private final OffsetDateTime useTime;
    /**
     * 核销请求单据号,商户侧保证唯一
     */
    private final String useRequestNo;
    /**
     * 用户标识，用户的唯一标识，做安全校验使用
     */
    private final String openid;

    /**
     * Instantiates a new Busi favor use params.
     *
     * @param couponCode   the coupon code
     * @param appid        the appid
     * @param useTime      the use time
     * @param useRequestNo the use request no
     */
    public FavorUseParams(String couponCode, String appid, OffsetDateTime useTime, String useRequestNo) {
        this(couponCode, appid, useTime, useRequestNo, null);
    }

    /**
     * Instantiates a new Busi favor use params.
     *
     * @param couponCode   the coupon code
     * @param appid        the appid
     * @param useTime      the use time
     * @param useRequestNo the use request no
     * @param stockId      the stock id
     */
    public FavorUseParams(String couponCode, String appid, OffsetDateTime useTime, String useRequestNo, String stockId) {
        this(couponCode, appid, useTime, useRequestNo, stockId, null);
    }

    /**
     * Instantiates a new Busi favor use params.
     *
     * @param couponCode   the coupon code
     * @param appid        the appid
     * @param useTime      the use time
     * @param useRequestNo the use request no
     * @param stockId      the stock id
     * @param openid       the openid
     */
    public FavorUseParams(String couponCode, String appid, OffsetDateTime useTime, String useRequestNo, String stockId, String openid) {
        this.couponCode = couponCode;
        this.stockId = stockId;
        this.appid = appid;
        this.useTime = useTime;
        this.useRequestNo = useRequestNo;
        this.openid = openid;
    }
}
