package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.ConfigId;
import cn.felord.domain.externalcontact.GroupChatDetail;
import cn.felord.domain.externalcontact.GroupChatDetailRequest;
import cn.felord.domain.externalcontact.GroupChatListRequest;
import cn.felord.domain.externalcontact.GroupChatListResponse;
import cn.felord.domain.externalcontact.GroupChatWayBody;
import cn.felord.domain.externalcontact.GroupChatWayResponse;
import cn.felord.domain.externalcontact.MutableGroupChatWayBody;
import cn.felord.domain.externalcontact.OpenGid;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 客户群管理
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public interface GroupChatApi {

    /**
     * 获取客户群列表
     *
     * @param request the request
     * @return the transfer result response
     */
    @POST("externalcontact/groupchat/list")
    Single<GroupChatListResponse> groupChatList(@Body GroupChatListRequest request);

    /**
     * 获取客户群详情
     *
     * @param request the request
     * @return the group chat detail
     */
    @POST("externalcontact/groupchat/get")
    Single<GenericResponse<GroupChatDetail>> getGroupChatDetail(@Body GroupChatDetailRequest request);

    /**
     * 客户群opengid转换
     *
     * @param opengid the opengid
     * @return the generic response
     */
    @POST("externalcontact/opengid_to_chatid")
    Single<GenericResponse<String>> opengidToChatid(@Body OpenGid opengid);

    /**
     * 客户群「加入群聊」管理
     * <p>
     * 配置客户群进群方式
     *
     * @param body the body
     * @return the generic response
     */
    @POST("externalcontact/groupchat/add_join_way")
    Single<GenericResponse<String>> addGroupChatWay(@Body GroupChatWayBody body);

    /**
     * 客户群「加入群聊」管理
     * <p>
     * 获取客户群进群方式配置
     *
     * @param configId the config id
     * @return the contact way
     */
    @POST("externalcontact/groupchat/get_join_way")
    Single<GenericResponse<GroupChatWayResponse>> getGroupChatWay(@Body ConfigId configId);

    /**
     * 客户群「加入群聊」管理
     * <p>
     * 更新客户群进群方式配置
     *
     * @param body the body
     * @return the we com response
     */
    @POST("externalcontact/groupchat/update_join_way")
    Single<WeComResponse> updateGroupChatWay(@Body MutableGroupChatWayBody body);

    /**
     * 客户群「加入群聊」管理
     * <p>
     * 删除客户群进群方式配置
     *
     * @param configId the config id
     * @return the we com response
     */
    @POST("externalcontact/groupchat/del_join_way")
    Single<WeComResponse> delGroupChatWay(@Body ConfigId configId);
}
