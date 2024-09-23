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

import cn.felord.payment.wechat.enumeration.PayScoreOrderState;
import cn.felord.payment.wechat.enumeration.StateDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * The type Pay score order response.
 */
@Data
public class PayScoreOrderResponse {
    private String outOrderNo;
    private String appid;
    private String serviceId;
    private List<PostPayment> postPayments;
    private List<PostDiscount> postDiscounts;
    private TimeRange timeRange;
    private Location location;
    private String serviceIntroduction;
    private RiskFund riskFund;
    private String attach;
    private String notifyUrl;
    private PayScoreOrderState state;
    private StateDescription stateDescription;
    private String orderId;
    @JsonProperty("package")
    private String pkg;
}
