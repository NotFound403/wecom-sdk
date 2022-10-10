package cn.felord.domain.externalcontact;

import cn.felord.enumeration.WelcomeNotifyStrategy;
import lombok.Data;

/**
 * @author dax
 * @since 2021/7/23 21:59
 */
@Data
public class WelcomeTemplateEditRequest {
    private final String templateId;
    private ContentText text;
    private Image image;
    private Link link;
    private Miniprogram miniprogram;
    private MediaId file;
    private MediaId video;
    private String agentid;
    private WelcomeNotifyStrategy notify;

}
