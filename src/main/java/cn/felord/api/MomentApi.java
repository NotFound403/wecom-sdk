package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户朋友圈
 *
 * @author dax
 * @since 2021 /8/19 14:45
 */
public class MomentApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Moment api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    MomentApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建发表任务
     *
     * @param <T>  the type parameter
     * @param body the body
     * @return the generic response
     */
    public <T extends MomentAttachment> GenericResponse<String> addMomentTask(MomentBody<T> body) {
        String endpoint = WeComEndpoint.MOMENT_TASK_ADD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, body, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 获取任务创建结果
     *
     * @param jobId the job id
     * @return the moment task result response
     */
    public MomentTaskResultResponse getMomentTaskResult(String jobId) {
        String endpoint = WeComEndpoint.MOMENT_TASK_JOB_RESULT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("jobid", jobId)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, MomentTaskResultResponse.class);
    }

    /**
     * 获取企业全部的发表列表
     *
     * @param request the request
     * @return the moment list
     */
    public MomentListResponse getMomentList(MomentListRequest request) {
        String endpoint = WeComEndpoint.MOMENT_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, MomentListResponse.class);
    }

    /**
     * 获取客户朋友圈企业发表的列表
     *
     * @param request the request
     * @return the moment list
     */
    public MomentMemberTaskResponse getMomentTask(MomentTaskRequest request) {
        String endpoint = WeComEndpoint.MOMENT_TASK_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, MomentMemberTaskResponse.class);
    }

    /**
     * 获取客户朋友圈发表时选择的可见范围
     * <p>
     * 指用户发表时指定了哪些客户可收
     *
     * @param request the request
     * @return the moment customer list
     */
    public MomentCustomerListResponse getMomentCustomerList(MomentInfoRequest request) {
        String endpoint = WeComEndpoint.MOMENT_CUSTOMER_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, MomentCustomerListResponse.class);
    }

    /**
     * 获取客户朋友圈发表后的可见客户列表
     * <p>
     * 指哪些客户真正可以看到
     *
     * @param request the request
     * @return the moment send result
     */
    public MomentCustomerListResponse getMomentSendResult(MomentInfoRequest request) {
        String endpoint = WeComEndpoint.MOMENT_SEND_RESULT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, MomentCustomerListResponse.class);
    }

    /**
     * 获取客户朋友圈的互动数据
     * <p>
     * 优化了企业微信给的数据结构
     *
     * @param momentId the moment id
     * @param userId   the user id
     * @return the moment 优化了企业微信给的数据结构
     */
    public MomentCommentResponse getMomentComments(String momentId, String userId) {
        String endpoint = WeComEndpoint.MOMENT_COMMENTS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        Map<String, String> body = new HashMap<>(2);
        body.put("moment_id", momentId);
        body.put("userid", userId);
        return workWeChatApiClient.post(uri, body, MomentCommentResponse.class);
    }

    /**
     * 获取规则组列表
     *
     * @param cursor the cursor
     * @param limit  the limit
     * @return the external user list detail response
     */
    public StrategyListResponse momentStrategyList(String cursor, int limit) {

        String endpoint = WeComEndpoint.MOMENT_STRATEGY_LIST.endpoint();
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
    public MomentStrategyDetailResponse getMomentStrategy(int strategyId) {

        String endpoint = WeComEndpoint.MOMENT_STRATEGY_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return workWeChatApiClient.post(uri, Collections.singletonMap("strategy_id", strategyId), MomentStrategyDetailResponse.class);
    }

    /**
     * 获取规则组管理范围
     *
     * @param request the request
     * @return the external user list detail response
     */
    public StrategyRangeResponse getMomentStrategyRange(StrategyRangeRequest request) {

        String endpoint = WeComEndpoint.MOMENT_STRATEGY_RANGE.endpoint();
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
    public GenericResponse<Integer> createMomentStrategy(CustomerStrategyRequest request) {

        String endpoint = WeComEndpoint.MOMENT_STRATEGY_CREATE.endpoint();
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
    public WeComResponse editMomentStrategy(MutableMomentStrategy request) {

        String endpoint = WeComEndpoint.MOMENT_STRATEGY_EDIT.endpoint();
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
    public WeComResponse delMomentStrategy(int strategyId) {

        String endpoint = WeComEndpoint.MOMENT_STRATEGY_DEL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();

        return workWeChatApiClient.post(uri, Collections.singletonMap("strategy_id", strategyId), WeComResponse.class);
    }
}
