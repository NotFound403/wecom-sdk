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
import cn.felord.domain.externalcontact.ProductAlbumAddRequest;
import cn.felord.domain.externalcontact.ProductAlbumDetail;
import cn.felord.domain.externalcontact.ProductAlbumDetailResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品图册管理
 *
 * @author dax
 * @since 2021 /6/23 15:30
 */
public class ProductAlbumApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Product album api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    ProductAlbumApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建商品图册
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> addProductAlbum(ProductAlbumAddRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.PRODUCT_ALBUM_CREATE, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 获取商品图册
     *
     * @param productId the product id
     * @return the product album
     */
    public ProductAlbumDetailResponse getProductAlbum(String productId) {
        return workWeChatApiClient.post(WeComEndpoint.PRODUCT_ALBUM_GET, Collections.singletonMap("product_id", productId), ProductAlbumDetailResponse.class);
    }

    /**
     * 获取商品图册列表
     *
     * @param limit  the limit
     * @param cursor the cursor
     * @return the product album detail response
     */
    public ProductAlbumDetailResponse productAlbumList(int limit, String cursor) {
        Map<String, Object> body = new HashMap<>(2);
        body.put("limit", limit);
        body.put("cursor", cursor);
        return workWeChatApiClient.post(WeComEndpoint.PRODUCT_ALBUM_LIST, body, ProductAlbumDetailResponse.class);
    }

    /**
     * 编辑商品图册
     *
     * @param productAlbumDetail the product album detail
     * @return the we com response
     */
    public WeComResponse updateProductAlbum(ProductAlbumDetail productAlbumDetail) {
        return workWeChatApiClient.post(WeComEndpoint.PRODUCT_ALBUM_EDIT, productAlbumDetail, WeComResponse.class);
    }

    /**
     * 删除商品图册
     *
     * @param productId the product id
     * @return the we com response
     */
    public WeComResponse deleteProductAlbum(String productId) {
        return workWeChatApiClient.post(WeComEndpoint.PRODUCT_ALBUM_DEL, Collections.singletonMap("product_id", productId), WeComResponse.class);
    }
}
