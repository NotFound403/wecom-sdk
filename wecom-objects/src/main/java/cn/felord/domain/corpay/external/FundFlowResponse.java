package cn.felord.domain.corpay.external;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2023/6/29 17:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FundFlowResponse extends CursorWeComResponse {
    private List<FundFlow> fundFlowList;
}
