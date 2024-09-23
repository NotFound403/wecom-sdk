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

import cn.felord.enumeration.TransPocketCheck;
import cn.felord.enumeration.WwMsgType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.TreeMap;

/**
 * @author dax
 * @since 2023/6/28
 */
@XStreamAlias("xml")
@EqualsAndHashCode(callSuper = true)
@Data
public class TransPocketRequest extends AbstractXmlRequest {

    @XStreamAlias("appid")
    private final String appid;
    @XStreamAlias("mch_id")
    private final String mchId;
    @XStreamAlias("nonce_str")
    private final String nonceStr;
    @XStreamAlias("partner_trade_no")
    private final String partnerTradeNo;
    @XStreamAlias("openid")
    private final String openid;
    @XStreamAlias("check_name")
    private final TransPocketCheck checkName;
    @XStreamAlias("amount")
    private final long amount;
    @XStreamAlias("desc")
    private final String desc;
    @XStreamAlias("spbill_create_ip")
    private final String spbillCreateIp;
    @XStreamAlias("ww_msg_type")
    private final WwMsgType wwMsgType;
    @XStreamAlias("act_name")
    private final String actName;
    @XStreamAlias("device_info")
    private String deviceInfo;
    @XStreamAlias("re_user_name")
    private String reUserName;
    @XStreamAlias("approval_number")
    private String approvalNumber;
    @XStreamAlias("approval_type")
    private Integer approvalType;
    @XStreamAlias("agentid")
    private String agentid;

    @Override
    protected TreeMap<String, String> signParams() {
        TreeMap<String, String> params = new TreeMap<>();
        params.put("amount", String.valueOf(amount));
        params.put("appid", appid);
        params.put("desc", desc);
        params.put("mch_id", mchId);
        params.put("nonce_str", nonceStr);
        params.put("openid", openid);
        params.put("partner_trade_no", partnerTradeNo);
        params.put("ww_msg_type", wwMsgType.name());
        return params;
    }
}
