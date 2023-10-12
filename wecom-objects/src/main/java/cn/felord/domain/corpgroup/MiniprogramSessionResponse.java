package cn.felord.domain.corpgroup;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/10/12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MiniprogramSessionResponse extends WeComResponse {
    private String userid;
    private String sessionKey;
}
