package cn.felord.domain.media;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.MediaJobStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/6/28 16:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MediaJobResponse extends WeComResponse {
    private MediaJobStatus status;
    private MediaJobDetail detail;
}
