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

/**
 * The type Office api.
 *
 * @author dax
 * @since 2024 /3/13 16:22
 */
public class WedocApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Office api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    WedocApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 管理文档
     *
     * @return the doc api
     */
    public DocApi docApi() {
        return workWeChatApiClient.retrofit().create(DocApi.class);
    }

    /**
     * 收集表
     *
     * @return the form api
     */
    public FormApi formApi() {
        return workWeChatApiClient.retrofit().create(FormApi.class);
    }

    /**
     * 智能表格
     *
     * @return the smart sheet api
     */
    public SmartSheetApi smartSheetApi() {
        return workWeChatApiClient.retrofit().create(SmartSheetApi.class);
    }

}
