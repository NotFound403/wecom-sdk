package cn.felord.domain.externalcontact;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The type Contract list response.
 *
 * @author dax
 * @since 2024/1/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ContractListResponse extends CursorWeComResponse {
    private List<ContactInfo> infoList;
}
