package cn.felord.domain.externalcontact;

import cn.felord.enumeration.WechatChannelSource;
import lombok.Data;

/**
 * @author dax
 * @since 2021/7/9 9:13
 */
@Data
public class WechatChannels {
 private String nickname;
 private WechatChannelSource source;
}
