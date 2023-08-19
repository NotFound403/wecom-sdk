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
import lombok.Getter;
import lombok.ToString;

/**
 * 团购券信息
 *
 * @author dax
 * @since 2023 /8/18
 */
@ToString
@Getter
public class GroupOnInfo {
    private final BaseInfo baseInfo;
    /**
     * 团购券专用，团购详情。
     * <p>
     * 双人套餐\n -进口红酒一支。\n孜然牛肉一份。
     */
    private final String dealDetail;
    private final AdvancedInfo advancedInfo;

    /**
     * Instantiates a new Group on info.
     *
     * @param baseInfo   the base info
     * @param dealDetail the deal detail
     */
    public GroupOnInfo(BaseInfo baseInfo, String dealDetail) {
        this(baseInfo, dealDetail, null);
    }

    /**
     * Instantiates a new Group on info.
     *
     * @param baseInfo     the base info
     * @param dealDetail   the deal detail
     * @param advancedInfo the advanced info
     */
    @JsonCreator
    public GroupOnInfo(@JsonProperty("base_info") BaseInfo baseInfo,
                       @JsonProperty("deal_detail") String dealDetail,
                       @JsonProperty("advanced_info") AdvancedInfo advancedInfo) {
        this.baseInfo = baseInfo;
        this.dealDetail = dealDetail;
        this.advancedInfo = advancedInfo;
    }
}
