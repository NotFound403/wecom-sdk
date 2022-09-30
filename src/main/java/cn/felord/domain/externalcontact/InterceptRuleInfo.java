package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2021/8/23 11:28
 */
@Data
public class InterceptRuleInfo {
    private String ruleId;
    private String ruleName;
    private Instant createTime;
}
