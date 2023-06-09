package cn.felord.domain.callcenter;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2023/6/7 14:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class KfExternalUserResponse extends WeComResponse {
    private List<KfExternalUser> customerList;
    private List<String> invalidExternalUserid;
}
