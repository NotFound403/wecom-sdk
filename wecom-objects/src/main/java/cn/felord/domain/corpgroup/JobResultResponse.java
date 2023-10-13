package cn.felord.domain.corpgroup;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.JobStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/10/13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class JobResultResponse extends WeComResponse {
    private JobStatus status;
    private JobResult result;
}
