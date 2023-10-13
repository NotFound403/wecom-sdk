package cn.felord.retrofit;

import cn.felord.AgentDetails;
import cn.felord.DownStreamDetails;
import cn.felord.WeComException;
import cn.felord.WeComTokenCacheable;
import cn.felord.domain.authentication.AccessTokenResponse;

/**
 * 获取下级/下游企业的access_token
 *
 * @author dax
 * @since 2023 /10/12
 */
public class DownStreamTokenApi extends AbstractTokenApi {

    private static final DownStreamAccessTokenApi DOWNSTREAM_TOKEN_API = WorkWechatRetrofitFactory.RETROFIT_.create(DownStreamAccessTokenApi.class);

    /**
     * Instantiates a new Token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agentDetails   the agent details
     */
    public DownStreamTokenApi(WeComTokenCacheable wecomCacheable, DownStreamDetails agentDetails) {
        super(wecomCacheable, agentDetails);
    }

    @Override
    protected String doGetToken(AgentDetails agentDetails) {
        DownStreamDetails downStreamDetails = (DownStreamDetails) agentDetails;
        AccessTokenApi tokenApi = new AccessTokenApi(this.getWecomCacheable(), downStreamDetails.getUpStreamDetails());
        String token = tokenApi.getToken();
        AccessTokenResponse tokenResponse = DOWNSTREAM_TOKEN_API.getTokenResponse(WecomUserAgent.WECOM_AGENT, downStreamDetails.toRequest(), token);
        if (tokenResponse == null || tokenResponse.isError()) {
            String errorMsg = tokenResponse == null ? "downstream token response is null" : tokenResponse.getErrmsg();
            throw new WeComException("failed to obtain downstream access token,reason: " + errorMsg);
        }
        return tokenResponse.getAccessToken();
    }
}
