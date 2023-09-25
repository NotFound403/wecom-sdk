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
import cn.felord.domain.checkin.CheckinOptionResponse;
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
     */
    @POST("checkin/getcorpcheckinoption")
    CheckinOptionResponse getCorpCheckinOption();

    /**
     * 获取打卡记录数据
     *
     * @param request the request
     * @return the checkin data
     * @throws WeComException the we com exception
     */
    @POST("checkin/getcheckindata")
    CheckinDataResponse getCheckinData(@Body CheckinDataRequest request) throws WeComException;

}
