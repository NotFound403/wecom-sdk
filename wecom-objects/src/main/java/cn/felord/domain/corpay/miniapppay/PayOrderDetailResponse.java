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

import cn.felord.enumeration.MiniPayTradeState;
import cn.felord.enumeration.MiniPayTradeType;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class PayOrderDetailResponse {
    private String mchid;
    private String outTradeNo;
    private MiniPayTradeType tradeType;
    private MiniPayTradeState tradeState;
    private String tradeStateDesc;
    private Payer payer;
    private String transactionId;
    private String bankType;
    private String attach;
    private OffsetDateTime successTime;
    private OrderAmount amount;
    private SceneInfo sceneInfo;
    private PromotionDetail promotionDetail;
}
