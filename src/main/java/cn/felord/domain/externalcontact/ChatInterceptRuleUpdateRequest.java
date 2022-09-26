package cn.felord.domain.externalcontact;

import cn.felord.enumeration.InterceptType;
import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/26 11:00
 */
@Data
public class ChatInterceptRuleUpdateRequest {
    private final String ruleId;
    private final String ruleName;
    private final Set<String> wordList;
    private ExtraInterceptRule extraRule;
    private final InterceptType interceptType;
    private final ApplicableRange addApplicableRange;
    private final ApplicableRange removeApplicableRange;
}
