package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Add ways.
 *
 * @author dax
 * @since 2021 /9/9 9:22
 */
public enum WechatChannelSource {

    /**
     * 未知
     */
    UNKNOWN(0),

    /**
     * 视频号主页
     */
    HOME_PAGE(1),

    /**
     * 视频号直播间
     */
    LIVE_ROOM(2),

    /**
     * 视频号留资服务
     */
    BUSINESS_SERVICE(3);

    private final int type;

    WechatChannelSource(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

    /**
     * Deserialize add ways.
     *
     * @param type the type
     * @return the add ways
     */
    @JsonCreator
    public static WechatChannelSource deserialize(int type) {
        return Arrays.stream(WechatChannelSource.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }
}
