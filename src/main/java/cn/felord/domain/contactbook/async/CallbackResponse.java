package cn.felord.domain.contactbook.async;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author felord.cn
 * @since 1.0.8.RELEASE
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CallbackResponse<T> extends WeComResponse {
    private Integer status;
    private String type;
    private Integer total;
    private Integer percentage;
    private List<T> result;
}
