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

import cn.felord.enumeration.TransPocketStatus;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/6/28
 */
@XStreamAlias("xml")
@EqualsAndHashCode(callSuper = true)
@Data
public class TransPocketRecordResponse extends AbstractXmlResponse {

    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("detail_id")
    private String detailId;
    @XStreamAlias("appid")
    private String appid;
    @XStreamAlias("status")
    private TransPocketStatus status;
    @XStreamAlias("reason")
    private String reason;
    @XStreamAlias("openid")
    private String openid;
    @XStreamAlias("transfer_name")
    private String transferName;
    @XStreamAlias("payment_amount")
    private long paymentAmount;
    @XStreamAlias("transfer_time")
    private Instant transferTime;
    @XStreamAlias("desc")
    private String desc;

}
