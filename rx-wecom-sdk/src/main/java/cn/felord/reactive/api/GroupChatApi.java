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
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.*;
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
