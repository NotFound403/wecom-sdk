/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.callcenter.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * 会话分配与消息收发
 *
 * @author dax
 * @since 2021 /7/23 13:52
 */
public class KfSessionApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Kf session api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    KfSessionApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取会话状态
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @return the generic response
     */
    public KfSessionResponse getSessionState(String openKfid, String externalUserid) {
        Map<String, String> body = new HashMap<>(2);
        body.put("open_kfid", openKfid);
        body.put("external_userid", externalUserid);
        return workWeChatApiClient.post(WeComEndpoint.KF_SERVICE_STATE_GET, body, KfSessionResponse.class);
    }

    /**
     * 变更会话状态
     *
     * @param request the request
     * @return the we com response
     */
    public GenericResponse<String> trans(KfSessionUpdateRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_SERVICE_STATE_TRANS, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 读取消息
     *
     * @param request the request
     * @return the sync msg response
     */
    public SyncMsgResponse syncMsg(SyncMsgRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_SYNC_MSG, request, SyncMsgResponse.class);
    }

    /**
     * 发送消息
     * <p>
     * 当微信客户处于“新接入待处理”或“由智能助手接待”状态下，可调用该接口给用户发送消息。
     * 注意仅当微信客户在主动发送消息给客服后的48小时内，企业可发送消息给客户，最多可发送5条消息；若用户继续发送消息，企业可再次下发消息。
     * 支持发送消息类型：文本、图片、语音、视频、文件、图文、小程序、菜单消息、地理位置。
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    public <R extends KfMessageRequest> GenericResponse<String> sendMsg(R request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_SEND_MSG, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 发送欢迎语等事件响应消息
     * <p>
     * 当特定的事件回调消息包含code字段，或通过接口变更到特定的会话状态，会返回code字段。
     * 开发者可以此code为凭证，调用该接口给用户发送相应事件场景下的消息，如客服欢迎语、客服提示语和会话结束语等。
     * 除"用户进入会话事件"以外，响应消息仅支持会话处于获取该code的会话状态时发送，如将会话转入待接入池时获得的code仅能在会话状态为”待接入池排队中“时发送。
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    public <R extends KfEventMessageRequest> GenericResponse<String> sendEventMsg(R request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_SEND_EVENT_MSG, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }
}
