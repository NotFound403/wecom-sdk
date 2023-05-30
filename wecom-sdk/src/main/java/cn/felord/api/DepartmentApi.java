/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.department.DeptInfo;
import cn.felord.domain.contactbook.department.DeptSimpleInfo;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.LinkedMultiValueMap;

import java.util.List;

/**
 * 通讯录管理-部门管理
 *
 * @author n1
 * @since 2021 /6/17 14:58
 */
public class DepartmentApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Department api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    DepartmentApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建部门
     *
     * @param request the request
     * @return CreateDeptResponse generic response
     */
    public GenericResponse<Long> createDept(DeptInfo request) {
        return workWeChatApiClient.post(WeComEndpoint.DEPT_CREATE, request, new ParameterizedTypeReference<GenericResponse<Long>>() {
        });
    }

    /**
     * 创建部门
     *
     * @param request the request
     * @return the we com response
     */
    public WeComResponse updateDept(DeptInfo request) {
        return workWeChatApiClient.post(WeComEndpoint.DEPT_UPDATE, request, WeComResponse.class);
    }

    /**
     * 删除部门,不能删除根部门；不能删除含有子部门、成员的部门
     * <p>
     * 第三方仅通讯录应用可以调用。
     *
     * @param departmentId departmentId
     * @return WeComResponse we com response
     */
    public WeComResponse deleteDept(long departmentId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("id", String.valueOf(departmentId));
        return workWeChatApiClient.get(WeComEndpoint.DEPT_DELETE, query, WeComResponse.class);
    }

    /**
     * 获取部门列表（自建）
     *
     * @param departmentId departmentId
     * @return DeptResponse generic response
     */
    public GenericResponse<List<DeptInfo>> deptList(Long departmentId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("id", String.valueOf(departmentId));
        return workWeChatApiClient.get(WeComEndpoint.DEPT_LIST, query, new ParameterizedTypeReference<GenericResponse<List<DeptInfo>>>() {
        });
    }

    /**
     * 获取全部部门列表（自建）
     *
     * @return DeptResponse generic response
     */
    public GenericResponse<List<DeptInfo>> deptList() {
        return this.deptList(null);
    }

    /**
     * 获取全部子部门ID列表
     *
     * @return the simple list
     */
    public GenericResponse<List<DeptSimpleInfo>> getSimpleList() {
        return getSimpleList(null);
    }

    /**
     * 获取子部门ID列表
     *
     * @param departmentId the department id
     * @return the generic response
     */
    public GenericResponse<List<DeptSimpleInfo>> getSimpleList(Long departmentId) {

        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("id", String.valueOf(departmentId));
        return workWeChatApiClient.get(WeComEndpoint.DEPT_SIMPLE_LIST, query, new ParameterizedTypeReference<GenericResponse<List<DeptSimpleInfo>>>() {
        });
    }

    /**
     * 获取单部门详情（自建）
     *
     * @param departmentId the department id
     * @return the generic response
     */
    public GenericResponse<DeptInfo> get(long departmentId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("id", String.valueOf(departmentId));
        return workWeChatApiClient.get(WeComEndpoint.DEPT_GET, query, new ParameterizedTypeReference<GenericResponse<DeptInfo>>() {
        });
    }
}
