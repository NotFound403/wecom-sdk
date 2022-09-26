package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/8/17 9:39
 */
@Data
public class ProductAlbumAddRequest {
    private final String description;
    private final Long price;
    private final Set<ProductAlbumAttachment> attachments;
    private String productSn;

}
