package cn.felord.domain.living;

import lombok.Getter;
import lombok.ToString;

/**
 * The WatchStatRequest
 *
 * @author dax
 * @since 2023 /11/23
 */
@ToString
@Getter
public class WatchStatRequest {
    /**
     * 直播id
     */
    private final String livingid;
    /**
     * 上一次调用时返回的next_key，初次调用可以填"0"
     */
    private final String nextKey;

    public WatchStatRequest(String livingid) {
        this(livingid, "0");
    }

    public WatchStatRequest(String livingid, String nextKey) {
        this.livingid = livingid;
        this.nextKey = nextKey;
    }
}
