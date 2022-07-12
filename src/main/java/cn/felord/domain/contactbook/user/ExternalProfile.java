package cn.felord.domain.contactbook.user;

import lombok.Data;

import java.util.List;

/**
 * @author n1
 */
@Data
public class ExternalProfile {
    private String externalCorpName;
    private WechatChannels wechatChannels;
    private List<ExternalAttrItem> externalAttr;

    @Data
    public static class WechatChannels{
        private String nickName;
    }
}