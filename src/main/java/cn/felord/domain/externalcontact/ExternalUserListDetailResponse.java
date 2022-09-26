package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The type External user detail response.
 *
 * @author dax
 * @since 2021/7/8 18:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExternalUserListDetailResponse extends WeComResponse {
    private List<Detail> externalContactList;
    private String nextCursor;

    @Data
    public static class Detail {
        private ExternalContact externalContact;
        private FollowInfo followInfo;
    }
}
