package cn.felord.domain.contactbook.async;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author felord.cn
 * @since 2021/9/11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BatchResultResponse extends WeComResponse {
    private Integer status;
    private String type;
    private Integer total;
    private Integer percentage;
    private List<Result> result;
}
