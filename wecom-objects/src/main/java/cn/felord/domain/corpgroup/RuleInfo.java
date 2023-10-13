package cn.felord.domain.corpgroup;

import lombok.Data;

/**
 * The type Rule info.
 *
 * @author dax
 * @since 2023 /10/13
 */
@Data
public class RuleInfo {
    private OwnerCorpRange ownerCorpRange;
    private MemberCorpRange memberCorpRange;
}