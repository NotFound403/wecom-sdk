package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/12 13:38
 */
@Data
public class CustomerStrategyDetail {
    private Integer strategyId;
    private Integer parentId;
    private String strategyName;
    private Instant createTime;
    private List<String> adminList;
    private CustomerStrategyPrivilege privilege;



    void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }
}
