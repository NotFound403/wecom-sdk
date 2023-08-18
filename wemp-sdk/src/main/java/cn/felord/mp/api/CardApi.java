package cn.felord.mp.api;

import cn.felord.mp.WeMpException;
import cn.felord.mp.domain.card.*;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * The interface Card api.
 *
 * @author xiafang
 * @since 2023 /8/18 11:41
 */
public interface CardApi {

    /**
     * Create response body.
     *
     * @param request the request
     * @return the response body
     * @throws WeMpException the we mp exception
     */
    @POST("card/create")
    ResponseBody create(@Body CardRequest<AbstractCard> request) throws WeMpException;

    /**
     * Landingpage card landing response.
     *
     * @param request the request
     * @return the card landing response
     * @throws WeMpException the we mp exception
     */
    @POST("card/landingpage/create")
    CardLandingResponse landingpage(@Body CardLandingRequest request) throws WeMpException;

    /**
     * Updateuser card landing response.
     *
     * @param request the request
     * @return the card landing response
     * @throws WeMpException the we mp exception
     */
    @POST("card/membercard/updateuser")
    CardUpdateUserResponse updateuser(@Body CardUpdateUserRequest request) throws WeMpException;
}
