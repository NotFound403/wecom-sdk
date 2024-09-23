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

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.msgaudit.AgreeInfoRequest;
import cn.felord.domain.msgaudit.ChatAgreeDetail;
import cn.felord.domain.msgaudit.InnerChatInfoResponse;
import cn.felord.domain.msgaudit.PermitUsersRequest;
import cn.felord.domain.msgaudit.RoomId;
import cn.felord.domain.msgaudit.SingleAgreeDetail;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 会话存档API
 *
 * @author dax
 * @since 2024/12/1
 */
public interface MsgAuditApi {

    /**
     * 获取会话内容存档开启成员列表
     * <p>
     * 企业可通过此接口，获取企业开启会话内容存档的成员列表
     * <p>
     * 注：开启范围可设置为具体成员、部门、标签。
     * 通过此接口拉取成员列表，会将部门、标签进行打散处理，获取部门、标签范围内的全部成员。
     * 最终以成员userid的形式返回。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("msgaudit/get_permit_user_list")
    GenericResponse<List<String>> getPermitUserList(@Body PermitUsersRequest request) throws WeComException;

    /**
     * 单聊获取会话同意情况
     * <p>
     * 备注说明：目前一次请求只支持最多100个查询条目，超过此限制的请求会被拦截，请调用方减少单次请求的查询个数。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("msgaudit/check_single_agree")
    GenericResponse<List<SingleAgreeDetail>> checkSingleAgree(@Body AgreeInfoRequest request) throws WeComException;

    /**
     * 群聊获取会话同意情况
     * <p>
     * 此接口可以查询对应roomid里面所有外企业的外部联系人的同意情况
     *
     * @param roomId the room id
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("msgaudit/check_room_agree")
    GenericResponse<List<ChatAgreeDetail>> checkRoomAgree(@Body RoomId roomId) throws WeComException;

    /**
     * 获取会话内容存档内部群信息
     * <p>
     * 企业可通过此接口，获取会话内容存档本企业的内部群信息，
     * 包括群名称、群主id、公告、群创建时间以及所有群成员的id与加入时间。
     * 此接口可以查询roomid对应的群信息，roomid可以从会话内容存档中获取到的roomid填充。只支持内部群
     *
     * @param roomId the room id
     * @return the groupchat
     * @throws WeComException the weComException
     */
    @POST("msgaudit/groupchat/get")
    InnerChatInfoResponse getGroupchat(@Body RoomId roomId) throws WeComException;
}
