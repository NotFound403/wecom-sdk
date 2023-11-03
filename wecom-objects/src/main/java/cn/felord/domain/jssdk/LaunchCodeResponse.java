package cn.felord.domain.jssdk;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/11/3
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LaunchCodeResponse extends WeComResponse {
    private String launchCode;
}
