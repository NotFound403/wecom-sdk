package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.PageRequest;
import cn.felord.domain.common.ProductId;
import cn.felord.domain.externalcontact.ProductAlbumAddRequest;
import cn.felord.domain.externalcontact.ProductAlbumDetail;
import cn.felord.domain.externalcontact.ProductAlbumDetailResponse;
import io.reactivex.rxjava3.core.Single;
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
     */
    @POST("externalcontact/add_product_album")
    Single<GenericResponse<String>> addProductAlbum(@Body ProductAlbumAddRequest request);

    /**
     * 获取商品图册
     *
     * @param productId the product id
     * @return the product album
     */
    @POST("externalcontact/get_product_album")
    Single<ProductAlbumDetailResponse> getProductAlbum(@Body ProductId productId);

    /**
     * 获取商品图册列表
     *
     * @param request the request
     * @return the product album detail response
     */
    @POST("externalcontact/get_product_album_list")
    Single<ProductAlbumDetailResponse> productAlbumList(@Body PageRequest request);

    /**
     * 编辑商品图册
     *
     * @param productAlbumDetail the product album detail
     * @return the we com response
     */
    @POST("externalcontact/update_product_album")
    Single<WeComResponse> updateProductAlbum(@Body ProductAlbumDetail productAlbumDetail);

    /**
     * 删除商品图册
     *
     * @param productId the product id
     * @return the we com response
     */
    @POST("externalcontact/delete_product_album")
    Single<WeComResponse> deleteProductAlbum(@Body ProductId productId);
}
