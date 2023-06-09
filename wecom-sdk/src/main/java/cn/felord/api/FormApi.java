package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.wedoc.form.AbstractUpdateFormRequest;
import cn.felord.domain.wedoc.form.CreateFormRequest;
import cn.felord.domain.wedoc.form.FormAnswerRequest;
import cn.felord.domain.wedoc.form.FormAnswerResponse;
import cn.felord.domain.wedoc.form.FormConfirmedRequest;
import cn.felord.domain.wedoc.form.FormConfirmedResponse;
import cn.felord.domain.wedoc.form.FormDetail;
import cn.felord.domain.wedoc.form.FormId;
import cn.felord.domain.wedoc.form.FormStatisticRequest;
import cn.felord.domain.wedoc.form.FormStatisticResponse;
import cn.felord.domain.wedoc.form.FormUnConfirmedRequest;
import cn.felord.domain.wedoc.form.FormUnConfirmedResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 收集表
 *
 * @author dax
 * @since 2023 /3/13 16:27
 */
public interface FormApi {


    /**
     * 创建收集表
     *
     * @param request the request
     * @return the generic response
     */
    @POST("wedoc/create_form")
    Single<GenericResponse<String>> createForm(@Body CreateFormRequest request);

    /**
     * 编辑收集表信息
     *
     * @param request the request
     * @return the generic response
     */
    @POST("wedoc/modify_form")
    Single<GenericResponse<FormDetail>> modifyForm(@Body AbstractUpdateFormRequest request);

    /**
     * 获取收集表信息
     *
     * @param formid the formid
     * @return the form
     */
    @POST("wedoc/get_form_info")
    Single<GenericResponse<FormDetail>> getForm(@Body FormId formid);

    /**
     * 收集表的统计信息查询（仅获取统计结果）
     *
     * @param request the request
     * @return the form statistic response
     */
    @POST("wedoc/get_form_statistic")
    Single<FormStatisticResponse> getFormStatistic(@Body FormStatisticRequest request);

    /**
     * 收集表的统计信息查询（获取已提交列表）
     *
     * @param request the request
     * @return the form statistic response
     */
    @POST("wedoc/get_form_statistic")
    Single<FormConfirmedResponse> getFormStatistic(@Body FormConfirmedRequest request);

    /**
     * 收集表的统计信息查询（获取未提交列表，仅当限制提交范围时有结果）
     *
     * @param request the request
     * @return the form statistic
     */
    @POST("wedoc/get_form_statistic")
    Single<FormUnConfirmedResponse> getFormStatistic(@Body FormUnConfirmedRequest request);

    /**
     * 读取收集表答案
     *
     * @param request the request
     * @return the form answer response
     */
    @POST("wedoc/get_form_answer")
    Single<FormAnswerResponse> getFormAnswer(@Body FormAnswerRequest request);

}
