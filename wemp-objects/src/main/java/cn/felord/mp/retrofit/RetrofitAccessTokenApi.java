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

package cn.felord.mp.retrofit;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * The interface Retrofit access token api.
 *
 * @author dax
 * @since 2024/5/23 8:58
 */
interface RetrofitAccessTokenApi {

    /**
     * Gets token response.
     *
     * @param grantType the grant type
     * @param appid     the appid
     * @param secret    the secret
     * @return the token response
     */
    @GET("cgi-bin/token")
    AccessTokenResponse getTokenResponse(@Query("grant_type") String grantType, @Query("appid") String appid, @Query("secret") String secret);
}
