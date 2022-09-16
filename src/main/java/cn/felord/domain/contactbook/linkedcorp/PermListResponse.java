package cn.felord.domain.contactbook.linkedcorp;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author felord.cn
 * @since 2021/7/7 11:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PermListResponse extends WeComResponse {
    private Set<String> userids;
    private Set<String> departmentIds;
}
