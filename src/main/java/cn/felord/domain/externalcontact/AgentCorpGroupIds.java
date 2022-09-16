package cn.felord.domain.externalcontact;

import lombok.Getter;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/12 16:46
 */
@Getter
public class AgentCorpGroupIds extends AgentCorpTagIterator {
    private final Set<String> groupId;

    public AgentCorpGroupIds(Set<String> groupId) {

        this.groupId = groupId;
    }
}
