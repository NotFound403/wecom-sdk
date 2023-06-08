
package cn.felord.domain.callcenter;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

import java.util.List;

@Data
public class KfExternalUserRequest {
    private final List<String> externalUseridList;
    private final BoolEnum needEnterSessionContext;
}
