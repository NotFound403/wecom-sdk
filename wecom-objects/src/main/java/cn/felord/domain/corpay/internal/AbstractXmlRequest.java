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

import cn.felord.WeComException;
import cn.felord.enumeration.PaySignType;
import cn.felord.retrofit.json.JacksonObjectMapperFactory;
import cn.felord.utils.Algorithms;
import cn.felord.utils.CollectionUtils;
import cn.felord.utils.StringUtils;
import cn.felord.xml.XStreamXmlReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * The type Abstract xml able.
 *
 * @author dax
 * @since 2024/6/25 15:37
 */
public abstract class AbstractXmlRequest implements XmlRequest {
    private static final TypeReference<TreeMap<String, String>> TYPE_REFERENCE = new TypeReference<TreeMap<String, String>>() {
    };
    private static final ObjectMapper MAPPER = JacksonObjectMapperFactory.create();

    @XStreamAlias("workwx_sign")
    private String workWxSign;
    @XStreamAlias("sign")
    private String sign;

    @Override
    public String xmlBody(String paySecret, PaySignType signType) {
        try {
            String json = MAPPER.writeValueAsString(this);
            TreeMap<String, String> treeMap = MAPPER.readValue(json, TYPE_REFERENCE);
            String src = treeMap.entrySet()
                    .stream()
                    .filter(entry ->
                            StringUtils.hasText(entry.getValue()))
                    .map(entry ->
                            entry.getKey()
                                    .concat("=")
                                    .concat(entry.getValue()))
                    .collect(Collectors.joining("&"))
                    .concat("&key=")
                    .concat(paySecret);
            this.sign = Objects.equals(PaySignType.MD5, signType) ?
                    Algorithms.md5Hex(src, true) : Algorithms.hmacSha256Hex(src, paySecret, true);
            return XStreamXmlReader.INSTANCE.write(this);
        } catch (JsonProcessingException e) {
            throw new WeComException("fail to parse xml", e);
        }
    }

    @Override
    public void workWxSign(String payAgentSecret) {
        TreeMap<String, String> signParams = signParams();
        if (CollectionUtils.isNotEmpty(signParams)) {
            String src = signParams.entrySet()
                    .stream()
                    .filter(entry ->
                            StringUtils.hasText(entry.getValue()))
                    .map(entry ->
                            entry.getKey()
                                    .concat("=")
                                    .concat(entry.getValue()))
                    .collect(Collectors.joining("&"))
                    .concat("&secret=")
                    .concat(payAgentSecret);
            this.workWxSign = Algorithms.md5Hex(src, true);
        }
    }

    /**
     * 签名字段
     *
     * @return the tree map
     */
    protected TreeMap<String, String> signParams() {
        return null;
    }


    /**
     * 微信支付签名
     *
     * @return the sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * 企业微信签名
     *
     * @return the workwx sign
     */
    public String getWorkwxSign() {
        return workWxSign;
    }
}
