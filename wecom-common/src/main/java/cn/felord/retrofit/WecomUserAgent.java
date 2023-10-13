package cn.felord.retrofit;

import java.util.Optional;

/**
 * The type Wecom user agent.
 *
 * @author dax
 * @since 2023 /10/13
 */
public final class WecomUserAgent {
    /**
     * 版本号
     */
    public static final String VERSION = "1.2.2";
    /**
     * UserAgent
     */
    public static final String WECOM_AGENT = "Wecom/" + VERSION + Optional.ofNullable(System.getProperty("java.version"))
            .map(javaVersion -> "/Java/" + javaVersion)
            .orElse("");
}
