package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.ChatPair;
import cn.felord.domain.externalcontact.ContactListRequest;
import cn.felord.domain.externalcontact.ContactListResponse;
import cn.felord.domain.externalcontact.ContactWayAddResponse;
import cn.felord.domain.externalcontact.ContactWayBody;
import cn.felord.domain.externalcontact.ContactWayBodyDetail;
import cn.felord.domain.externalcontact.ContactWayConfigRequest;
import cn.felord.domain.externalcontact.MutableContactWay;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * The type Corp service user api.
 *
 * @author dax
 * @since 2021 /9/8 9:28
 */
public interface ContactMeWayApi {

    /**
     * 获取配置了客户联系功能的成员列表
     *
     * @return the follow user list
     */
    @GET("externalcontact/get_follow_user_list")
    Single<GenericResponse<List<String>>> getFollowUserList();

    /**
     * 配置客户联系「联系我」方式
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/add_contact_way")
    Single<ContactWayAddResponse> addContactWay(@Body ContactWayBody request);

    /**
     * 获取企业已配置的「联系我」方式
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/get_contact_way")
    Single<GenericResponse<ContactWayBodyDetail>> getContactWay(@Body ContactWayConfigRequest request);

    /**
     * 获取企业已配置的「联系我」列表
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/list_contact_way")
    Single<ContactListResponse> listContactWay(@Body ContactListRequest request);

    /**
     * 更新企业已配置的「联系我」方式
     *
     * @param contactWay the contact way
     * @return the we com response
     */
    @POST("externalcontact/update_contact_way")
    Single<WeComResponse> updateContactWay(@Body MutableContactWay contactWay);

    /**
     * 删除企业已配置的「联系我」方式
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/del_contact_way")
    Single<WeComResponse> delContactWay(@Body ContactWayConfigRequest request);

    /**
     * 结束临时会话
     *
     * @param chatPair the chat pair
     * @return the we com response
     */
    @POST("externalcontact/close_temp_chat")
    Single<WeComResponse> closeTempChat(@Body ChatPair chatPair);
}
