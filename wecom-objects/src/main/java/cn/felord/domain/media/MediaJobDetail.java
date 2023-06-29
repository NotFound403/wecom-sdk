package cn.felord.domain.media;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/6/28 16:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MediaJobDetail extends WeComResponse {
    private String mediaId;
    private Instant createdAt;
}
