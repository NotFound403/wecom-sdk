package cn.felord.enumeration;

/**
 * The enum We com endpoint.
 *
 * @author n1
 * @since 2021 /6/16 14:19
 */
public enum WeComEndpoint {
    /**
     * Get token we com endpoint.
     */
    GET_TOKEN("/gettoken"),
    /**
     * Ex contacts we com endpoint.
     */
    EX_CONTACTS("/externalcontact/list"),
    /**
     * Webhook send we com endpoint.
     */
    WEBHOOK_SEND("/webhook/send");
    private final String pattern;

    WeComEndpoint(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Endpoint string.
     *
     * @param weComDomain the we com domain
     * @return the string
     */
    public String endpoint(WeComDomain weComDomain) {
        return weComDomain.domain() + pattern;
    }
}
