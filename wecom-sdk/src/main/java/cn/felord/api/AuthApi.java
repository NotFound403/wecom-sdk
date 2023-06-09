package cn.felord.api;

import cn.felord.domain.contactbook.user.UserDetailResponse;
import cn.felord.domain.contactbook.user.UserSensitiveInfoResponse;
import cn.felord.domain.contactbook.user.UserTicket;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 身份验证API
 *
 * @author felord.cn
 * @since 2021 /9/3 9:17
 */
public interface AuthApi {

    /**
     * 获取访问用户身份
     * <p>
     * 该接口用于根据code获取成员信息，适用于自建应用与代开发应用
     *
     * @param code 通过成员授权获取到的code
     * @return UserDetailResponse
     */
    @GET("auth/getuserinfo")
    Single<UserDetailResponse> getUserInfo(@Query("code") String code);

    /**
     * 获取访问用户敏感信息，需要授权scope包含{@code snsapi_privateinfo}
     * <p>
     * 自建应用与代开发应用可通过该接口获取成员授权的敏感字段
     *
     * @param userTicket 成员票据
     * @return UserSensitiveInfoResponse
     */
    @POST("auth/getuserdetail")
    Single<UserSensitiveInfoResponse> getUserDetail(@Body UserTicket userTicket);
}
