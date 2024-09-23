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

package cn.felord.payment.wechat.v3.domain.direct.basepay.combine;

import cn.felord.payment.wechat.v3.domain.direct.basepay.Payer;
import cn.felord.payment.wechat.v3.domain.direct.basepay.SimpleSceneInfo;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/8/17
 */
@Data
public class CombinePayDetailResponse {

    /**
     * 合单支付者信息
     */
    private final Payer combinePayerInfo;
    /**
     * 子单信息
     */
    private final List<SubOrder> subOrders;
    /**
     * 合单商户appid
     */
    private String combineAppid;
    /**
     * 合单商户号
     */
    private String combineMchid;
    /**
     * 合单商户订单号，商户侧需要保证同一商户下唯一
     */
    private String combineOutTradeNo;
    /**
     * 合单支付场景信息描述
     */
    private SimpleSceneInfo sceneInfo;

}
