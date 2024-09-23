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
 * 分账接收方类型
 *
 * @author n1
 * @since 2021/5/31 17:47
 */
public enum ReceiverType {
    /**
     * 商户号
     */
    MERCHANT_ID,
    /**
     * 个人openid（由父商户APPID转换得到）
     */
    PERSONAL_OPENID,
    /**
     * 个人sub_openid（由子商户APPID转换得到），服务商模式
     */
    PERSONAL_SUB_OPENID
}
