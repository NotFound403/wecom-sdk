package cn.felord.domain.callcenter;

import lombok.Data;

/**
 * @author xiafang
 * @since 2023/6/7 14:09
 */
@Data
public class KfEnterSessionContext {
    private String scene;
    private String sceneParam;
    private WechatChannels wechatChannels;
}
