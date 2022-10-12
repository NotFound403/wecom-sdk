package cn.felord.domain.externalcontact;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/10/19 19:58
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MomentListResponse extends CursorWeComResponse {
    private List<MomentDetail> momentList;
}
