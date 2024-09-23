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

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.journal.JournalExportRequest;
import cn.felord.domain.journal.JournalRecordDetail;
import cn.felord.domain.journal.JournalRecordRequest;
import cn.felord.domain.journal.JournalRecordResponse;
import cn.felord.domain.journal.JournalStatRequest;
import cn.felord.domain.journal.JournalStatResponse;
import cn.felord.domain.journal.JournalUuid;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 汇报API
 *
 * @author dax
 * @since 2024/10/14
 */
public interface JournalApi {

    /**
     * 批量获取汇报记录单号
     * <p>
     * 企业可通过access_token调用本接口，以获取企业一段时间内企业微信“汇报应用”汇报记录编号，支持按汇报表单ID、申请人、部门等条件筛选。
     * <p>
     * 一次拉取调用最多拉取100个汇报记录，可以通过多次拉取的方式来满足需求，但调用频率不可超过600次/分。
     * <p>
     * 表单ID的获取方式：管理后台--汇报应用--某个汇报的内容设置页--点击“汇报名称”，即可获取
     *
     * @param request the request
     * @return the record list
     * @throws WeComException the weComException
     */
    @POST("oa/journal/get_record_list")
    Single<JournalRecordResponse> getRecordList(@Body JournalRecordRequest request) throws WeComException;

    /**
     * 获取汇报记录详情
     * <p>
     * 根据汇报记录单号查询企业微信“汇报应用”的汇报详情。
     *
     * @param journalUuid the journal uuid
     * @return the record detail
     * @throws WeComException the weComException
     */
    @POST("oa/journal/get_record_detail")
    Single<GenericResponse<JournalRecordDetail>> getRecordDetail(@Body JournalUuid journalUuid) throws WeComException;

    /**
     * Gets stat list.
     *
     * @param request the request
     * @return the stat list
     * @throws WeComException the weComException
     */
    @POST("oa/journal/get_stat_list")
    Single<JournalStatResponse> getStatList(@Body JournalStatRequest request) throws WeComException;

    /**
     * 导出汇报文档
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     * @deprecated 企业微信4.0.20版本后 ，不会有新增的文档控件数据。开发者可通过文档url进一步查看或导出文档
     */
    @Deprecated
    @POST("oa/journal/export_doc")
    Single<GenericResponse<String>> exportDoc(@Body JournalExportRequest request) throws WeComException;

}
