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
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

import java.util.List;

/**
 * 获取企业微信服务器IP
 *
 * @author felord.cn
 * @since 2021 /9/11
 */
public interface DomainApi {


    /**
     * 获取企业微信API域名IP段
     *
     * @return the contact list
     */
    @GET("get_api_domain_ip")
    Single<GenericResponse<List<String>>> getApiDomainIp();

    /**
     * 获取企业微信服务器的ip段
     *
     * @return the api domain ip
     */
    @GET("getcallbackip")
    Single<GenericResponse<List<String>>> getCallbackIp();
}
