package cn.felord.domain.living;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2023/11/23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLivingsResponse extends CursorWeComResponse {
    private List<String> livingidList;
}
