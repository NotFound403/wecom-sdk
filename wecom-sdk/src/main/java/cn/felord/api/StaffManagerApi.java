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
import cn.felord.domain.hr.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 人事助手
 *
 * @author dax
 * @since 2024/8/3 11:48
 */
public interface StaffManagerApi {

    /**
     * 获取员工字段配置
     * <p>
     * 通过这个接口获取员工字段配置信息
     *
     * @return the fields
     * @throws WeComException the weComException
     */
    @GET("hr/get_fields")
    GenericResponse<List<FieldGroup>> getFields() throws WeComException;

    /**
     * 获取员工花名册信息
     * <p>
     * 通过这个接口获取指定员工的花名册信息
     * 调用参数中的字段id信息可以通过获取员工字段配置接口获取
     *
     * @param request the request
     * @return the staff info
     * @throws WeComException the weComException
     */
    @POST("hr/get_staff_info")
    GenericResponse<List<FieldDetail>> getStaffInfo(@Body StaffInfoRequest request) throws WeComException;

    /**
     * 更新员工花名册信息
     * <p>
     * 通过这个接口更新指定员工的花名册信息
     * 调用参数中的字段id信息可以通过获取员工字段配置接口获取
     * 有一些字段不支持更新，参考 <a href="https://developer.work.weixin.qq.com/document/path/99133#forbidden_fields">不支持更新字段表</a>
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("hr/update_staff_info")
    StaffInfoUpdateResponse updateStaffInfo(@Body StaffInfoUpdateRequest request) throws WeComException;
}
