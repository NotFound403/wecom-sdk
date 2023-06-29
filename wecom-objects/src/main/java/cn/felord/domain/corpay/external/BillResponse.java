package cn.felord.domain.corpay.external;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2023/6/29 16:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BillResponse extends CursorWeComResponse {
    private List<BillDetail> billList;
}
