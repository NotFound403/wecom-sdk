
package cn.felord.domain.urgentcall;


import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The type Call response.
 *
 * @author n1
 * @since 2021 /6/16 19:36
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CallResponse extends WeComResponse {
    private List<State> states;
}
