package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.ProductAlbumAddRequest;
import cn.felord.domain.externalcontact.ProductAlbumDetail;
import cn.felord.domain.externalcontact.ProductAlbumDetailResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品图册管理
 *
 * @author dax
 * @since 2021 /6/23 15:30
 */
public class ProductAlbumApi extends AbstractAgentApi {

    /**
     * Instantiates a new Product album api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agent          the agent
     */
    ProductAlbumApi(WeComCacheable wecomCacheable, AgentDetails agent) {
        super(wecomCacheable, agent);
    }

    /**
     * 创建商品图册
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> addProductAlbum(ProductAlbumAddRequest request) {

        String endpoint = WeComEndpoint.PRODUCT_ALBUM_CREATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 获取商品图册
     *
     * @param productId the product id
     * @return the product album
     */
    public ProductAlbumDetailResponse getProductAlbum(String productId) {

        String endpoint = WeComEndpoint.PRODUCT_ALBUM_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri,Collections.singletonMap("product_id",productId), ProductAlbumDetailResponse.class);
    }

    /**
     * 获取商品图册列表
     *
     * @param limit  the limit
     * @param cursor the cursor
     * @return the product album detail response
     */
    public ProductAlbumDetailResponse productAlbumList(int limit,String cursor) {

        String endpoint = WeComEndpoint.PRODUCT_ALBUM_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        Map<String, Object> body = new HashMap<>(2);
        body.put("limit",limit);
        body.put("cursor",cursor);
        return this.post(uri,body, ProductAlbumDetailResponse.class);
    }

    /**
     * 编辑商品图册
     *
     * @param productAlbumDetail the product album detail
     * @return the we com response
     */
    public WeComResponse updateProductAlbum(ProductAlbumDetail productAlbumDetail) {

        String endpoint = WeComEndpoint.PRODUCT_ALBUM_EDIT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri,productAlbumDetail, WeComResponse.class);
    }

    /**
     * 删除商品图册
     *
     * @param productId the product id
     * @return the we com response
     */
    public WeComResponse deleteProductAlbum(String productId) {

        String endpoint = WeComEndpoint.PRODUCT_ALBUM_DEL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri,Collections.singletonMap("product_id",productId), WeComResponse.class);
    }
}
