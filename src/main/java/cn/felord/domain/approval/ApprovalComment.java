package cn.felord.domain.approval;

import cn.felord.domain.common.UserWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/5/27 17:29
 */
@Data
public class ApprovalComment {
    @JsonProperty("commentUserInfo")
    private UserWrapper commentUserInfo;
    private Instant commenttime;
    private String commentcontent;
    private String commentid;
    private List<String> mediaId;
}
