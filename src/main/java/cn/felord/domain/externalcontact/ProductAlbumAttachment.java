package cn.felord.domain.externalcontact;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:15
 */
@EqualsAndHashCode
@Getter
public class ProductAlbumAttachment {
    private final String type = "image";
    private final MediaId image;
    public ProductAlbumAttachment(String mediaId) {
        this.image = new MediaId(mediaId);
    }
}
