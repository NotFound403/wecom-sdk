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
import cn.felord.domain.common.PageRequest;
import cn.felord.domain.common.ProductId;
import cn.felord.domain.externalcontact.ProductAlbumAddRequest;
import cn.felord.domain.externalcontact.ProductAlbumDetail;
import cn.felord.domain.externalcontact.ProductAlbumDetailResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 商品图册管理
 *
 * @author dax
 * @since 2021 /6/23 15:30
 */
public interface ProductAlbumApi {

    /**
     * 创建商品图册
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/add_product_album")
    GenericResponse<String> addProductAlbum(@Body ProductAlbumAddRequest request) throws WeComException;

    /**
     * 获取商品图册
     *
     * @param productId the product id
     * @return the product album
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_product_album")
    ProductAlbumDetailResponse getProductAlbum(@Body ProductId productId) throws WeComException;

    /**
     * 获取商品图册列表
     *
     * @param request the request
     * @return the product album detail response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_product_album_list")
    ProductAlbumDetailResponse productAlbumList(@Body PageRequest request) throws WeComException;

    /**
     * 编辑商品图册
     *
     * @param productAlbumDetail the product album detail
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/update_product_album")
    WeComResponse updateProductAlbum(@Body ProductAlbumDetail productAlbumDetail) throws WeComException;

    /**
     * 删除商品图册
     *
     * @param productId the product id
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/delete_product_album")
    WeComResponse deleteProductAlbum(@Body ProductId productId) throws WeComException;
}
