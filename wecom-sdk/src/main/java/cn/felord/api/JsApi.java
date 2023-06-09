package cn.felord.api;

import cn.felord.domain.authentication.JsTicketResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * The interface Js api.
 *
 * @author dax
 * @since 2023 /5/24 17:55
 */
public interface JsApi {

    /**
     * 获取企业的jsapi_ticket
     *
     * @return the single
     */
    @GET("get_jsapi_ticket")
    Single<JsTicketResponse> corpJsApiTicket();

    /**
     * 获取应用的jsapi_ticket
     *
     * @return the single
     */
    @GET("ticket/get")
    Single<JsTicketResponse> agentJsApiTicket(@Query("type") String agentConfig);
}
