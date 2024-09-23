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

import lombok.Data;

/**
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class Goods {
    /**
     * 商户侧商品编码
     */
    private final String merchantGoodsId;
    /**
     * 商品数量
     */
    private final Integer quantity;
    /**
     * 商品单价
     */
    private final Long unitPrice;
    /**
     * 微信侧商品编码
     */
    private String wechatpayGoodsId;
    /**
     * 商品名称
     */
    private String goodsName;
}
