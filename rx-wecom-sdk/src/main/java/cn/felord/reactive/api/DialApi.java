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
import cn.felord.domain.dial.DialRecord;
import cn.felord.domain.dial.DialRecordsRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公费电话API
 *
 * @author dax
 * @since 2024/10/6
 */
public interface DialApi {

    /**
     * 获取公费电话拨打记录
     * <p>
     * 企业可通过此接口，按时间范围拉取成功接通的公费电话拨打记录。
     * <p>
     * 请注意，查询的时间范围为[start_time,end_time]，即前后均为闭区间。
     * 在两个参数都指定了的情况下，结束时间不得小于开始时间，开始时间也不得早于当前时间，否则会返回600018错误码(无效的起止时间)。
     * 受限于网络传输，起止时间的最大跨度为30天，如超过30天，则以结束时间为基准向前取30天进行查询。
     * 如果未指定起止时间，则默认查询最近30天范围内数据。
     *
     * @param request the request
     * @return the dial record
     */
    @POST("dial/get_dial_record")
    Single<GenericResponse<List<DialRecord>>> getDialRecord(@Body DialRecordsRequest request);
}
