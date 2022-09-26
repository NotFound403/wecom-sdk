package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;
import java.util.Set;

/**
 * @author dax
 * @since 2021/8/17 9:39
 */
@Data
public class ProductAlbumDetail {
    private String productId;
    private String description;
    private Instant createTime;
    private Long price;
    private Set<ProductAlbumAttachment> attachments;
    private String productSn;

}
