package cn.felord.domain.contactbook.user;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2023/5/24 12:56
 */
@Data
public class ExternalUserListDetailRequest {
    private final Set<String> useridList;
    private final String cursor;
    private final Integer limit;
}
