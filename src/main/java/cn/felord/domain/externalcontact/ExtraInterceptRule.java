package cn.felord.domain.externalcontact;

import cn.felord.enumeration.SemanticsRule;
import lombok.Data;

import java.util.Set;

/**
 * @author xiafang
 * @since 2022/9/26 11:33
 */
@Data
public class ExtraInterceptRule {
    private Set<SemanticsRule> semanticsList;
}
