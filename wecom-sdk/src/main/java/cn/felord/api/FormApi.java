/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.FormId;
import cn.felord.domain.wedoc.form.*;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 收集表
 *
 * @author dax
 * @since 2024 /3/13 16:27
 */
public interface FormApi {


    /**
     * 创建收集表
     * <p>
     * 已过时，不带校验
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     * @see #createForm(CreateSettingFormRequest)
     */
    @Deprecated
    @POST("wedoc/create_form")
    GenericResponse<String> createForm(@Body CreateFormRequest request) throws WeComException;

    /**
     * 创建收集表
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("wedoc/create_form")
    GenericResponse<String> createForm(@Body CreateSettingFormRequest request) throws WeComException;

    /**
     * 编辑收集表信息
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("wedoc/modify_form")
    WeComResponse modifyForm(@Body AbstractUpdateFormRequest request) throws WeComException;

    /**
     * 获取收集表信息
     *
     * @param formid the formid
     * @return the form
     * @throws WeComException the weComException
     */
    @POST("wedoc/get_form_info")
    GenericResponse<SettingFormDetail> getFormInfo(@Body FormId formid) throws WeComException;

    /**
     * 收集表的统计信息查询（仅获取统计结果）
     *
     * @param request the request
     * @return the form statistic response
     * @throws WeComException the weComException
     */
    @POST("wedoc/get_form_statistic")
    FormStatisticResponse getFormStatistic(@Body FormStatisticRequest request) throws WeComException;

    /**
     * 收集表的统计信息查询（获取已提交列表）
     *
     * @param request the request
     * @return the form statistic response
     * @throws WeComException the weComException
     */
    @POST("wedoc/get_form_statistic")
    FormConfirmedResponse getFormStatistic(@Body FormConfirmedRequest request) throws WeComException;

    /**
     * 收集表的统计信息查询（获取未提交列表，仅当限制提交范围时有结果）
     *
     * @param request the request
     * @return the form statistic
     * @throws WeComException the weComException
     */
    @POST("wedoc/get_form_statistic")
    FormUnConfirmedResponse getFormStatistic(@Body FormUnConfirmedRequest request) throws WeComException;

    /**
     * 读取收集表答案
     *
     * @param request the request
     * @return the form answer response
     * @throws WeComException the weComException
     */
    @POST("wedoc/get_form_answer")
    FormAnswerResponse getFormAnswer(@Body FormAnswerRequest request) throws WeComException;

}
