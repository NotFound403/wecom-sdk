package cn.felord.domain.callcenter;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2023/6/7 15:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class KfStatisticResponse<T> extends WeComResponse {
    private List<KfStatistic<T>> statisticList;
}
