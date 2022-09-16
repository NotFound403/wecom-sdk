package cn.felord.domain.externalcontact;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dax
 * @since 2021/7/12 17:23
 */
@Setter
@Getter
public abstract class AgentCorpTagIterator implements CorpTagIterator {
    private String agentid;
}
