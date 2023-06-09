package cn.felord.domain.oa;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2023/5/24 11:10
 */
@Data
public class CalendarDetailRequest {
    private final Set<String> calIdList;
}
