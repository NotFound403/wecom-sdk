package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiafang
 * @since 2022/9/26 9:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductAlbumDetailResponse extends WeComResponse {
    private ProductAlbumDetail product;
}
