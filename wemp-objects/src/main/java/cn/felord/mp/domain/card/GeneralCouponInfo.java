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

package cn.felord.mp.domain.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 优惠券信息
 *
 * @author dax
 * @since 2023 /8/18
 */
@Data
public class GeneralCouponInfo {
    private final BaseInfo baseInfo;
    /**
     * 优惠券专用，填写优惠详情
     */
    private final String defaultDetail;
    private AdvancedInfo advancedInfo;

    /**
     * Instantiates a new General coupon info.
     *
     * @param baseInfo      the base info
     * @param defaultDetail the default detail
     */
    public GeneralCouponInfo(BaseInfo baseInfo, String defaultDetail) {
        this(baseInfo, defaultDetail, null);
    }

    /**
     * Instantiates a new General coupon info.
     *
     * @param baseInfo      the base info
     * @param defaultDetail the default detail
     * @param advancedInfo  the advanced info
     */
    @JsonCreator
    public GeneralCouponInfo(@JsonProperty("base_info") BaseInfo baseInfo,
                             @JsonProperty("default_detail") String defaultDetail,
                             @JsonProperty("advanced_info") AdvancedInfo advancedInfo) {
        this.baseInfo = baseInfo;
        this.defaultDetail = defaultDetail;
        this.advancedInfo = advancedInfo;
    }
}
