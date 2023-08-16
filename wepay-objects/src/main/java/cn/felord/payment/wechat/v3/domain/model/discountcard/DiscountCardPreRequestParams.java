/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package cn.felord.payment.wechat.v3.domain.model.discountcard;


import lombok.Data;

/**
 * 预受理领卡请求参数
 *
 * @author felord.cn
 * @since 1.0.2.RELEASE
 */
@Data
public class DiscountCardPreRequestParams {

    /**
     * 商户领卡号，必传
     */
    private String outCardCode;
    /**
     * 先享卡模板ID，必传
     */
    private String cardTemplateId;
    /**
     * APPID，必传，自动从配置中注入
     */
    private String appid;
    /**
     * 通知商户URL，必传
     */
    private String notifyUrl;

}