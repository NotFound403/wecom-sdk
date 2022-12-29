package cn.felord.domain.externalcontact;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author xiafang
 * @since 2022/12/29 17:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UnassignedListResponse extends CursorWeComResponse {
    private List<UnassignedInfo> info;
    private Boolean isLast;
}
