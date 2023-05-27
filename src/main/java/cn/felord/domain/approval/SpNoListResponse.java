package cn.felord.domain.approval;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/27 14:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SpNoListResponse extends CursorWeComResponse {
    private List<String> spNoList;
}
