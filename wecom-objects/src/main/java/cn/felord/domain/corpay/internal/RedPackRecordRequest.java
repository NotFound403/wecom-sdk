package cn.felord.domain.corpay.internal;

import cn.felord.WeComException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.TreeMap;

/**
 * @author dax
 * @since 2023/6/26 14:49
 */
@XStreamAlias("xml")
@EqualsAndHashCode(callSuper = true)
@Data
public class RedPackRecordRequest extends AbstractXmlRequest {
    @XStreamAlias("nonce_str")
    private final String nonceStr;
    @XStreamAlias("mch_billno")
    private final String mchBillno;
    @XStreamAlias("mch_id")
    private final String mchId;
    @XStreamAlias("appid")
    private final String appid;

    @Override
    TreeMap<String, String> signParams() {
        throw new WeComException("not supported");
    }
}
