/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.PageRequest;
import cn.felord.domain.externalcontact.AcquisitionLink;
import cn.felord.domain.externalcontact.AcquisitionLinkCreateRequest;
import cn.felord.domain.externalcontact.AcquisitionLinkUpdateRequest;
import cn.felord.domain.externalcontact.AcquisitionQuotaResponse;
import cn.felord.domain.externalcontact.LinkCustomersResponse;
import cn.felord.domain.externalcontact.LinkDetailResponse;
import cn.felord.domain.externalcontact.LinkPageRequest;
import cn.felord.domain.externalcontact.LinksResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Collections;

/**
 * 获客助手
 *
 * @author dax
 * @since 2023 /5/30 21:28
 */
public class CustomerAcquisitionApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Contact me way api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    CustomerAcquisitionApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取获客链接列表
     *
     * @param cursor the cursor
     * @param limit  the limit
     * @return the follow user list
     */
    public LinksResponse queryLinks(String cursor, int limit) {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setCursor(cursor);
        pageRequest.setLimit(limit);
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_ACQUISITION_LINKS,
                pageRequest,
                LinksResponse.class);
    }

    /**
     * 获取获客链接详情
     *
     * @param linkId the link id
     * @return the we com response
     */
    public LinkDetailResponse queryLinkDetail(String linkId) {
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_ACQUISITION_GET,
                Collections.singletonMap("link_id", linkId),
                LinkDetailResponse.class);
    }

    /**
     * 创建获客链接
     *
     * @param request the request
     * @return the we com response
     */
    public GenericResponse<AcquisitionLink> createLink(AcquisitionLinkCreateRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_ACQUISITION_CREATE,
                request,
                new ParameterizedTypeReference<GenericResponse<AcquisitionLink>>() {
                });
    }

    /**
     * 编辑获客链接
     *
     * @param request the request
     * @return the we com response
     */
    public WeComResponse updateLink(AcquisitionLinkUpdateRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_ACQUISITION_UPDATE,
                request,
                WeComResponse.class);
    }

    /**
     * 删除获客链接
     *
     * @param linkId the link id
     * @return the we com response
     */
    public WeComResponse deleteLink(String linkId) {
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_ACQUISITION_DELETE,
                Collections.singletonMap("link_id", linkId),
                WeComResponse.class);
    }

    /**
     * 获取由获客链接添加的客户信息
     *
     * @param linkId the link id
     * @param limit  the limit
     * @param cursor the cursor
     * @return the we com response
     */
    public LinkCustomersResponse queryLinkCustomers(String linkId, int limit, String cursor) {
        LinkPageRequest pageRequest = new LinkPageRequest();
        pageRequest.setCursor(cursor);
        pageRequest.setLimit(limit);
        pageRequest.setLinkId(linkId);
        return workWeChatApiClient.post(WeComEndpoint.CUSTOMER_ACQUISITION_CUSTOMERS,
                pageRequest,
                LinkCustomersResponse.class);
    }

    /**
     * 查询获客链接剩余使用量
     *
     * @return the we com response
     */
    public AcquisitionQuotaResponse queryCustomerAcquisitionQuotas() {
        return workWeChatApiClient.get(WeComEndpoint.CUSTOMER_ACQUISITION__QUOTAS, AcquisitionQuotaResponse.class);
    }
}
