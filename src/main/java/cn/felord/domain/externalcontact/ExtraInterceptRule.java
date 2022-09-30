package cn.felord.domain.externalcontact;

import cn.felord.enumeration.SemanticsRule;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/8/23 11:33
 */
@Data
public class ExtraInterceptRule {
    private List<SemanticsRule> semanticsList;
}
