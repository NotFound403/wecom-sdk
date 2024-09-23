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
import cn.felord.domain.WeComResponse;
import cn.felord.domain.checkin.CheckinDataRequest;
import cn.felord.domain.checkin.CheckinDataResponse;
import cn.felord.domain.checkin.CheckinDayData;
import cn.felord.domain.checkin.CheckinMonthData;
import cn.felord.domain.checkin.CheckinOptionRequest;
import cn.felord.domain.checkin.CheckinOptionResponse;
import cn.felord.domain.checkin.CheckinQueryRequest;
import cn.felord.domain.checkin.CheckinStatisticsResponse;
import cn.felord.domain.checkin.CheckinUserfaceRequest;
import cn.felord.domain.checkin.ClearCheckinRequest;
import cn.felord.domain.checkin.DelCheckinRequest;
import cn.felord.domain.checkin.DeviceCheckinDataResponse;
import cn.felord.domain.checkin.DeviceCheckinQueryRequest;
import cn.felord.domain.checkin.PunchCorrectionRequest;
import cn.felord.domain.checkin.ScheduleListResponse;
import cn.felord.domain.checkin.UserCheckinOptionRequest;
import cn.felord.domain.checkin.UserCheckinOptionResponse;
import cn.felord.domain.checkin.UserScheduleRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 打卡API
 *
 * @author dax
 * @since 2024/9/25
 */
public interface CheckinApi {

    /**
     * 获取企业所有打卡规则
     *
     * @return the corp checkin option
     * @throws WeComException the weComException
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
     * @throws WeComException the weComException
     */
    @POST("checkin/getcheckinoption")
    UserCheckinOptionResponse getCheckinOption(@Body UserCheckinOptionRequest request) throws WeComException;

    /**
     * 创建打卡规则
     * <p>
     * 企业可通过打卡应用或授权的代开发应用，为企业添加打卡规则。
     *
     * @param request the request
     * @return the user checkin option response
     * @throws WeComException the weComException
     */
    @POST("checkin/add_checkin_option")
    WeComResponse addCheckinOption(@Body CheckinOptionRequest request) throws WeComException;

    /**
     * 修改打卡规则
     * <p>
     * 企业可通过打卡应用或授权的代开发应用，修改该应用为企业创建的打卡规则。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("checkin/update_checkin_option")
    WeComResponse updateCheckinOption(@Body CheckinOptionRequest request) throws WeComException;

    /**
     * 清空打卡规则数组元素
     * <p>
     * 企业可通过打卡应用或授权的代开发应用，修改该应用为企业创建的打卡规则。
     * <ol>
     *     <li>打卡规则仅可由该规则的创建应用修改。</li>
     * </ol>
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("checkin/clear_checkin_option_array_field")
    WeComResponse clearCheckinOptionArrayField(@Body ClearCheckinRequest request) throws WeComException;

    /**
     * 删除打卡规则
     * <p>
     * 企业可通过打卡应用或授权的代开发应用，修改该应用为企业创建的打卡规则。
     * <ol>
     *     <li>打卡规则仅可由该规则的创建应用修改。</li>
     * </ol>
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("checkin/del_checkin_option")
    WeComResponse delCheckinOption(@Body DelCheckinRequest request) throws WeComException;

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
     * @throws WeComException the weComException
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
     * @throws WeComException the weComException
     */
    @POST("checkin/getcheckin_daydata")
    CheckinStatisticsResponse<CheckinDayData> getCheckinDayData(@Body CheckinQueryRequest request) throws WeComException;

    /**
     * 获取打卡月报数据
     *
     * @param request the request
     * @return the checkin month data
     * @throws WeComException the weComException
     */
    @POST("checkin/getcheckin_monthdata")
    CheckinStatisticsResponse<CheckinMonthData> getCheckinMonthData(@Body CheckinQueryRequest request) throws WeComException;

    /**
     * 获取打卡人员排班信息
     * <p>
     * 仅支持为打卡规则为“按班次上下班”
     * <p>
     * 企业可通过打卡应用Secret调用本接口，获取打卡规则为“按班次上下班”规则的指定员工指定时间段内的排班信息。
     * 第三方应用获取应用可见范围内、打卡规则为“按班次上下班”规则的指定员工指定时间段内的排班信息。
     *
     * @param request the request
     * @return the checkin schedulist
     * @throws WeComException the weComException
     */
    @POST("checkin/getcheckinschedulist")
    ScheduleListResponse getCheckinScheduList(@Body CheckinQueryRequest request) throws WeComException;

    /**
     * 为打卡人员排班
     * <p>
     * 企业可通过打卡应用Secret调用本接口，为打卡规则为“按班次上下班”规则的指定员工排班。
     * 第三方应用可通过本接口为应用可见范围内、打卡规则为“按班次上下班”规则的指定员工排班。
     *
     * @param request the request
     * @return the checkin schedu list
     * @throws WeComException the weComException
     */
    @POST("checkin/setcheckinschedulist")
    WeComResponse setCheckinScheduList(@Body UserScheduleRequest request) throws WeComException;

    /**
     * 为打卡人员补卡
     * <p>
     * 暂不支持第三方调用
     *
     * @param request the request
     * @return the checkin schedu list
     * @throws WeComException the weComException
     */
    @POST("checkin/punch_correction")
    WeComResponse punchCorrection(@Body PunchCorrectionRequest request) throws WeComException;

    /**
     * 录入打卡人员人脸信息
     * <p>
     * 企业可通过打卡应用Secret调用本接口，为企业打卡人员录入人脸信息，人脸信息仅用于人脸打卡。
     * <p>
     * 注意：对于已有人脸的用户，使用此接口将使用传入的人脸覆盖原有人脸，请谨慎操作。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("checkin/addcheckinuserface")
    WeComResponse addCheckinUserface(@Body CheckinUserfaceRequest request) throws WeComException;

    /**
     * 获取设备打卡数据
     * <p>
     * 可通过此接口，获取考勤设备上产生的所有原始打卡记录，包括未被打卡应用记录的不符合打卡规则的记录。
     * 第三方应用可获取应用可见范围内员工在考勤设备上产生的所有原始打卡记录，包括未被打卡应用记录的不符合打卡规则的记录。
     * <ol>
     *     <li>获取记录时间跨度不超过一个月</li>
     *     <li>用户列表不超过100个。若用户超过100个，请分批获取</li>
     *     <li>获取的是通过考勤设备打卡的原始记录，不包含企业微信app手机打卡的记录</li>
     *     <li>userid无效时，忽略该参数，不报错</li>
     * </ol>
     *
     * @param request the request
     * @return the device checkin data response
     * @throws WeComException the weComException
     */
    @POST("checkin/addcheckinuserface")
    DeviceCheckinDataResponse addCheckinUserface(@Body DeviceCheckinQueryRequest request) throws WeComException;
}
