package cn.felord.domain.journal;

import cn.felord.domain.common.UserId;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/10/14
 */
@Data
public class Receivers {
    private List<UserId> userList;
    private List<OpenTagId> tagList;
    private List<LeaderLevel> leaderList;
}