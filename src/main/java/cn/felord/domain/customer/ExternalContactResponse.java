package cn.felord.domain.customer;

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
public class ExternalContactResponse extends WeComResponse {
    private List<String> externalUserid;
}
