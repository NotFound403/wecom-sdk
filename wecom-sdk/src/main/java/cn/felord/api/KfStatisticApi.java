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
import cn.felord.domain.callcenter.*;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 客服统计管理
 *
 * @author dax
 * @since 2024/6/6
 */
public interface KfStatisticApi {

    /**
     * 获取「客户数据统计」企业汇总数据
     *
     * @param request the request
     * @return the kf statistic response
     * @throws WeComException the weComException
     */
    @POST("kf/get_corp_statistic")
    KfStatisticResponse<KfCorpStatisticDetail> corpStatistic(@Body KfCorpStatisticRequest request) throws WeComException;

    /**
     * 获取「客户数据统计」接待人员明细数据
     *
     * @param request the request
     * @return the kf statistic response
     * @throws WeComException the weComException
     */
    @POST("kf/get_servicer_statistic")
    KfStatisticResponse<KfServicerStatisticDetail> servicerStatistic(@Body KfServicerStatisticRequest request) throws WeComException;
}
