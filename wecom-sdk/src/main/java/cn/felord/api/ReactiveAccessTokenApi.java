package cn.felord.api;

import cn.felord.domain.authentication.AccessTokenResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * The interface Retrofit access token api.
 *
 * @author dax
 * @since 2023 /5/23 8:58
 */
interface ReactiveAccessTokenApi {

    /**
     * Gets token response.
     *
     * @param corpId     the corp id
     * @param corpSecret the corp secret
     * @return the token response
     */
    @GET("gettoken")
    AccessTokenResponse getTokenResponse(@Query("corpid") String corpId, @Query("corpsecret") String corpSecret);
}
