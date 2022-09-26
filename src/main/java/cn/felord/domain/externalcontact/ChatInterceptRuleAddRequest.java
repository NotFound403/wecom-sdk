package cn.felord.domain.externalcontact;

import cn.felord.enumeration.InterceptType;
import cn.felord.enumeration.SemanticsRule;
import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/26 11:00
 */
@Data
public class ChatInterceptRuleAddRequest {
    private final String ruleName;
    private final Set<String> wordList;
    private Set<SemanticsRule> semanticsList;
    private final InterceptType interceptType;
    private final ApplicableRange applicableRange;
}
