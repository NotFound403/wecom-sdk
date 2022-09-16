package cn.felord.domain.externalcontact;

import lombok.Getter;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/12 16:46
 */
@Getter
public class AgentCorpTagIds extends AgentCorpTagIterator {
    private final Set<String> tagId;

    public AgentCorpTagIds(Set<String> tagId) {
        this.tagId = tagId;
    }
}
