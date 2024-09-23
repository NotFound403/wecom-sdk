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
package cn.felord.payment.wechat.v3.domain.payscore;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 后付费商户优惠，选填
 * <p>
 * 最多包含30条商户优惠。如果传入，用户侧则显示此参数。
 *
 * @author felord.cn
 * @since 1.0.2.RELEASE
 */
@ToString
@RequiredArgsConstructor
@Getter
public class PostDiscount {

    /**
     * 总金额，单位分，必填
     */
    private final Long amount;

    /**
     * 优惠名称，条件选填
     * <p>
     * 优惠名称说明；description若填写，则必须同时填写，优惠名称不可重复描述。
     */
    private String name;

    /**
     * 优惠说明，条件选填
     * <p>
     * 优惠使用条件说明。name若填写，则必须同时填写。
     */
    private String description;
    /**
     * 优惠数量，选填。
     * <p>
     * 优惠的数量。
     * 特殊规则：数量限制100，不填时默认1。
     */
    private Long count = 1L;

    /**
     * Instantiates a new Post discount.
     *
     * @param amount      the amount
     * @param name        the name
     * @param description the description
     * @param count       the count
     */
    @JsonCreator
    PostDiscount(@JsonProperty("amount") Long amount,
                 @JsonProperty("name") String name,
                 @JsonProperty("description") String description,
                 @JsonProperty("count") Long count) {
        this.amount = amount;
        this.name = name;
        this.description = description;
        this.count = count;
    }

    /**
     * Name post discount.
     *
     * @param name        the name
     * @param description the description
     * @return the post discount
     */
    public PostDiscount name(String name, String description) {
        this.name = name;
        this.description = description;
        return this;
    }

    /**
     * Count post discount.
     *
     * @param count the count
     * @return the post discount
     */
    public PostDiscount count(Long count) {
        this.count = count;
        return this;
    }
}
