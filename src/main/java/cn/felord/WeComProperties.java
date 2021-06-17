package cn.felord;

import lombok.Data;

/**
 * The type We com properties.
 *
 * @author n1
 * @since 2021 /6/16 9:46
 */
@Data
public class WeComProperties {

    private String corpId;
    private String secret;


    /**
     * 应用信息
     */
    public static class Agent {
        private String agentId;
        private String agentSecret;
        private String description;
    }

}
