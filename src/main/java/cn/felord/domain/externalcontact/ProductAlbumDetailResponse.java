package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2021/8/17 9:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductAlbumDetailResponse extends WeComResponse {
    private ProductAlbumDetail product;
}
