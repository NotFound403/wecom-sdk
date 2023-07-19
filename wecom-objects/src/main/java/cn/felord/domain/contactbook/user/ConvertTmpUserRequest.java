package cn.felord.domain.contactbook.user;

import cn.felord.enumeration.BusinessType;
import cn.felord.enumeration.UseType;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/7/18 17:46
 */
@Data
public class ConvertTmpUserRequest {
    private final BusinessType businessType;
    private final UseType useType;
    private final List<String> tmpExternalUseridList;
}
