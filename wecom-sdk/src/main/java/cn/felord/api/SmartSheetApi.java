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
import cn.felord.domain.WeComResponse;
import cn.felord.domain.wedoc.smartsheet.AddOrUpdateFieldsRequest;
import cn.felord.domain.wedoc.smartsheet.AddRecordRequest;
import cn.felord.domain.wedoc.smartsheet.AddSheetRequest;
import cn.felord.domain.wedoc.smartsheet.AddViewRequest;
import cn.felord.domain.wedoc.smartsheet.DelFieldsRequest;
import cn.felord.domain.wedoc.smartsheet.DelRecordRequest;
import cn.felord.domain.wedoc.smartsheet.DelSheetRequest;
import cn.felord.domain.wedoc.smartsheet.DelViewRequest;
import cn.felord.domain.wedoc.smartsheet.QuerySheetRequest;
import cn.felord.domain.wedoc.smartsheet.RecordResult;
import cn.felord.domain.wedoc.smartsheet.SheetField;
import cn.felord.domain.wedoc.smartsheet.SheetViewDetail;
import cn.felord.domain.wedoc.smartsheet.SheetViewInfo;
import cn.felord.domain.wedoc.smartsheet.SmartFieldsRequest;
import cn.felord.domain.wedoc.smartsheet.SmartFieldsResponse;
import cn.felord.domain.wedoc.smartsheet.SmartRecordsRequest;
import cn.felord.domain.wedoc.smartsheet.SmartRecordsResponse;
import cn.felord.domain.wedoc.smartsheet.SmartSheetInfo;
import cn.felord.domain.wedoc.smartsheet.SmartSheetProperties;
import cn.felord.domain.wedoc.smartsheet.SmartViewRequest;
import cn.felord.domain.wedoc.smartsheet.SmartViewsResponse;
import cn.felord.domain.wedoc.smartsheet.UpdateRecordRequest;
import cn.felord.domain.wedoc.smartsheet.UpdateSheetRequest;
import cn.felord.domain.wedoc.smartsheet.UpdateViewRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 智能表格操作相关API
 *
 * @author dax
 * @since 2024 /8/30
 */
public interface SmartSheetApi {


    /**
     * 添加子表
     * <p>
     * 本接口用于在表格的某个位置添加一个智能表，
     * 该智能表不存在视图、记录和字段，可以使用 API 在该智能表中添加视图、记录和字段。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/add_sheet")
    GenericResponse<SmartSheetProperties> addSheet(@Body AddSheetRequest request) throws WeComException;

    /**
     * 删除子表
     * <p>
     * 本接口用于删除在线表格中的某个智能表。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/delete_sheet")
    WeComResponse deleteSheet(@Body DelSheetRequest request) throws WeComException;

    /**
     * 更新子表
     * <p>
     * 本接口用于修改表格中某个子表的标题。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/update_sheet")
    WeComResponse updateSheet(@Body UpdateSheetRequest request) throws WeComException;

    /**
     * 添加视图
     * <p>
     * 本接口用于在 Smartsheet 中的某个子表里添加一个新视图。单表最多允许有200个视图。
     *
     * @param request the request
     * @return generic response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/add_view")
    GenericResponse<SheetViewInfo> addView(@Body AddViewRequest request) throws WeComException;

    /**
     * 删除视图
     * <p>
     * 本接口用于在 smartsheet 中的某个子表里删除若干个视图。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/delete_views")
    WeComResponse deleteViews(@Body DelViewRequest request) throws WeComException;

    /**
     * 更新视图
     * <p>
     * 本接口用于在 Smartsheet 中的某个子表里添加一个新视图。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/update_view")
    GenericResponse<SheetViewDetail> updateView(@Body UpdateViewRequest request) throws WeComException;

    /**
     * 添加字段
     * <p>
     * 本接口用于在智能表中的某个子表里添加一列或多列新字段。单表最多允许有150个字段。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/add_fields")
    GenericResponse<List<SheetField>> addFields(@Body AddOrUpdateFieldsRequest request) throws WeComException;

    /**
     * 删除字段
     * <p>
     * 本接口用于删除智能表中的某个子表里的一列或多列字段。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/delete_fields")
    WeComResponse deleteFields(@Body DelFieldsRequest request) throws WeComException;

    /**
     * 更新字段
     * <p>
     * 本接口用于更新智能中的某个子表里的一个或多个字段的标题和字段属性信息。
     * 该接口只能更新字段名、字段属性，不能更新字段类型。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/update_fields")
    GenericResponse<List<SheetField>> updateFields(@Body AddOrUpdateFieldsRequest request) throws WeComException;

    /**
     * 添加记录
     * <p>
     * 本接口用于在 Smartsheet 中的某个子表里添加一行或多行新记录。单表最多允许有40000行记录。
     * 不能通过添加记录接口给创建时间、最后编辑时间、创建人和最后编辑人四种类型的字段添加记录。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/add_records")
    GenericResponse<List<RecordResult>> addRecords(@Body AddRecordRequest request) throws WeComException;

    /**
     * 删除记录
     * <p>
     * 本接口用于删除 Smartsheet 的某个子表中的一行或多行记录。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/delete_records")
    WeComResponse deleteRecords(@Body DelRecordRequest request) throws WeComException;

    /**
     * 更新记录
     * <p>
     * 本接口用于更新 Smartsheet 中的某个子表里的一行或多行记录。
     * 注意：不能通过更新记录接口给创建时间、最后编辑时间、创建人和最后编辑人四种类型的字段更新记录。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/update_records")
    GenericResponse<List<RecordResult>> updateRecords(@Body UpdateRecordRequest request) throws WeComException;

    /**
     * 查询子表
     * <p>
     * 本接口用于查询一篇在线表格中全部智能表信息。
     *
     * @param request the request
     * @return the sheet
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/get_sheet")
    GenericResponse<List<SmartSheetInfo>> getSheet(@Body QuerySheetRequest request) throws WeComException;

    /**
     * 查询视图
     * <p>
     * 本接口用于获取 Smartsheet 中某个子表里全部视图信息。
     *
     * @param request the request
     * @return the views
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/get_views")
    SmartViewsResponse getViews(@Body SmartViewRequest request) throws WeComException;

    /**
     * 查询字段
     * <p>
     * 本接口用于获取智能表中某个子表下字段信息，
     * 该接口可以完成下面三种功能：获取全部字段信息、依据字段名获取对应字段、依据字段 ID 获取对应字段信息。
     *
     * @param request the request
     * @return the fields
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/get_fields")
    SmartFieldsResponse getFields(@Body SmartFieldsRequest request) throws WeComException;

    /**
     * 查询记录
     * <p>
     * 本接口用于获取 Smartsheet 中某个子表下记录信息，
     * 该接口可以完成下面三种功能：获取全部记录信息、依据字段名和记录 ID 获取对应记录、对记录进行排序。
     *
     * @param request the request
     * @return the records
     * @throws WeComException the we com exception
     */
    @POST("wedoc/smartsheet/get_records")
    SmartRecordsResponse getRecords(@Body SmartRecordsRequest request) throws WeComException;
}
