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

import java.util.HashMap;

/**
 * @author dax
 * @since 2023/8/25
 */
public class FavorSubsidyListRequest extends HashMap<String, String> {


    public FavorSubsidyListRequest(String stockId, String couponCode) {
        this(stockId, couponCode, null);
    }

    public FavorSubsidyListRequest(String stockId, String couponCode, String outSubsidyNo) {
        this.put("stock_id", stockId);
        this.put("coupon_code", couponCode);
        this.put("out_subsidy_no", outSubsidyNo);
    }
}
