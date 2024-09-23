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
package cn.felord.payment.wechat.v3.domain.direct.basepay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * 支付金额 货币单位【分】默认使用人民币标识CNY
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Getter
public class Amount {
    /**
     * 金额，单位【分】。
     */
    private final Long total;
    /**
     * 货币单位，固定为 CNY 。
     */
    private final String currency;

    /**
     * Instantiates a new Amount.
     *
     * @param total the total
     */
    public Amount(long total) {
        this(total, "CNY");
    }

    /**
     * Instantiates a new Amount.
     *
     * @param total    the total
     * @param currency the currency
     */
    @JsonCreator
    Amount(@JsonProperty("total") Long total, @JsonProperty("currency") String currency) {
        this.total = total;
        this.currency = currency;
    }
}
