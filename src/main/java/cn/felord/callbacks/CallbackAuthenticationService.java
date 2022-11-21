package cn.felord.callbacks;

import cn.felord.domain.callback.CallbackAuthentication;

/**
 * The interface Callback authentication service.
 *
 * @author xiafang
 * @since 2022 /11/21 12:13
 */
public interface CallbackAuthenticationService {
    /**
     * Load authentication callback authentication.
     *
     * @param agentId the agent id
     * @param corpId  the corp id
     * @return the callback authentication
     */
    CallbackAuthentication loadAuthentication(String agentId, String corpId);
}
