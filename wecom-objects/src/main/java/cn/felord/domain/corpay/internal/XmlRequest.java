package cn.felord.domain.corpay.internal;

import cn.felord.enumeration.PaySignType;

/**
 * The interface Xmlable.
 *
 * @author dax
 * @since 2023 /6/25 15:24
 */
public interface XmlRequest {

    /**
     * Xml string.
     *
     * @param paySecret the pay secret
     * @param signType  the sign type
     * @return the string
     */
    String xmlBody(String paySecret, PaySignType signType);

    /**
     * Workwx sign.
     *
     * @param agentSecret the agent secret
     */
    void workWxSign(String agentSecret);
}
