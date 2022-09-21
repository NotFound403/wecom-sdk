package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author dax
 * @since 2021/10/19 17:58
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MomentListResponse extends WeComResponse {
    private String nextCursor;
    private Set<MomentDetail> momentList;
}
