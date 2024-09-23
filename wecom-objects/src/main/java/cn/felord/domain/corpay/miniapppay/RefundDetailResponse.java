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

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.RefundChannel;
import cn.felord.enumeration.RefundResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;

/**
 * 退款记录
 * <p>
 * 返回UTC时间需要自行转换为东八区
 *
 * @author dax
 * @since 2024/7/6 16:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RefundDetailResponse extends WeComResponse {
    private String refundId;
    private String outRefundNo;
    private String transactionId;
    private String outTradeNo;
    private RefundChannel channel;
    private String userReceivedAccount;
    private OffsetDateTime successTime;
    private OffsetDateTime createTime;
    private RefundResult status;
    private RAmount amount;
    private RefundPromotionDetail promotionDetail;
}
