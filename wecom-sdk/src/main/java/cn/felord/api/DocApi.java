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
import cn.felord.domain.common.FormId;
import cn.felord.domain.wedoc.doc.AccessRuleUpdateRequest;
import cn.felord.domain.wedoc.doc.CreateDocRequest;
import cn.felord.domain.wedoc.doc.CreateDocResponse;
import cn.felord.domain.wedoc.doc.DocAuthResponse;
import cn.felord.domain.wedoc.doc.DocBaseInfo;
import cn.felord.domain.wedoc.doc.DocBatchUpdateRequest;
import cn.felord.domain.wedoc.doc.DocId;
import cn.felord.domain.wedoc.doc.DocSecuritySetting;
import cn.felord.domain.wedoc.doc.FileMemberUpdateRequest;
import cn.felord.domain.wedoc.doc.RenameDocRequest;
import cn.felord.domain.wedoc.doc.SheetBatchUpdateRequest;
import cn.felord.domain.wedoc.doc.SheetBatchUpdateResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 文档-管理文档
 *
 * @author dax
 * @since 2024 /7/19
 */
public interface DocApi {

    /**
     * 新建文档
     * <p>
     * 该接口用于新建文档和表格，新建收集表可前往{@link FormApi}查看。
     *
     * @param request the request
     * @return the create doc response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/create_doc")
    CreateDocResponse createDoc(@Body CreateDocRequest request) throws WeComException;

    /**
     * 重命名文档
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/rename_doc")
    WeComResponse renameDoc(@Body RenameDocRequest request) throws WeComException;

    /**
     * 删除文档
     *
     * @param docId the doc id
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/del_doc")
    WeComResponse delDoc(@Body DocId docId) throws WeComException;

    /**
     * 删除收集表
     *
     * @param formId the form id
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/del_doc")
    WeComResponse delDoc(@Body FormId formId) throws WeComException;

    /**
     * 获取文档基础信息
     * <ul>
     *     <li>自建应用需配置到“可调用应用”列表中的应用secret所获取的accesstoken来调用</li>
     *     <li>第三方应用需具有“文档”权限</li>
     *     <li>代开发自建应用需具有“文档”权限</li>
     * </ul>
     *
     * @param docId the doc id
     * @return the doc base info
     * @throws WeComException the we com exception
     */
    @POST("wedoc/get_doc_base_info")
    GenericResponse<DocBaseInfo> getDocBaseInfo(@Body DocId docId) throws WeComException;

    /**
     * 分享文档
     *
     * @param docId the doc id
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/doc_share")
    GenericResponse<String> docShare(@Body DocId docId) throws WeComException;

    /**
     * 编辑文档内容
     * <p>
     * 该接口可以对一个在线文档批量执行多个更新操作。
     *
     * <ul>
     *     <li>批量更新请求，若其中有一个操作报错则全部更新操作不生效。</li>
     *     <li>单次批量更新操作数量不大于30。</li>
     * </ul>
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/document/batch_update")
    WeComResponse batchUpdateDocument(@Body DocBatchUpdateRequest request) throws WeComException;

    /**
     * 编辑表格内容
     * <p>
     * 该接口可以对一个在线表格批量执行多个更新操作，注意：
     * <ul>
     *     <li>批量更新请求中的各个操作会逐个按顺序执行，直到全部执行完成则请求返回，或者其中一个操作报错则不再继续执行后续的操作。</li>
     *     <li>每一个更新操作在执行之前都会做请求校验（包括权限校验、参数校验等等），如果校验未通过则该更新操作会报错并返回，不再执行后续操作。</li>
     *     <li>单次批量更新请求的操作数量 不大于 5。</li>
     * </ul>
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/spreadsheet/batch_update")
    GenericResponse<SheetBatchUpdateResponse> batchUpdateSheet(@Body SheetBatchUpdateRequest request) throws WeComException;

    /**
     * 分享收集表
     *
     * @param formId the form id
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/doc_share")
    GenericResponse<String> docShare(@Body FormId formId) throws WeComException;

    /**
     * 获取文档权限信息
     *
     * @param docId the doc id
     * @return the doc auth response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/doc_get_auth")
    DocAuthResponse docGetAuth(@Body DocId docId) throws WeComException;

    /**
     * 修改文档查看规则
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/mod_doc_join_rule")
    WeComResponse modDocJoinRule(@Body AccessRuleUpdateRequest request) throws WeComException;

    /**
     * 修改文档通知范围及权限
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/mod_doc_member")
    WeComResponse modDocMember(@Body FileMemberUpdateRequest request) throws WeComException;

    /**
     * 修改文档安全设置
     *
     * @param setting the setting
     * @return the we com response
     * @throws WeComException the we com exception
     */
    @POST("wedoc/mod_doc_safty_setting")
    WeComResponse modDocSaftySetting(@Body DocSecuritySetting setting) throws WeComException;
}
