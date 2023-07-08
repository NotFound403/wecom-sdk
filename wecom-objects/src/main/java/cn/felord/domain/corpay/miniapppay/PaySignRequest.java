package cn.felord.domain.corpay.miniapppay;

import cn.felord.utils.AlternativeJdkIdGenerator;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@ToString
@Getter
public class PaySignRequest {
    private final String signType = "RSA";
    private final String appid;
    private final String nonce;
    private final String prepayId;
    private final Instant timestamp;

    /**
     * Instantiates a new Pay sign request.
     *
     * @param appid    the appid
     * @param prepayId the prepay id
     */
    public PaySignRequest(String appid, String prepayId) {
        this(appid, new AlternativeJdkIdGenerator().generate32(), prepayId, Instant.now());
    }

    /**
     * Instantiates a new Pay sign request.
     *
     * @param appid     the appid
     * @param nonce     the nonce
     * @param prepayId  the prepay id
     * @param timestamp the timestamp
     */
    public PaySignRequest(String appid, String nonce, String prepayId, Instant timestamp) {
        this.appid = appid;
        this.nonce = nonce;
        this.prepayId = prepayId;
        this.timestamp = timestamp;
    }
}