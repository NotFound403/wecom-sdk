package cn.felord.mp.domain.card;

import lombok.Data;

/**
 * 图文
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class TextImage {
    /**
     * 图片链接，必须调用 上传图片接口 上传图片获得链接，并在此填入， 否则报错
     */
    private String imageUrl;
    /**
     * 图文描述
     */
    private String text;
}