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

import cn.felord.enumeration.RedPackStatus;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/6/26 14:56
 */
@XStreamAlias("xml")
@EqualsAndHashCode(callSuper = true)
@Data
public class RedPackRecordResponse extends AbstractXmlResponse {
    @XStreamAlias("sign")
    private String sign;
    @XStreamAlias("mch_billno")
    private String mchBillno;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("detail_id")
    private String detailId;
    @XStreamAlias("status")
    private RedPackStatus status;
    @XStreamAlias("send_type")
    private String sendType;
    @XStreamAlias("total_amount")
    private long totalAmount;
    @XStreamAlias("reason")
    private String reason;
    @XStreamAlias("send_time")
    private Instant sendTime;
    @XStreamAlias("refund_time")
    private Instant refundTime;
    @XStreamAlias("refund_amount")
    private long refundAmount;
    @XStreamAlias("wishing")
    private String wishing;
    @XStreamAlias("remark")
    private String remark;
    @XStreamAlias("act_name")
    private String actName;
    @XStreamAlias("openid")
    private String openid;
    @XStreamAlias("amount")
    private long amount;
    @XStreamAlias("rcv_time")
    private Instant rcvTime;
    @XStreamAlias("sender_name")
    private String senderName;
    @XStreamAlias("sender_header_media_id")
    private String senderHeaderMediaId;
}
