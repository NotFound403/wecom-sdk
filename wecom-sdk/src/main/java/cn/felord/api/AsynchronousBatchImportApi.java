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
import cn.felord.domain.contactbook.async.BatchPartyRequest;
import cn.felord.domain.contactbook.async.BatchResultResponse;
import cn.felord.domain.contactbook.async.BatchUserRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.LinkedMultiValueMap;

/**
 * 异步导入接口
 *
 * @author n1
 * @since 2021 /6/18 16:25
 */
public class AsynchronousBatchImportApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Asynchronous batch import api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    AsynchronousBatchImportApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * Batch sync user generic response.
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> batchSyncUser(BatchUserRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.BATCH_SYNC_USER, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * Batch sync replace user generic response.
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> batchSyncReplaceUser(BatchUserRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.BATCH_REPLACE_USER, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * Batch sync replace party generic response.
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> batchSyncReplaceParty(BatchPartyRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.BATCH_REPLACE_PARTY, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * Gets result.
     *
     * @param jobId the job id
     * @return the result
     */
    public BatchResultResponse getResult(String jobId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("jobid", jobId);
        return workWeChatApiClient.get(WeComEndpoint.BATCH_GET_RESULT, query, BatchResultResponse.class);
    }
}
