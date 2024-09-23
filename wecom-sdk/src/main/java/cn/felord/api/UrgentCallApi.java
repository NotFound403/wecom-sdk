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
import cn.felord.domain.urgentcall.CallResponse;
import cn.felord.domain.urgentcall.CallStateRequest;
import cn.felord.domain.urgentcall.CallStateResponse;
import cn.felord.domain.urgentcall.CalleeUsers;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 紧急通知API
 * <p>
 * 【医疗行业】的企业，可通过语音电话提醒员工查看应用推送的重要消息，以便尽快处理紧急事件
 *
 * @author dax
 * @since 2024/5/31 12:44
 */
public interface UrgentCallApi {

    /**
     * 发起语音电话
     * <p>
     * 通过此接口发起语音电话，提醒员工查看应用推送的重要消息
     *
     * @param callUsers the call users
     * @return the call response
     */
    @POST("pstncc/call")
    CallResponse call(@Body CalleeUsers callUsers) throws WeComException;

    /**
     * 获取接听状态
     *
     * @param request the request
     * @return the call state response
     */
    @POST("pstncc/getstates")
    CallStateResponse queryCallStates(@Body CallStateRequest request) throws WeComException;
}
