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
import cn.felord.domain.common.DepartmentId;
import cn.felord.domain.common.UserId;
import cn.felord.domain.contactbook.department.DeptInfo;
import cn.felord.domain.contactbook.linkedcorp.CorpSimpleUserInfo;
import cn.felord.domain.contactbook.linkedcorp.CorpUserInfo;
import cn.felord.domain.contactbook.linkedcorp.PermListResponse;
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
     * @throws WeComException the weComException
     */
    @POST("linkedcorp/agent/get_perm_list")
    PermListResponse getPermList() throws WeComException;

    /**
     * 获取互联企业成员详细信息
     *
     * @param userId the user id
     * @return the user
     * @throws WeComException the weComException
     */
    @POST("linkedcorp/user/get")
    GenericResponse<CorpUserInfo> getUser(@Body UserId userId) throws WeComException;

    /**
     * 获取互联企业部门成员
     *
     * @param linkedDepartmentId the linked department id
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("linkedcorp/user/simplelist")
    GenericResponse<List<CorpSimpleUserInfo>> getUserSimplelist(@Body DepartmentId linkedDepartmentId) throws WeComException;

    /**
     * 获取互联企业部门列表
     *
     * @param linkedDepartmentId the linked department id
     * @return the dept list
     * @throws WeComException the weComException
     */
    @POST("linkedcorp/department/list")
    GenericResponse<List<DeptInfo>> getDeptList(@Body DepartmentId linkedDepartmentId) throws WeComException;
}
