package cn.felord.domain.corpay.internal;

import cn.felord.WeComException;
import cn.felord.domain.callback.Xml;
import cn.felord.enumeration.PaySignType;
import cn.felord.json.JacksonObjectMapperFactory;
import cn.felord.utils.Algorithms;
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
 * @since 2023 /6/25 15:37
 */
public abstract class AbstractXmlRequest implements XmlRequest, Xml {
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
            throw new WeComException(e);
        }
    }

    @Override
    public void workWxSign(String agentSecret) {
        String src = signParams().entrySet()
                .stream()
                .filter(entry ->
                        StringUtils.hasText(entry.getValue()))
                .map(entry ->
                        entry.getKey()
                                .concat("=")
                                .concat(entry.getValue()))
                .collect(Collectors.joining("&"))
                .concat("&secret=")
                .concat(agentSecret);
        this.workWxSign = Algorithms.md5Hex(src, true);
    }

    /**
     * 签名字段
     *
     * @return the tree map
     */
    abstract TreeMap<String, String> signParams();


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
