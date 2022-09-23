package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/4/26 14:04
 */
@Data
public class OwnerFilter {
    private final Set<String> useridList;
}
