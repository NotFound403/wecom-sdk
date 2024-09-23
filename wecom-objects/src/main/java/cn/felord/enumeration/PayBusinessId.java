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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * PayOrgType
 *
 * @author dax
 * @see <a href="https://developer.work.weixin.qq.com/document/path/98973#business_id">经营范围对照表</a>
 * @since 2024/5/25 16:19
 */
public enum PayBusinessId {


    /**
     * 其他
     */
    OTHERS(0),
    /**
     * 餐饮
     */
    CATERING(1),
    /**
     * 零售
     */
    RETAIL(2),
    /**
     * 食品生鲜
     */
    FRESH_FOOD(3),
    /**
     * 文物经营/文物复制品销售
     */
    CULTURAL_RELIC(4),
    /**
     * 房地产
     */
    REAL_ESTATE(5),
    /**
     * 房产中介
     */
    REAL_ESTATE_AGENTS(6),
    /**
     * 宠物医院
     */
    PET_HOSPITAL(7),
    /**
     * 保健器械/医疗器械/非处方药品
     */
    DEVICES_DRUGS(8),
    /**
     * 私立/民营医院/诊所
     */
    NON_PUB_MEDICAL_INS(9),
    /**
     * 居民生活服务
     */
    LIFE_SERVICES(10),
    /**
     * 旅行社
     */
    TRAVEL_AGENCY(11),
    /**
     * 网吧
     */
    NET_BAR(12),
    /**
     * 院线影城
     */
    CINEMA_STUDIOS(13),
    /**
     * 咨询/娱乐票务
     */
    ASK_OR_ETICKET(14),
    /**
     * 景区/酒店
     */
    SCENIC_OR_HOTEL(15),
    /**
     * 休闲娱乐
     */
    RECREATION(16),
    /**
     * 演出赛事 pay business id.
     */
    PERFORMANCE_EVENTS(17),
    /**
     * 游艺厅/KTV
     */
    KTV(18),
    /**
     * 船舶/海运服务
     */
    SHIP_SERVICE(19),
    /**
     * 铁路客运
     */
    RAILWAY(20),
    /**
     * 有线电视缴费
     */
    TV_FEE(21),
    /**
     * 其他缴费
     */
    OTHER_FEE(22),
    /**
     * 快递
     */
    EXPRESS(23),
    /**
     * 物流
     */
    LOGISTICS(24),
    /**
     * 速送
     */
    DELIVERY(25),
    /**
     * 保险业务
     */
    INSURANCE(26),
    /**
     * 停车缴费
     */
    PARKING_FEE(27),
    /**
     * 培训机构
     */
    TRAINING_INSTITUTIONS(28),
    /**
     * 城市公共交通
     */
    URBAN_PUB_TRANS(29),
    /**
     * 高速公路收费
     */
    HIGHWAY_TOLLS(30);
    private final int type;

    PayBusinessId(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }


    /**
     * Deserialize PayBusinessId
     *
     * @param type the type
     * @return the date ctrl type
     */
    @JsonCreator
    public static PayBusinessId deserialize(int type) {
        return Arrays.stream(PayBusinessId.values())
                .filter(payBusinessId -> payBusinessId.type == type)
                .findFirst()
                .orElse(null);
    }
}
