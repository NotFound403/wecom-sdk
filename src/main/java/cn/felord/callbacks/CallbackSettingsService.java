package cn.felord.callbacks;

import cn.felord.domain.callback.CallbackSettings;

/**
 * The interface Callback authentication service.
 *
 * @author felord
 * @since 2022 /11/21 12:13
 */
public interface CallbackSettingsService {
    /**
     * Load authentication callback authentication.
     *
     * @param agentId the agent id
     * @param corpId  the corp id
     * @return the callback authentication
     */
    CallbackSettings loadAuthentication(String agentId, String corpId);
}
