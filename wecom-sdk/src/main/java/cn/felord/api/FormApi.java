/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.common.FormId;
import cn.felord.domain.wedoc.form.*;
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
    GenericResponse<String> createForm(@Body CreateFormRequest request);

    /**
     * 编辑收集表信息
     *
     * @param request the request
     * @return the generic response
     */
    @POST("wedoc/modify_form")
    GenericResponse<FormDetail> modifyForm(@Body AbstractUpdateFormRequest request);

    /**
     * 获取收集表信息
     *
     * @param formid the formid
     * @return the form
     */
    @POST("wedoc/get_form_info")
    GenericResponse<FormDetail> getForm(@Body FormId formid);

    /**
     * 收集表的统计信息查询（仅获取统计结果）
     *
     * @param request the request
     * @return the form statistic response
     */
    @POST("wedoc/get_form_statistic")
    FormStatisticResponse getFormStatistic(@Body FormStatisticRequest request);

    /**
     * 收集表的统计信息查询（获取已提交列表）
     *
     * @param request the request
     * @return the form statistic response
     */
    @POST("wedoc/get_form_statistic")
    FormConfirmedResponse getFormStatistic(@Body FormConfirmedRequest request);

    /**
     * 收集表的统计信息查询（获取未提交列表，仅当限制提交范围时有结果）
     *
     * @param request the request
     * @return the form statistic
     */
    @POST("wedoc/get_form_statistic")
    FormUnConfirmedResponse getFormStatistic(@Body FormUnConfirmedRequest request);

    /**
     * 读取收集表答案
     *
     * @param request the request
     * @return the form answer response
     */
    @POST("wedoc/get_form_answer")
    FormAnswerResponse getFormAnswer(@Body FormAnswerRequest request);

}
