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
import cn.felord.domain.callcenter.KfAndExternalUser;
import cn.felord.domain.callcenter.KfEventMessageRequest;
import cn.felord.domain.callcenter.KfMessageRequest;
import cn.felord.domain.callcenter.KfSessionResponse;
import cn.felord.domain.callcenter.KfSessionUpdateRequest;
import cn.felord.domain.callcenter.SyncMsgRequest;
import cn.felord.domain.callcenter.SyncMsgResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 会话分配与消息收发
 *
 * @author dax
 * @since 2021 /7/23 13:52
 */
public interface KfSessionApi {

    /**
     * 获取会话状态
     *
     * @param kfAndExternalUser the kf and external user
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("kf/service_state/get")
    KfSessionResponse getSessionState(@Body KfAndExternalUser kfAndExternalUser) throws WeComException;

    /**
     * 变更会话状态
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("kf/service_state/trans")
    GenericResponse<String> trans(@Body KfSessionUpdateRequest request) throws WeComException;

    /**
     * 读取消息
     *
     * @param request the request
     * @return the sync msg response
     * @throws WeComException the weComException
     */
    @POST("kf/sync_msg")
    SyncMsgResponse syncMsg(@Body SyncMsgRequest request) throws WeComException;

    /**
     * 发送消息
     * <p>
     * 当微信客户处于“新接入待处理”或“由智能助手接待”状态下，可调用该接口给用户发送消息。
     * 注意仅当微信客户在主动发送消息给客服后的48小时内，企业可发送消息给客户，最多可发送5条消息；若用户继续发送消息，企业可再次下发消息。
     * 支持发送消息类型：文本、图片、语音、视频、文件、图文、小程序、菜单消息、地理位置。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("kf/send_msg")
    GenericResponse<String> sendMsg(@Body KfMessageRequest request) throws WeComException;

    /**
     * 发送欢迎语等事件响应消息
     * <p>
     * 用户在过去48小时里未收过欢迎语，且未向客服发过消息
     * <p>
     * 当特定的事件回调消息包含code字段，或通过接口变更到特定的会话状态，会返回code字段。
     * 开发者可以此code为凭证，调用该接口给用户发送相应事件场景下的消息，如客服欢迎语、客服提示语和会话结束语等。
     * 除"用户进入会话事件"以外，响应消息仅支持会话处于获取该code的会话状态时发送，如将会话转入待接入池时获得的code仅能在会话状态为”待接入池排队中“时发送。
     * <table>
     *    <caption>事件场景说明</caption>
     *    <thead>
     *      <tr>
     *        <th>事件场景</th><th>允许下发条数</th><th>code有效期</th><th>支持的消息类型</th><th>获取code途径</th>
     *      </tr>
     *    </thead>
     *     <tr>
     *         <td>用户进入会话，用于发送客服欢迎语</td><td>1条</td><td>20秒</td><td>文本、菜单</td><td>事件回调</td>
     *     </tr>
     *     <tr>
     *         <td>进入接待池，用于发送排队提示语等</td><td>1条</td><td>48小时</td><td>文本</td><td>转接会话接口</td>
     *     </tr>
     *     <tr>
     *         <td>从接待池接入会话，用于发送非工作时间的提示语或超时未回复的提示语等</td><td>1条</td><td>48小时</td><td>文本</td><td>事件回调、转接会话接口</td>
     *      </tr>
     *      <tr>
     *          <td>结束会话，用于发送结束会话提示语或满意度评价等</td><td>1条</td><td>20秒</td><td>文本、菜单</td><td>事件回调、转接会话接口</td>
     *      </tr>
     * </table>
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("kf/send_msg_on_event")
    GenericResponse<String> sendEventMsg(@Body KfEventMessageRequest request) throws WeComException;
}
