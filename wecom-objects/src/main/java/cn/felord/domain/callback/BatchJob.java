package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author xiafang
 * @since 2023/7/3 9:44
 */
@Data
public class BatchJob {
    @XStreamAlias("JobId")
    private String jobId;
    @XStreamAlias("JobType")
    private String jobType;
    @XStreamAlias("ErrCode")
    private Integer errCode;
    @XStreamAlias("ErrMsg")
    private String errMsg;
}
