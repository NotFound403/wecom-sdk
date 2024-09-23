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

import lombok.Data;

/**
 * 要关闭的合单子单
 *
 * @author dax
 * @since 2024/8/17
 */
@Data
public class CombineCloseOrder {
    /**
     * 子单发起方商户号，必须与发起方appid有绑定关系。
     */
    private final String mchid;
    /**
     * 商户系统内部订单号，要求32个字符内，
     * 只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    private final String outTradeNo;
}
