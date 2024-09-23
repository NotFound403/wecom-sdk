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

import cn.felord.domain.externalcontact.*;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 联系客户统计管理
 *
 * @author dax
 * @since 2021 /9/23 11:30
 */
public interface ExternalStatisticApi {

    /**
     * 获取「联系客户统计」数据
     * <p>
     * userid和partyid不可同时为空;
     * 此接口提供的数据以天为维度，查询的时间范围为[start_time,end_time]，即前后均为闭区间，支持的最大查询跨度为30天；
     * 用户最多可获取最近180天内的数据；
     * 当传入的时间不为0点时间戳时，会向下取整，如传入1554296400(Wed Apr 3 21:00:00 CST 2019)会被自动转换为1554220800（Wed Apr 3 00:00:00 CST 2019）;
     * 如传入多个userid，则表示获取这些成员总体的联系客户数据。
     *
     * @param request the request
     * @return the user behavior data
     */
    @POST("externalcontact/get_user_behavior_data")
    Single<UserBehaviorDataResponse> getUserBehaviorData(@Body UserBehaviorDataRequest request);

    /**
     * 获取「群聊数据统计」数据-按群主聚合的方式
     * <p>
     * 此接口查询的时间范围为 [day_begin_time, day_end_time]，前后均为闭区间（即包含day_end_time当天的数据），支持的最大查询跨度为30天；
     * 用户最多可获取最近180天内的数据（超过180天企业微信将不再存储）；
     * 当传入的时间不为0点时，会向下取整，如传入1554296400(Wed Apr 3 21:00:00 CST 2019)会被自动转换为1554220800（Wed Apr 3 00:00:00 CST 2019）;
     *
     * @param request the request
     * @return the group chat data
     */
    @POST("externalcontact/groupchat/statistic")
    Single<GroupChatDataResponse<GroupChatDataByOwner>> getGroupChatData(@Body GroupChatOwnerDataRequest request);

    /**
     * 获取「群聊数据统计」数据-按自然日聚合的方式
     *
     * @param request the request
     * @return the group chat data by day
     */
    @POST("externalcontact/groupchat/statistic_group_by_day")
    Single<GroupChatDataResponse<GroupChatDataByDay>> getGroupChatData(@Body GroupChatDayDataRequest request);
}
