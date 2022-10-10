package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2021/9/23 11:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WelcomeTemplateResponse extends WeComResponse {
    private ContentText text;
    private ImageUrl image;
    private Link link;
    private Miniprogram miniprogram;
    private MediaId file;
    private MediaId video;
}
