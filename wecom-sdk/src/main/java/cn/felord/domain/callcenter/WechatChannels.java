package cn.felord.domain.callcenter;

import cn.felord.enumeration.WechatChannelScene;
import lombok.Data;

/**
 * @author dax
 * @since 2023/6/4
 */
@Data
public class WechatChannels {
    private String nickname;
    private WechatChannelScene scene;

}
