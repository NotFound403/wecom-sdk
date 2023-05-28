package cn.felord.domain.contactbook.async;

import lombok.Data;

/**
 * The type Batch user request.
 *
 * @author n1
 * @since 2021 /8/17 19:34
 */
@Data
public class BatchUserRequest {
    private String mediaId;
    private boolean toInvite = true;
    private Callback callback;
}
