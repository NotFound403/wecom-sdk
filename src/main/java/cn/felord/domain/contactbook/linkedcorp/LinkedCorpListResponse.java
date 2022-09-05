package cn.felord.domain.contactbook.linkedcorp;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author felord.cn
 * @since 2021/9/2 9:41
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LinkedCorpListResponse extends WeComResponse {
    private Set<CorpUser> corpUsers;
    private Set<CorpDept> corpDepts;
}
