package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.ChatInterceptRuleAddRequest;
import cn.felord.domain.externalcontact.ChatInterceptRuleUpdateRequest;
import cn.felord.domain.externalcontact.InterceptRuleDetail;
import cn.felord.domain.externalcontact.InterceptRuleInfo;
import cn.felord.domain.externalcontact.InterceptRuleRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 管理聊天敏感词
 *
 * @author dax
 * @since 2021 /8/17 10:26
 */
public interface ChatInterceptRuleApi {

    /**
     * 新建敏感词规则
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/add_intercept_rule")
    Single<GenericResponse<String>> addInterceptRule(@Body ChatInterceptRuleAddRequest request);

    /**
     * 获取敏感词规则列表
     *
     * @return the generic response
     */
    @GET("externalcontact/get_intercept_rule_list")
    Single<GenericResponse<InterceptRuleInfo>> interceptRuleList();

    /**
     * 获取敏感词规则详情
     *
     * @param request the request
     * @return the intercept rule
     */
    @POST("externalcontact/get_intercept_rule")
    GenericResponse<InterceptRuleDetail> getInterceptRule(@Body InterceptRuleRequest request);

    /**
     * 修改敏感词规则
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/update_intercept_rule")
    Single<WeComResponse> updateInterceptRule(@Body ChatInterceptRuleUpdateRequest request);

    /**
     * 删除敏感词规则
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/del_intercept_rule")
    Single<WeComResponse> deleteInterceptRule(@Body InterceptRuleRequest request);
}
