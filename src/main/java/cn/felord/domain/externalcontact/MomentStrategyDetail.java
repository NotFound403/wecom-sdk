package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/12 13:38
 */
@Data
public class MomentStrategyDetail {
    private Integer strategyId;
    private Integer parentId;
    private String strategyName;
    private Instant createTime;
    private List<String> adminList;
    private MomentStrategyPrivilege privilege;


    void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }
}
