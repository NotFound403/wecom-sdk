package cn.felord.domain.urgentcall;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2023/6/9 15:39
 */
@Data
public class CalleeUsers {
    private final Set<String> calleeUserid;
}
