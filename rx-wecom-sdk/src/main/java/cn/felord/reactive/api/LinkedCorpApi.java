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

package cn.felord.reactive.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.common.DepartmentId;
import cn.felord.domain.common.UserId;
import cn.felord.domain.contactbook.department.DeptInfo;
import cn.felord.domain.contactbook.linkedcorp.CorpSimpleUserInfo;
import cn.felord.domain.contactbook.linkedcorp.CorpUserInfo;
import cn.felord.domain.contactbook.linkedcorp.PermListResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 互联企业通讯录
 *
 * @author felord.cn
 * @since 2021 /8/29 16:39
 */
public interface LinkedCorpApi {
    /**
     * 获取应用的可见范围
     *
     * @return the perm list
     */
    @POST("linkedcorp/agent/get_perm_list")
    Single<PermListResponse> getPermList();

    /**
     * 获取互联企业成员详细信息
     *
     * @param userId the user id
     * @return the user
     */
    @POST("linkedcorp/user/get")
    Single<GenericResponse<CorpUserInfo>> getUser(@Body UserId userId);

    /**
     * 获取互联企业部门成员
     *
     * @param linkedDepartmentId the linked department id
     * @return the generic response
     */
    @POST("linkedcorp/user/simplelist")
    Single<GenericResponse<List<CorpSimpleUserInfo>>> getUserSimplelist(@Body DepartmentId linkedDepartmentId);

    /**
     * 获取互联企业部门列表
     *
     * @param linkedDepartmentId the linked department id
     * @return the dept list
     */
    @POST("linkedcorp/department/list")
    Single<GenericResponse<List<DeptInfo>>> getDeptList(@Body DepartmentId linkedDepartmentId);
}
