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

import cn.felord.enumeration.RedPackScene;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.TreeMap;

/**
 * @author dax
 * @since 2023/6/25 17:46
 */
@XStreamAlias("xml")
@EqualsAndHashCode(callSuper = true)
@Data
public class RedPackRequest extends AbstractXmlRequest {
    @XStreamAlias("nonce_str")
    private final String nonceStr;
    @XStreamAlias("mch_billno")
    private final String mchBillno;
    @XStreamAlias("mch_id")
    private final String mchId;
    @XStreamAlias("wxappid")
    private final String wxappid;
    @XStreamAlias("sender_name")
    private String senderName;
    @XStreamAlias("agentid")
    private String agentid;
    @XStreamAlias("sender_header_media_id")
    private String senderHeaderMediaId;
    @XStreamAlias("re_openid")
    private final String reOpenid;
    @XStreamAlias("total_amount")
    private final long totalAmount;
    @XStreamAlias("wishing")
    private final String wishing;
    @XStreamAlias("act_name")
    private final String actName;
    @XStreamAlias("remark")
    private final String remark;
    @XStreamAlias("scene_id")
    private RedPackScene sceneId;

    @Override
    protected TreeMap<String, String> signParams() {
        TreeMap<String, String> params = new TreeMap<>();
        params.put("act_name", actName);
        params.put("mch_billno", mchBillno);
        params.put("mch_id", mchId);
        params.put("nonce_str", nonceStr);
        params.put("re_openid", reOpenid);
        params.put("total_amount", String.valueOf(totalAmount));
        params.put("wxappid", wxappid);
        return params;
    }
}

