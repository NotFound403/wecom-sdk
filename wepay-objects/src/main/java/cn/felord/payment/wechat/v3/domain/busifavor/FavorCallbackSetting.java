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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

/**
 * 设置商家券事件通知地址API请求参数
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
@ToString
@Getter
public class FavorCallbackSetting {

    /**
     * 微信支付商户的商户号，由微信支付生成并下发，不填默认查询调用方商户的通知URL。
     */
    private String mchid;
    /**
     * 商户提供的用于接收商家券事件通知的url地址，必须支持https。
     */
    private final String notifyUrl;
    /**
     * 修改时间,返回
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime updateTime;

    /**
     * Instantiates a new Busi favor callback setting.
     *
     * @param notifyUrl the notify url
     */
    public FavorCallbackSetting(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }


    /**
     * Instantiates a new Busi favor callback setting.
     *
     * @param notifyUrl the notify url
     * @param mchid     the mchid
     */
    public FavorCallbackSetting(String notifyUrl, String mchid) {
        this.notifyUrl = notifyUrl;
        this.mchid = mchid;
    }

    /**
     * Instantiates a new Busi favor callback setting.
     *
     * @param mchid      the mchid
     * @param notifyUrl  the notify url
     * @param updateTime the update time
     */
    @JsonCreator
    FavorCallbackSetting(String mchid,
                         @JsonProperty("notify_url") String notifyUrl,
                         @JsonProperty("update_time") OffsetDateTime updateTime) {
        this.mchid = mchid;
        this.notifyUrl = notifyUrl;
        this.updateTime = updateTime;
    }
}
