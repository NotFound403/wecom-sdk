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
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.FormId;
import cn.felord.domain.wedoc.doc.*;
import io.reactivex.rxjava3.core.Single;
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
     */
    @POST("wedoc/create_doc")
    Single<CreateDocResponse> createDoc(@Body CreateDocRequest request);

    /**
     * 重命名文档
     *
     * @param request the request
     * @return the we com response
     */
    @POST("wedoc/rename_doc")
    Single<WeComResponse> renameDoc(@Body RenameDocRequest request);

    /**
     * 删除文档
     *
     * @param docId the doc id
     * @return the we com response
     */
    @POST("wedoc/del_doc")
    Single<WeComResponse> delDoc(@Body DocId docId);

    /**
     * 删除收集表
     *
     * @param docId the doc id
     * @return the we com response
     */
    @POST("wedoc/del_doc")
    Single<WeComResponse> delDoc(@Body FormId docId);

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
     */
    @POST("wedoc/get_doc_base_info")
    Single<GenericResponse<DocBaseInfo>> getDocBaseInfo(@Body DocId docId);

    /**
     * 分享文档
     *
     * @param docId the doc id
     * @return the we com response
     */
    @POST("wedoc/doc_share")
    Single<GenericResponse<String>> docShare(@Body DocId docId);

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
    Single<WeComResponse> batchUpdateDocument(@Body DocBatchUpdateRequest request);

    /**
     * 获取文档权限信息
     *
     * @param docId the doc id
     * @return the doc auth response
     */
    @POST("wedoc/doc_get_auth")
    Single<DocAuthResponse> docGetAuth(@Body DocId docId);

    /**
     * 修改文档查看规则
     *
     * @param request the request
     * @return the we com response
     */
    @POST("wedoc/mod_doc_join_rule")
    Single<WeComResponse> modDocJoinRule(@Body AccessRuleUpdateRequest request);

    /**
     * 修改文档通知范围及权限
     *
     * @param request the request
     * @return the we com response
     */
    @POST("wedoc/mod_doc_member")
    Single<WeComResponse> modDocMember(@Body FileMemberUpdateRequest request);

    /**
     * 修改文档安全设置
     *
     * @param setting the setting
     * @return the we com response
     */
    @POST("wedoc/mod_doc_safty_setting")
    Single<WeComResponse> modDocSaftySetting(@Body DocSecuritySetting setting);
}
