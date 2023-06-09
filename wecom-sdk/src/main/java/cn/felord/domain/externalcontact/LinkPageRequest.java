package cn.felord.domain.externalcontact;

import cn.felord.domain.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/6/9 14:57
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LinkPageRequest extends PageRequest {
    private String linkId;
}
