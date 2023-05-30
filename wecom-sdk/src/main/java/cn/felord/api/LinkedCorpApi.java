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
import cn.felord.domain.contactbook.department.DeptInfo;
import cn.felord.domain.contactbook.linkedcorp.CorpSimpleUserInfo;
import cn.felord.domain.contactbook.linkedcorp.CorpUserInfo;
import cn.felord.domain.contactbook.linkedcorp.PermListResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Collections;
import java.util.List;

/**
 * 互联企业通讯录
 *
 * @author felord.cn
 * @since 2021 /8/29 16:39
 */
public class LinkedCorpApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    LinkedCorpApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取应用的可见范围
     *
     * @return the perm list
     */
    public PermListResponse getPermList() {
        return workWeChatApiClient.post( WeComEndpoint.LINKED_CORP_PERM_LIST, Collections.emptyMap(), PermListResponse.class);
    }

    /**
     * 获取互联企业成员详细信息
     *
     * @param corpUserId the corp user id
     * @return the user
     */
    public GenericResponse<CorpUserInfo> getUser(String corpUserId) {
        return workWeChatApiClient.post(WeComEndpoint.LINKED_CORP_USER, Collections.singletonMap("userid", corpUserId),
                new ParameterizedTypeReference<GenericResponse<CorpUserInfo>>() {
                });
    }

    /**
     * 获取互联企业部门成员
     *
     * @param linkedDepartmentId the linked department id
     * @return the generic response
     */
    public GenericResponse<List<CorpSimpleUserInfo>> getUserSimplelist(String linkedDepartmentId) {
        return workWeChatApiClient.post( WeComEndpoint.LINKED_CORP_USER_SIMPLELIST, Collections.singletonMap("department_id", linkedDepartmentId),
                new ParameterizedTypeReference<GenericResponse<List<CorpSimpleUserInfo>>>() {
                });
    }

    /**
     * 获取互联企业部门列表
     *
     * @param linkedDepartmentId the linked department id
     * @return the dept list
     */
    public GenericResponse<List<DeptInfo>> getDeptList(String linkedDepartmentId) {
        return workWeChatApiClient.post(WeComEndpoint.LINKED_CORP_DEPT_LIST, Collections.singletonMap("department_id", linkedDepartmentId),
                new ParameterizedTypeReference<GenericResponse<List<DeptInfo>>>() {
                });
    }
}
