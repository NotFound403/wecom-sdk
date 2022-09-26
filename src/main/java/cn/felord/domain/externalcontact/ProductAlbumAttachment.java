package cn.felord.domain.externalcontact;

import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:15
 */
@Getter
public class ProductAlbumAttachment {
    private final String type = "image";
    private final MediaId image;

    public ProductAlbumAttachment(MediaId image) {
        this.image = image;
    }
}
