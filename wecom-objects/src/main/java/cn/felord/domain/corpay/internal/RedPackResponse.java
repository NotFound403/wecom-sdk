package cn.felord.domain.corpay.internal;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/6/26 14:29
 */
@XStreamAlias("xml")
@EqualsAndHashCode(callSuper = true)
@Data
public class RedPackResponse extends AbstractXmlResponse {
    @XStreamAlias("sign")
    private String sign;
    @XStreamAlias("mch_billno")
    private String mchBillno;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("wxappid")
    private String wxappid;
    @XStreamAlias("re_openid")
    private String reOpenid;
    @XStreamAlias("total_amount")
    private Integer totalAmount;
    @XStreamAlias("send_listid")
    private String sendListid;
    @XStreamAlias("sender_name")
    private String senderName;
    @XStreamAlias("sender_header_media_id")
    private String senderHeaderMediaId;
}
