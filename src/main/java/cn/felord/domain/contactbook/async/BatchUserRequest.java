package cn.felord.domain.contactbook.async;

import lombok.Data;

/**
 * The type Batch user request.
 *
 * @author n1
 * @since 2021 /8/17 17:34
 */
@Data
public class BatchUserRequest {
    private String mediaId;
    private Boolean toInvite = true;
    private Callback callback;


    /**
     * The type Callback.
     */
    @Data
    public static class Callback{
        private String url;
        private String token;
        private String encodingaeskey;
    }
}
