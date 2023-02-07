package cn.felord.domain.externalcontact;

import lombok.Getter;

import java.util.Set;

/**
 * @author dax
 * @since 2021/11/9
 */
@Getter
public class AgentCorpGroupIdsAndTagIds extends AgentCorpTagIterator {
    private final Set<String> tagId;
    private final Set<String> groupId;

    public AgentCorpGroupIdsAndTagIds(Set<String> tagId, Set<String> groupId) {
        this.tagId = tagId;
        this.groupId = groupId;
    }
}
