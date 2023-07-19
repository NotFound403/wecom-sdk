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

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.FormId;
import cn.felord.domain.wedoc.doc.CreateDocRequest;
import cn.felord.domain.wedoc.doc.CreateDocResponse;
import cn.felord.domain.wedoc.doc.DocBaseInfo;
import cn.felord.domain.wedoc.doc.DocId;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 文档-管理文档
 *
 * @author dax
 * @since 2023 /7/19
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
    CreateDocResponse createDoc(@Body CreateDocRequest request);

    /**
     * 重命名文档
     *
     * @param docId the doc id
     * @return the we com response
     */
    @POST("wedoc/rename_doc")
    WeComResponse renameDoc(@Body DocId docId);

    /**
     * 重命名收集表
     *
     * @param docId the doc id
     * @return the we com response
     */
    @POST("wedoc/rename_doc")
    WeComResponse renameDoc(@Body FormId docId);

    /**
     * 删除文档
     *
     * @param docId the doc id
     * @return the we com response
     */
    @POST("wedoc/del_doc")
    WeComResponse delDoc(@Body DocId docId);

    /**
     * 删除收集表
     *
     * @param docId the doc id
     * @return the we com response
     */
    @POST("wedoc/del_doc")
    WeComResponse delDoc(@Body FormId docId);

    /**
     * Gets doc base info.
     *
     * @param docId the doc id
     * @return the doc base info
     */
    @POST("wedoc/get_doc_base_info")
    GenericResponse<DocBaseInfo> getDocBaseInfo(@Body DocId docId);

    /**
     * 分享文档
     *
     * @param docId the doc id
     * @return the we com response
     */
    @POST("wedoc/doc_share")
    GenericResponse<String> docShare(@Body DocId docId);

    /**
     * 分享收集表
     *
     * @param docId the doc id
     * @return the we com response
     */
    @POST("wedoc/doc_share")
    GenericResponse<String> docShare(@Body FormId docId);
}
