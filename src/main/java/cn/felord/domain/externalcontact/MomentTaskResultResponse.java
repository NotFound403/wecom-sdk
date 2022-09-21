package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.MomentTaskStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2021/7/25 15:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MomentTaskResultResponse extends WeComResponse {
    private MomentTaskStatus status;
    private String type;
    private MomentTaskResult result;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class MomentTaskResult extends WeComResponse {
        private String momentId;
        private MomentSenderList invalidSenderList;
        private MomentExternalContactList invalidExternalContactList;
    }
}
