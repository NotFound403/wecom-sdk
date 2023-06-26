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
import cn.felord.domain.common.PageRequest;
import cn.felord.domain.externalcontact.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 获客助手
 *
 * @author dax
 * @since 2023 /5/30 21:28
 */
public interface CustomerAcquisitionApi {

    /**
     * 获取获客链接列表
     *
     * @param request the request
     * @return the follow user list
     */
    @POST("externalcontact/customer_acquisition/list_link")
    LinksResponse queryLinks(@Body PageRequest request);

    /**
     * 获取获客链接详情
     *
     * @param linkId the link id
     * @return the we com response
     */
    @POST("externalcontact/customer_acquisition/get")
    LinkDetailResponse queryLinkDetail(@Body LinkId linkId);

    /**
     * 创建获客链接
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/customer_acquisition/create_link")
    GenericResponse<AcquisitionLink> createLink(@Body AcquisitionLinkCreateRequest request);

    /**
     * 编辑获客链接
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/customer_acquisition/update_link")
    WeComResponse updateLink(@Body AcquisitionLinkUpdateRequest request);

    /**
     * 删除获客链接
     *
     * @param linkId the link id
     * @return the we com response
     */
    @POST("externalcontact/customer_acquisition/delete_link")
    WeComResponse deleteLink(@Body LinkId linkId);

    /**
     * 获取由获客链接添加的客户信息
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/customer_acquisition/customer")
    LinkCustomersResponse queryLinkCustomers(@Body LinkPageRequest request);

    /**
     * 查询获客链接剩余使用量
     *
     * @return the we com response
     */
    @GET("externalcontact/customer_acquisition_quota")
    AcquisitionQuotaResponse queryCustomerAcquisitionQuotas();
}
