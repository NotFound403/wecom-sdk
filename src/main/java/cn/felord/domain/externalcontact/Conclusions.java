package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/8 14:36
 */
@Data
public class Conclusions {
    private ContentText text;
    private ImageUrl image;
    private Link link;
    private Miniprogram miniprogram;

}
