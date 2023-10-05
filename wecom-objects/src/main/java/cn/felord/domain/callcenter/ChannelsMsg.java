package cn.felord.domain.callcenter;

import cn.felord.enumeration.ChannelsSubType;
import lombok.Data;

/**
 * 视频号消息
 *
 * @author dax
 * @since 2023 /10/5
 */
@Data
public class ChannelsMsg {
    /**
     * 视频号消息类型
     */
    private ChannelsSubType subType;
    /**
     * 视频号名称
     */
    private String nickname;
    /**
     * 视频号动态标题， 当{@link ChannelsSubType#HISTORY}时，返回动态标题
     */
    private String title;
}