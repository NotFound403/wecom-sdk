package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

/**
 * 客户管理
 *
 * @author dax
 * @since 2021/9/8 19:05
 */
public class ExternalContactUserApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    ExternalContactUserApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取配置了客户联系功能的成员列表
     *
     * @param userId the user id
     * @return the follow user list
     */
    public GenericResponse<List<String>> listByUserId(String userId) {
        String endpoint = WeComEndpoint.EXTERNALCONTACT_LIST_USERID.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("userid", userId)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, new ParameterizedTypeReference<GenericResponse<List<String>>>() {
        });
    }

    /**
     * 获取客户详情
     *
     * @param externalUserid the external userid
     * @param cursor         the cursor
     * @return the by user id
     */
    public ExternalUserDetailResponse getByUserId(String externalUserid, String cursor) {
        String endpoint = WeComEndpoint.EXTERNALCONTACT_GET_USERID.endpoint();
        LinkedMultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("external_userid", externalUserid);
        if (StringUtils.hasText(cursor)) {
            queryParams.add("cursor", cursor);
        }
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParams(queryParams)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, new ParameterizedTypeReference<ExternalUserDetailResponse>() {
        });
    }

    /**
     * 批量获取客户详情
     *
     * @param useridList the external userid list
     * @param cursor     the cursor
     * @param limit      the limit
     * @return the by user id
     */
    public ExternalUserListDetailResponse batchByUserIds(Set<String> useridList, String cursor, Integer limit) {
        int size = useridList.size();
        if (0 < size && size <= 100) {
            String endpoint = WeComEndpoint.EXTERNALCONTACT_BATCH_USERID.endpoint();
            URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                    .build()
                    .toUri();
            Map<String, Object> body = new HashMap<>();
            body.put("userid_list", useridList);
            body.put("cursor", cursor);
            body.put("limit", limit);
            return workWeChatApiClient.post(uri, body, ExternalUserListDetailResponse.class);
        }
        throw new WeComException("外部联系人ID个数范围 (0,100]");
    }

    /**
     * 修改客户备注信息
     *
     * @param request the request
     * @return the external user list detail response
     */
    public WeComResponse remark(CustomerRemarkRequest request) {

        String endpoint = WeComEndpoint.EXTERNALCONTACT_REMARK.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, WeComResponse.class);
    }

    /**
     * 获取规则组列表
     *
     * @param cursor the cursor
     * @param limit  the limit
     * @return the external user list detail response
     */
    public StrategyListResponse customerStrategyList(String cursor, int limit) {

        String endpoint = WeComEndpoint.CUSTOMER_STRATEGY_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        Map<String, Object> body = new HashMap<>(2);
        body.put("cursor", cursor);
        body.put("limit", limit);
        return workWeChatApiClient.post(uri, body, StrategyListResponse.class);
    }

    /**
     * 获取规则组详情
     *
     * @param strategyId the strategy id
     * @return the external user list detail response
     */
    public CustomerStrategyDetailResponse getCustomerStrategy(int strategyId) {

        String endpoint = WeComEndpoint.CUSTOMER_STRATEGY_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return workWeChatApiClient.post(uri, Collections.singletonMap("strategy_id", strategyId), CustomerStrategyDetailResponse.class);
    }

    /**
     * 获取规则组管理范围
     *
     * @param request the request
     * @return the external user list detail response
     */
    public StrategyRangeResponse getCustomerStrategyRange(StrategyRangeRequest request) {
        String endpoint = WeComEndpoint.CUSTOMER_STRATEGY_GET_RANGE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, StrategyRangeResponse.class);
    }

    /**
     * 创建新的规则组
     *
     * @param request the request
     * @return the customer strategy range response
     */
    public GenericResponse<Integer> createCustomerStrategy(CustomerStrategyRequest request) {

        String endpoint = WeComEndpoint.CUSTOMER_STRATEGY_CREATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<Integer>>() {
        });
    }

    /**
     * 编辑规则组及其管理范围
     *
     * @param request the request
     * @return the customer strategy range response
     */
    public WeComResponse editCustomerStrategy(MutableCustomerStrategy request) {

        String endpoint = WeComEndpoint.CUSTOMER_STRATEGY_EDIT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return workWeChatApiClient.post(uri, request, WeComResponse.class);
    }

    /**
     * 删除规则组
     *
     * @param strategyId the strategy id
     * @return the customer strategy range response
     */
    public WeComResponse delCustomerStrategy(int strategyId) {

        String endpoint = WeComEndpoint.CUSTOMER_STRATEGY_DEL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return workWeChatApiClient.post(uri, Collections.singletonMap("strategy_id", strategyId), WeComResponse.class);
    }

    /**
     * 家校沟通-外部联系人openid转换
     * <p>
     * 企业和服务商可通过此接口，将微信外部联系人的userid（如何获取?）转为微信openid，用于调用支付相关接口。
     * 暂不支持企业微信外部联系人（ExternalUserid为wo开头）的userid转openid。
     *
     * @param externalUserid the external userid
     * @return the generic response
     */
    public GenericResponse<String> convertToOpenid(String externalUserid) {

        if (externalUserid.startsWith("wo")){
            throw new WeComException("暂不支持以wo开头的externalUserid");
        }
        String endpoint = WeComEndpoint.EXTERNAL_USER_TO_OPENID.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return workWeChatApiClient.post(uri, Collections.singletonMap("external_userid", externalUserid),
                new ParameterizedTypeReference<GenericResponse<String>>() {
                });
    }
}
