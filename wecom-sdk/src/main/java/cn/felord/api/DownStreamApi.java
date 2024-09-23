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
import cn.felord.domain.MiniprogramSession;
import cn.felord.domain.corpgroup.ExPendingIdRequest;
import cn.felord.domain.corpgroup.MiniprogramSessionResponse;
import cn.felord.domain.corpgroup.PendingExUser;
import cn.felord.domain.corpgroup.UnionPendingIdRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 上下游-下游调用
 *
 * @author dax
 * @since 2024/10/12
 */
public interface DownStreamApi {

    /**
     * 获取下级/下游企业小程序session
     * <p>
     * 上级/上游企业通过该接口转换为下级/下游企业的小程序session
     * <p>
     * 必须使用下级/下游企业的 access_token，且access_token对应的下级/下游企业应用，必须是session_key对应的上级/上游企业应用分享而来
     *
     * @param session the session
     * @return the miniprogram session response
     * @throws WeComException the weComException
     */
    @POST("miniprogram/transfer_session")
    MiniprogramSessionResponse transferSession(@Body MiniprogramSession session) throws WeComException;

    /**
     * external_userid查询pending_id (下游专用)
     *
     * <ul>
     *     <li>调用该接口的应用必须是上下游共享的自建应用或代开发应用</li>
     *     <li>应用需要具有客户联系权限</li>
     *     <li>该客户的跟进人或其所在客户群群主必须在应用的可见范围之内</li>
     *     <li>上游应用须调用过{@link UpStreamApi#unionidToPendingId(UnionPendingIdRequest)}</li>
     *     <li>上游和下游企业须认证或验证；若为代开发应用，服务商必须已认证</li>
     * </ul>
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     * @see UpStreamApi#externalUseridToPendingId(ExPendingIdRequest) 上游专用
     */
    @POST("corpgroup/batch/external_userid_to_pending_id")
    GenericResponse<List<PendingExUser>> externalUseridToPendingId(ExPendingIdRequest request) throws WeComException;
}
