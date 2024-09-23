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

package cn.felord.payment.wechat.enumeration;

/**
 * 服务订单状态
 *
 * @author dax
 * @since 2024/8/22
 */
public enum PayScoreOrderState {
    /**
     * 商户已创建服务订单
     */
    CREATED,
    /**
     * 服务订单进行中
     */
    DOING,

    /**
     * 服务订单完成
     */
    DONE,
    /**
     * 商户取消服务订单
     */
    REVOKED,
    /**
     * 服务订单已失效
     */
    EXPIRED

}
