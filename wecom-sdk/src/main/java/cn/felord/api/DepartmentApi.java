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
import cn.felord.domain.contactbook.department.DeptInfo;
import cn.felord.domain.contactbook.department.DeptSimpleInfo;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

/**
 * 通讯录管理-部门管理
 *
 * @author n1
 * @since 2021 /6/17 14:58
 */
public interface DepartmentApi {

    /**
     * 创建部门
     *
     * @param request the request
     * @return CreateDeptResponse generic response
     * @throws WeComException the weComException
     */
    @POST("department/create")
    GenericResponse<Long> createDept(@Body DeptInfo request) throws WeComException;

    /**
     * 创建部门
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("department/update")
    WeComResponse updateDept(@Body DeptInfo request) throws WeComException;

    /**
     * 删除部门,不能删除根部门；不能删除含有子部门、成员的部门
     * <p>
     * 第三方仅通讯录应用可以调用。
     *
     * @param departmentId departmentId
     * @return WeComResponse we com response
     * @throws WeComException the weComException
     */
    @GET("department/delete")
    WeComResponse deleteDept(@Query("id") long departmentId) throws WeComException;

    /**
     * 获取部门列表（自建）
     * <p>
     * 获取指定部门及其下的子部门（以及子部门的子部门等等，递归）
     *
     * @param departmentId departmentId
     * @return DeptResponse generic response
     * @throws WeComException the weComException
     */
    @GET("department/list")
    GenericResponse<List<DeptInfo>> deptList(@Query("id") long departmentId) throws WeComException;

    /**
     * 获取全部部门列表（自建）
     *
     * @return DeptResponse generic response
     * @throws WeComException the weComException
     */
    @GET("department/list")
    GenericResponse<List<DeptInfo>> deptList() throws WeComException;

    /**
     * 获取全部子部门ID列表
     *
     * @return the simple list
     * @throws WeComException the weComException
     */
    @GET("department/simplelist")
    GenericResponse<List<DeptSimpleInfo>> getSimpleList() throws WeComException;

    /**
     * 获取子部门ID列表
     *
     * @param departmentId the department id
     * @return the generic response
     * @throws WeComException the weComException
     */
    @GET("department/simplelist")
    GenericResponse<List<DeptSimpleInfo>> getSimpleList(@Query("id") long departmentId) throws WeComException;

    /**
     * 获取单部门详情（自建）
     *
     * @param departmentId the department id
     * @return the generic response
     * @throws WeComException the weComException
     */
    @GET("department/get")
    GenericResponse<DeptInfo> get(@Query("id") long departmentId) throws WeComException;
}
