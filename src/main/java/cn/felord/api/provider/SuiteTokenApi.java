package cn.felord.api.provider;

import cn.felord.RestTemplateFactory;
import cn.felord.SuiteDetail;
import cn.felord.WeComException;
import cn.felord.WeComTokenCacheable;
import cn.felord.api.TokenApi;
import cn.felord.domain.authentication.SuiteTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 获取第三方应用凭证
 *
 * @author felord.cn
 */
public class SuiteTokenApi implements TokenApi {
    private static final String SUITE_KEY = "suite";
    private final WeComTokenCacheable wecomCacheable;
    private final SuiteDetail suiteDetail;
    private final RestTemplate restTemplate;


    /**
     * Instantiates a new Token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param suiteDetail    the suite detail
     */
    protected SuiteTokenApi(WeComTokenCacheable wecomCacheable, SuiteDetail suiteDetail) {
        this.wecomCacheable = wecomCacheable;
        this.suiteDetail = suiteDetail;
        this.restTemplate = RestTemplateFactory.restOperations();
    }

    @Override
    public final String getTokenResponse() {
        String corpId = suiteDetail.getSuiteId();

        String tokenCache = wecomCacheable.getAccessToken(corpId, SUITE_KEY);
        if (tokenCache == null) {
            synchronized (this) {
                tokenCache = wecomCacheable.getAccessToken(corpId, SUITE_KEY);
                if (tokenCache == null) {
                    UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.SERVICE_GET_SUITE_TOKEN.endpoint())
                            .build();

                    SuiteTokenResponse tokenResponse = this.restTemplate.postForObject(uriComponents.toUri(), suiteDetail, SuiteTokenResponse.class);
                    if (tokenResponse == null || tokenResponse.isError()) {
                        throw new WeComException("failed to obtain suite token");
                    }
                    tokenCache = wecomCacheable.putAccessToken(corpId, SUITE_KEY, tokenResponse.getSuiteAccessToken());
                }
            }
        }
        return tokenCache;
    }

}
