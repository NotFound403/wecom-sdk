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

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Modify request.
 */
@ToString
@Getter
public class ModifyRequest {
    private final String serviceId;
    private final String appid;
    private final List<PostPayment> postPayments;
    private final String reason;
    private final Integer totalAmount;
    private final List<PostDiscount> postDiscounts;

    /**
     * Instantiates a new Modify request.
     *
     * @param serviceId    the service id
     * @param appid        the appid
     * @param postPayments the post payments
     * @param reason       the reason
     * @param totalAmount  the total amount
     */
    public ModifyRequest(String serviceId, String appid, List<PostPayment> postPayments, String reason, Integer totalAmount) {
        this(serviceId, appid, postPayments, reason, totalAmount, null);
    }

    /**
     * Instantiates a new Modify request.
     *
     * @param serviceId     the service id
     * @param appid         the appid
     * @param postPayments  the post payments
     * @param reason        the reason
     * @param totalAmount   the total amount
     * @param postDiscounts the post discounts
     */
    public ModifyRequest(String serviceId, String appid, List<PostPayment> postPayments, String reason, Integer totalAmount, List<PostDiscount> postDiscounts) {
        this.serviceId = serviceId;
        this.appid = appid;
        this.postPayments = postPayments;
        this.reason = reason;
        this.totalAmount = totalAmount;
        this.postDiscounts = postDiscounts;
    }
}
