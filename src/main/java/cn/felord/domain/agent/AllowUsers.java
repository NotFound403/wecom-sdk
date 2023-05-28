package cn.felord.domain.agent;

import cn.felord.domain.common.UserId;
import lombok.Data;

import java.util.List;

/**
 * @author felord.cn
 */
@Data
public class AllowUsers {
    private List<UserId> user;
}
