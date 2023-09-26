/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.checkin.CheckinDataRequest;
import cn.felord.domain.checkin.CheckinDataResponse;
import cn.felord.domain.checkin.CheckinDayData;
import cn.felord.domain.checkin.CheckinMonthData;
import cn.felord.domain.checkin.CheckinOptionResponse;
import cn.felord.domain.checkin.CheckinStatisticsRequest;
import cn.felord.domain.checkin.CheckinStatisticsResponse;
import cn.felord.domain.checkin.UserCheckinOptionRequest;
import cn.felord.domain.checkin.UserCheckinOptionResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 打卡API
 *
 * @author dax
 * @since 2023 /9/25
 */
public interface CheckinApi {

    /**
     * 获取企业所有打卡规则
     *
     * @return the corp checkin option
     * @throws WeComException the we com exception
     */
    @POST("checkin/getcorpcheckinoption")
    CheckinOptionResponse getCorpCheckinOption() throws WeComException;

    /**
     * 获取员工打卡规则
     * <ol>
     *     <li>用户列表不超过100个，若用户超过100个，请分批获取。</li>
     *     <li>用户在不同日期的规则不一定相同，请按天获取。</li>
     * </ol>
     *
     * @param request the request
     * @return the checkin option
     * @throws WeComException the we com exception
     */
    @POST("checkin/getcheckinoption")
    UserCheckinOptionResponse getCheckinOption(@Body UserCheckinOptionRequest request) throws WeComException;

    /**
     * 获取打卡记录数据
     * <ol>
     *     <li>获取记录时间跨度不超过30天</li>
     *     <li>用户列表不超过100个。若用户超过100个，请分批获取</li>
     *     <li>有打卡记录即可获取打卡数据，与当前"打卡应用"是否开启无关</li>
     *     <li>标准打卡时间只对于固定排班和自定义排班两种类型有效</li>
     *     <li>接口调用频率限制为600次/分钟</li>
     * </ol>
     *
     * @param request the request
     * @return the checkin data
     * @throws WeComException the we com exception
     */
    @POST("checkin/getcheckindata")
    CheckinDataResponse getCheckinData(@Body CheckinDataRequest request) throws WeComException;

    /**
     * 获取打卡日报数据
     * <p>
     * 企业可通过打卡应用Secret调用本接口，获取指定员工指定时间段内的打卡日报统计数据。
     * 第三方应用可获取应用可见范围内指定员工指定日期内的打卡日报统计数据。
     *
     * @param request the request
     * @return the checkin day data
     * @throws WeComException the we com exception
     */
    @POST("checkin/getcheckin_daydata")
    CheckinStatisticsResponse<CheckinDayData> getCheckinDayData(@Body CheckinStatisticsRequest request) throws WeComException;

    /**
     * 获取打卡月报数据
     *
     * @param request the request
     * @return the checkin month data
     * @throws WeComException the we com exception
     */
    @POST("checkin/getcheckin_monthdata")
    CheckinStatisticsResponse<CheckinMonthData> getCheckinMonthData(@Body CheckinStatisticsRequest request) throws WeComException;
}
