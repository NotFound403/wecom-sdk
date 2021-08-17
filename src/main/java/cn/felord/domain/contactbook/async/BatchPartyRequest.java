package cn.felord.domain.contactbook.async;

import lombok.Data;

/**
 * @author n1
 * @since 2021/8/17 18:08
 */
@Data
public class BatchPartyRequest {
    private String mediaId;
    private Callback callback;
}
