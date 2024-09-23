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
 * 单品列表信息
 *
 * @author dax
 * @since 2023/7/6 17:05
 */
@Data
public class PromotionGoodsDetail {

    /**
     * 商品编码
     */
    private String goodsId;
    /**
     * 商品数量
     */
    private Long quantity;
    /**
     * 商品单价
     */
    private Long unitPrice;
    /**
     * 商品优惠金额，单位【分】
     */
    private Long discountAmount;
    /**
     * 商品备注
     */
    private String goodsRemark;
}
