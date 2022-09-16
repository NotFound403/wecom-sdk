package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/8 14:36
 */
@Data
public class Conclusions {
    private ContactText text;
    private ContactImage image;
    private ContactLink link;
    private ContactMiniprogram miniprogram;

    @Data
    public static class ContactText {
        private String content;
    }

    @Data
    public static class ContactImage {
        private String picUrl;
    }

    @Data
    public static class ContactLink {
        private String title;
        private String picurl;
        private String desc;
        private String url;
    }

    @Data
    public static class ContactMiniprogram {
        private String title;
        private String picMediaId;
        private String appid;
        private String page;
    }
}
