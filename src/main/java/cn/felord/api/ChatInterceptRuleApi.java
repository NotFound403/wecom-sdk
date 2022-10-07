package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.ChatInterceptRuleAddRequest;
import cn.felord.domain.externalcontact.ChatInterceptRuleUpdateRequest;
import cn.felord.domain.externalcontact.InterceptRuleDetail;
import cn.felord.domain.externalcontact.InterceptRuleInfo;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

/**
 * 管理聊天敏感词
 *
 * @author dax
 * @since 2021 /8/17 10:26
 */
public class ChatInterceptRuleApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Chat intercept rule api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    ChatInterceptRuleApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 新建敏感词规则
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> addInterceptRule(ChatInterceptRuleAddRequest request) {

        String endpoint = WeComEndpoint.INTERCEPT_RULE_CREATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 获取敏感词规则列表
     *
     * @return the generic response
     */
    public GenericResponse<InterceptRuleInfo> interceptRuleList() {

        String endpoint = WeComEndpoint.INTERCEPT_RULE_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, new ParameterizedTypeReference<GenericResponse<InterceptRuleInfo>>() {
        });
    }

    /**
     * 获取敏感词规则详情
     *
     * @param ruleId the rule id
     * @return the intercept rule
     */
    public GenericResponse<InterceptRuleDetail> getInterceptRule(String ruleId) {

        String endpoint = WeComEndpoint.INTERCEPT_RULE_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("rule_id", ruleId), new ParameterizedTypeReference<GenericResponse<InterceptRuleDetail>>() {
        });
    }

    /**
     * 修改敏感词规则
     *
     * @param request the request
     * @return the we com response
     */
    public WeComResponse updateInterceptRule(ChatInterceptRuleUpdateRequest request) {

        String endpoint = WeComEndpoint.INTERCEPT_RULE_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, WeComResponse.class);
    }

    /**
     * 删除敏感词规则
     *
     * @param ruleId the rule id
     * @return the we com response
     */
    public WeComResponse deleteInterceptRule(String ruleId) {

        String endpoint = WeComEndpoint.INTERCEPT_RULE_DEL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("rule_id", ruleId), WeComResponse.class);
    }
}
