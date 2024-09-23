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
import cn.felord.domain.living.LivingCodeRequest;
import cn.felord.domain.living.LivingCreateRequest;
import cn.felord.domain.living.LivingId;
import cn.felord.domain.living.LivingInfo;
import cn.felord.domain.living.LivingShareInfoResponse;
import cn.felord.domain.living.LivingUpdateRequest;
import cn.felord.domain.living.UserLivingsRequest;
import cn.felord.domain.living.UserLivingsResponse;
import cn.felord.domain.living.WatchStatRequest;
import cn.felord.domain.living.WatchStatResponse;
import cn.felord.domain.living.WwShareCode;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 直播API
 *
 * @author dax
 * @since 2024/11/23
 */
public interface LivingApi {

    /**
     * 创建预约直播
     * <p>
     * 权限说明：
     * <ul>
     *     <li>发起人必须在应用可见范围内，「上课直播/直播」应用默认全员可见</li>
     *     <li>系统应用「上课直播/直播」默认可使用直播接口</li>
     *     <li>自建应用需要配置在“可调用接口的应用”里</li>
     *     <li>第三方服务商创建应用的时候，需要开启“直播接口权限”</li>
     * </ul>
     *
     * @param request the request
     * @return the generic response
     */
    @POST("living/create")
    Single<GenericResponse<String>> create(@Body LivingCreateRequest request);

    /**
     * 修改预约直播
     * <p>
     * 权限说明：
     * <ul>
     *     <li>仅允许修改当前应用创建的直播。</li>
     * </ul>
     *
     * @param request the request
     * @return the we com response
     */
    @POST("living/modify")
    Single<WeComResponse> modify(@Body LivingUpdateRequest request);

    /**
     * 取消预约直播
     * <p>
     * 权限说明：
     * <ul>
     *     <li>仅允许取消当前应用创建的直播。</li>
     * </ul>
     *
     * @param livingId the living id
     * @return the we com response
     */
    @POST("living/cancel")
    Single<WeComResponse> cancel(@Body LivingId livingId);

    /**
     * 删除直播回放
     * <p>
     * 权限说明：
     * <ul>
     *     <li>仅允许删除当前应用的直播回放。</li>
     * </ul>
     *
     * @param livingId the living id
     * @return the we com response
     */
    @POST("living/delete_replay_data")
    Single<WeComResponse> deleteReplayData(@Body LivingId livingId);

    /**
     * 获取微信观看直播凭证
     * <p>
     * 权限说明：
     * <ul>
     *     <li>非直播系统应用仅允许获取当前应用创建的微信观看直播凭证。</li>
     *     <li>直播系统应用可以调用该企业任意直播的微信观看直播凭证。</li>
     * </ul>
     *
     * @param request the request
     * @return the generic response
     */
    @POST("living/get_living_code")
    Single<GenericResponse<String>> getLivingCode(@Body LivingCodeRequest request);

    /**
     * 获取成员直播ID列表
     * <p>
     * 通过此接口可以获取指定成员的所有直播ID
     * <p>
     * 权限说明：
     * <ul>
     *     <li>「上课直播/直播」应用有获取用户的所有直播</li>
     *     <li>自建应用和第三方应用只能获取本应用创建的直播</li>
     * </ul>
     *
     * @param request the request
     * @return the user all livingid
     */
    @POST("living/get_user_all_livingid")
    Single<UserLivingsResponse> getUserAllLivingid(@Body UserLivingsRequest request);

    /**
     * 获取直播详情
     * <p>
     * 权限说明：
     * <ul>
     *     <li>「上课直播/直播」应用有获取用户的所有直播</li>
     *     <li>自建应用和第三方应用只能获取本应用创建的直播</li>
     * </ul>
     *
     * @param livingid the livingid
     * @return the living info
     */
    @GET("living/get_living_info")
    Single<GenericResponse<LivingInfo>> getLivingInfo(@Query("livingid") String livingid);

    /**
     * 获取直播观看明细
     * <p>
     * 通过该接口可以获取所有观看直播的人员统计
     * <p>
     * 权限说明：
     * <ul>
     *     <li>「上课直播/直播」应用有获取用户的所有直播</li>
     *     <li>自建应用和第三方应用只能获取本应用创建的直播</li>
     * </ul>
     *
     * @param request the request
     * @return the user all livingid
     */
    @POST("living/get_watch_stat")
    Single<WatchStatResponse> getWatchStat(@Body WatchStatRequest request);

    /**
     * 获取跳转小程序商城的直播观众信息
     * <p>
     * 通过此接口，开发者可获取跳转小程序商城的直播间(“推广产品”直播)观众id、邀请人id及对应直播间id，以打通卖货直播的“人货场”信息闭环。
     * <p>
     * 权限说明：
     * <ul>
     *     <li>系统应用「直播」默认可使用此接口</li>
     *     <li>自建应用需要配置在“可调用接口的应用”里</li>
     *     <li>第三方服务商创建应用的时候，需要开启“直播接口权限”</li>
     *     <li>跳转的小程序需要与企业有绑定关系</li>
     * </ul>
     *
     * @param wwShareCode the wwShareCode
     * @return the user all livingid
     */
    @POST("living/get_living_share_info")
    Single<LivingShareInfoResponse> getLivingShareInfo(@Body WwShareCode wwShareCode);
}
