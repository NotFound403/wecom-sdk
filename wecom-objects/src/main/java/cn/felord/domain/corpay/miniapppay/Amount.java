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

package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class Amount {
    private final Integer total;
    private final String currency;


    /**
     * Instantiates a new Amount.
     *
     * @param total    the total
     * @param currency the currency
     */
    public Amount(int total, String currency) {
        this.total = total;
        this.currency = currency;
    }


    /**
     * RMB 专用
     *
     * @param total the total
     * @return the amount
     */
    public static Amount rmb(int total) {
        return new Amount(total, "CNY");
    }
}
