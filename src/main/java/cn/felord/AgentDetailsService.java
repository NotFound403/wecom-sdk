package cn.felord;

import java.util.Collection;

/**
 * The interface Agent details service.
 *
 * @author n1
 * @since 2021 /6/17 10:18
 */
public interface AgentDetailsService {
    /**
     * Load by id agent details.
     *
     * @param agentDetailsId the agent details id
     * @return the agent details
     */
    AgentDetails loadById(String agentDetailsId);

    /**
     * Load by corp details id collection.
     *
     * @param corpDetailsId the corp details id
     * @return the collection
     */
    Collection<AgentDetails> loadByCorpDetailsId(String corpDetailsId);
}
