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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * 合单关闭订单请求参数
 *
 * @author dax
 * @since 2024/8/17
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class CombinePayCloseParams {
    /**
     * 合单发起方的appid
     */
    private final String combineAppid;
    /**
     * 最多支持子单条数：10
     */
    private final Set<CombineCloseOrder> subOrders;
}
