package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.MomentTaskPubStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/10/19 18:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MomentMemberTaskResponse extends WeComResponse {
    private String nextCursor;
    private List<MemberTask> taskList;

    @Data
    public static class MemberTask {
        private String userid;
        private MomentTaskPubStatus publishStatus;

    }
}
