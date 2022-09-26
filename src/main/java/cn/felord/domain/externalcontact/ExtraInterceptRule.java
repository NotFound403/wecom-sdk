package cn.felord.domain.externalcontact;

import cn.felord.enumeration.SemanticsRule;
import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2022/9/26 11:33
 */
@Data
public class ExtraInterceptRule {
    private List<SemanticsRule> semanticsList;
}
