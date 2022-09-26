package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.Set;

/**
 * @author xiafang
 * @since 2022/9/26 9:39
 */
@Data
public class ProductAlbumAddRequest {
    private final String description;
    private final Long price;
    private final Set<ProductAlbumAttachment> attachments;
    private String productSn;

}
