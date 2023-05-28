package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.CustomerRemarkRequest;
import cn.felord.domain.externalcontact.CustomerStrategyDetailResponse;
import cn.felord.domain.externalcontact.CustomerStrategyRequest;
import cn.felord.domain.externalcontact.ExternalUserDetailResponse;
import cn.felord.domain.externalcontact.ExternalUserListDetailResponse;
import cn.felord.domain.externalcontact.MutableCustomerStrategy;
import cn.felord.domain.externalcontact.StrategyListResponse;
import cn.felord.domain.externalcontact.StrategyRangeRequest;
import cn.felord.domain.externalcontact.StrategyRangeResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * 获取客户列表
     *
     * @param userId the user id
     * @return the follow user list
     */
    public GenericResponse<List<String>> listByUserId(String userId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("userid", userId);
        return workWeChatApiClient.get(WeComEndpoint.EXTERNALCONTACT_LIST_USERID, query,
                new ParameterizedTypeReference<GenericResponse<List<String>>>() {
                });
    }

    /**
     * 获取客户详情
     *
     * @param externalUserid the external userid
     * @param cursor         the cursor
     * @return the by user id
     */
    public ExternalUserDetailResponse getByExUserId(String externalUserid, String cursor) {
        LinkedMultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("external_userid", externalUserid);
        if (StringUtils.hasText(cursor)) {
            queryParams.add("cursor", cursor);
        }
        return workWeChatApiClient.get(WeComEndpoint.EXTERNALCONTACT_GET_USERID, queryParams, new ParameterizedTypeReference<ExternalUserDetailResponse>() {
        });
    }

    /**
     * 批量获取客户详情
     *
     * @param userids the userid list
     * @param cursor  the cursor
     * @param limit   the limit
     * @return the by user id
     */
    public ExternalUserListDetailResponse batchByUserIds(Set<String> userids, String cursor, Integer limit) {
        int size = userids.size();
        if (0 < size && size <= 100) {
            Map<String, Object> body = new HashMap<>();
            body.put("userid_list", userids);
            body.put("cursor", cursor);
            body.put("limit", limit);
            return workWeChatApiClient.post(WeComEndpoint.EXTERNALCONTACT_BATCH_USERID, body, ExternalUserListDetailResponse.class);
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
        return workWeChatApiClient.post(WeComEndpoint.EXTERNALCONTACT_REMARK, request, WeComResponse.class);
    }

    /**
     * 获取规则组列表
     *
     * @param cursor the cursor
     * @param limit  the limit
     * @return the external user list detail response
     */
    public StrategyListResponse customerStrategyList(String cursor, int limit) {
        Map<String, Object> body = new HashMap<>(2);
        body.put("cursor", cursor);
        body.put("limit", limit);
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_STRATEGY_LIST, body, StrategyListResponse.class);
    }

    /**
     * 获取规则组详情
     *
     * @param strategyId the strategy id
     * @return the external user list detail response
     */
    public CustomerStrategyDetailResponse getCustomerStrategy(int strategyId) {
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_STRATEGY_GET,
                Collections.singletonMap("strategy_id", strategyId),
                CustomerStrategyDetailResponse.class);
    }

    /**
     * 获取规则组管理范围
     *
     * @param request the request
     * @return the external user list detail response
     */
    public StrategyRangeResponse getCustomerStrategyRange(StrategyRangeRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_STRATEGY_GET_RANGE, request, StrategyRangeResponse.class);
    }

    /**
     * 创建新的规则组
     *
     * @param request the request
     * @return the customer strategy range response
     */
    public GenericResponse<Integer> createCustomerStrategy(CustomerStrategyRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_STRATEGY_CREATE, request, new ParameterizedTypeReference<GenericResponse<Integer>>() {
        });
    }

    /**
     * 编辑规则组及其管理范围
     *
     * @param request the request
     * @return the customer strategy range response
     */
    public WeComResponse editCustomerStrategy(MutableCustomerStrategy request) {
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_STRATEGY_EDIT, request, WeComResponse.class);
    }

    /**
     * 删除规则组
     *
     * @param strategyId the strategy id
     * @return the customer strategy range response
     */
    public WeComResponse delCustomerStrategy(int strategyId) {
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_STRATEGY_DEL, Collections.singletonMap("strategy_id", strategyId), WeComResponse.class);
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

        if (externalUserid.startsWith("wo")) {
            throw new WeComException("暂不支持以wo开头的externalUserid");
        }

        return workWeChatApiClient.post(WeComEndpoint.EXTERNAL_USER_TO_OPENID, Collections.singletonMap("external_userid", externalUserid),
                new ParameterizedTypeReference<GenericResponse<String>>() {
                });
    }
}
