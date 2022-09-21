package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/8/21 17:34
 */
@Data
public class MomentLink {
    private String title;
    private final String url;
    private final String mediaId;
}
