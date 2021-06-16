package cn.felord.enumeration;

/**
 *
 *
 * @author n1
 * @since 2021 /6/16 14:24
 */
public enum WeComDomain {

    /**
     * Cgi bin
     */
    CGI_BIN("https://qyapi.weixin.qq.com/cgi-bin");
    private final String domain;

    WeComDomain(String domain) {
        this.domain = domain;
    }

    /**
     * Gets domain.
     *
     * @return the domain
     */
    public String domain() {
        return domain;
    }
}
