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
 * 微盘API
 *
 * @author dax
 * @since 2023 /3/17 15:01
 */
public class WeDriveApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new We drive api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    WeDriveApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 管理文件
     *
     * @return the form api
     */
    public FileManagerApi fileManagerApi() {
        return new FileManagerApi(workWeChatApiClient.retrofit());
    }
}
