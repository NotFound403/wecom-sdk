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

package cn.felord.domain.corpay.internal;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/6/28
 */
@XStreamAlias("xml")
@EqualsAndHashCode(callSuper = true)
@Data
public class TransPocketRecordRequest extends AbstractXmlRequest {

    @XStreamAlias("appid")
    private final String appid;
    @XStreamAlias("mch_id")
    private final String mchId;
    @XStreamAlias("nonce_str")
    private final String nonceStr;
    @XStreamAlias("partner_trade_no")
    private final String partnerTradeNo;

}
