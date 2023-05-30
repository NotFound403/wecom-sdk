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
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

/**
 * 获取企业微信服务器IP
 *
 * @author felord.cn
 * @since 2021 /9/11
 */
public class DomainApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Domain api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    DomainApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取企业微信API域名IP段
     *
     * @return the contact list
     */
    public GenericResponse<List<String>> getApiDomainIp() {
        return workWeChatApiClient.get(WeComEndpoint.API_DOMAIN_IP, new ParameterizedTypeReference<GenericResponse<List<String>>>() {
        });
    }

    /**
     * 获取企业微信服务器的ip段
     *
     * @return the api domain ip
     */
    public GenericResponse<List<String>> getCallbackIp() {
        return workWeChatApiClient.get(WeComEndpoint.CALLBACK_IP, new ParameterizedTypeReference<GenericResponse<List<String>>>() {
        });
    }
}
