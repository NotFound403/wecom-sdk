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

/**
 * 通讯录管理
 *
 * @author felord.cn
 * @since 1.0.0
 */
public class ContactBookManager {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Contact book manager.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    ContactBookManager(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 成员管理
     *
     * @return the user api
     */
    public UserApi userApi() {
        return this.workWeChatApiClient.retrofit().create(UserApi.class);
    }

    /**
     * 部门管理
     *
     * @return the department api
     */
    public DepartmentApi departmentApi() {
        return this.workWeChatApiClient.retrofit().create(DepartmentApi.class);
    }

    /**
     * 标签管理
     *
     * @return the tag api
     */
    public TagApi tagApi() {
        return this.workWeChatApiClient.retrofit().create(TagApi.class);
    }

    /**
     * 异步导入接口
     *
     * @return the asynchronous batch import api
     */
    public AsynchronousBatchImportApi asynchronousBatchApi() {
        return this.workWeChatApiClient.retrofit().create(AsynchronousBatchImportApi.class);
    }

    /**
     * 互联企业接口
     *
     * @return the linked corp api
     */
    public LinkedCorpApi linkedCorpApi() {
        return this.workWeChatApiClient.retrofit().create(LinkedCorpApi.class);
    }
}
