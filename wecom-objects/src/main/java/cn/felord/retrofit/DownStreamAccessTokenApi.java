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

package cn.felord.retrofit;

import cn.felord.DownStreamDetails;
import cn.felord.domain.authentication.AccessTokenResponse;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 获取下游应用 access_token
 *
 * @author felord.cn
 */
interface DownStreamAccessTokenApi {
    /**
     * Gets token response.
     *
     * @param userAgent         the user agent
     * @param downStreamDetails the down stream details
     * @param accessToken       the access token
     * @return the token response
     */
    @POST("corpgroup/corp/gettoken")
    AccessTokenResponse getTokenResponse(@Header("User-Agent") String userAgent, @Body DownStreamDetails downStreamDetails, @Query("access_token") String accessToken);
}
