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

package cn.felord.mp.domain.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 使用门槛（条件）字段，
 * 若不填写使用条件则在券面拼写 ：无最低消费限制，全场通用，不限品类；并在使用说明显示： 可与其他优惠共享
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@ToString
@Getter
public class UseCondition {
    /**
     * 指定可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写适用于xxx
     */
    private String acceptCategory;
    /**
     * 指定不可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写不适用于xxxx
     */
    private String rejectCategory;
    /**
     * 满减门槛字段，可用于兑换券和代金券 ，填入后将在全面拼写消费满xx元可用。
     */
    private Integer leastCost;
    /**
     * 购买xx可用类型门槛，仅用于兑换 ，填入后自动拼写购买xxx可用
     */
    private String objectUseFor;
    /**
     * 不可以与其他类型共享门槛 ，
     * 填写false时系统将在使用须知里 拼写“不可与其他优惠共享”，
     * 填写true时系统将在使用须知里 拼写“可与其他优惠共享”， 默认为true
     */
    private Boolean canUseWithOtherDiscount;

    /**
     * Instantiates a new Use condition.
     */
    public UseCondition() {
    }

    /**
     * Instantiates a new Use condition.
     *
     * @param acceptCategory          the accept category
     * @param rejectCategory          the reject category
     * @param leastCost               the least cost
     * @param objectUseFor            the object use for
     * @param canUseWithOtherDiscount the can use with other discount
     */
    @JsonCreator
    UseCondition(@JsonProperty("accept_category") String acceptCategory,
                 @JsonProperty("reject_category") String rejectCategory,
                 @JsonProperty("least_cost") Integer leastCost,
                 @JsonProperty("object_use_for") String objectUseFor,
                 @JsonProperty("can_use_with_other_discount") Boolean canUseWithOtherDiscount) {
        this.acceptCategory = acceptCategory;
        this.rejectCategory = rejectCategory;
        this.leastCost = leastCost;
        this.objectUseFor = objectUseFor;
        this.canUseWithOtherDiscount = canUseWithOtherDiscount;
    }

    /**
     * Accept category use condition.
     *
     * @param acceptCategory the accept category
     * @return the use condition
     */
    public UseCondition acceptCategory(String acceptCategory) {
        this.acceptCategory = acceptCategory;
        return this;
    }

    /**
     * Reject category use condition.
     *
     * @param rejectCategory the reject category
     * @return the use condition
     */
    public UseCondition rejectCategory(String rejectCategory) {
        this.rejectCategory = rejectCategory;
        return this;
    }

    /**
     * Least cost use condition.
     *
     * @param leastCost the least cost
     * @return the use condition
     */
    public UseCondition leastCost(Integer leastCost) {
        this.leastCost = leastCost;
        return this;
    }

    /**
     * Object use for use condition.
     *
     * @param objectUseFor the object use for
     * @return the use condition
     */
    public UseCondition objectUseFor(String objectUseFor) {
        this.objectUseFor = objectUseFor;
        return this;
    }

    /**
     * Can use with other discount use condition.
     *
     * @param canUseWithOtherDiscount the can use with other discount
     * @return the use condition
     */
    public UseCondition canUseWithOtherDiscount(Boolean canUseWithOtherDiscount) {
        this.canUseWithOtherDiscount = canUseWithOtherDiscount;
        return this;
    }
}
