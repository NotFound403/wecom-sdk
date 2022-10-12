package cn.felord.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiafang
 * @since 2022/10/12 16:53
 */
@Setter
@Getter
public abstract class CursorWeComResponse extends WeComResponse {
    private String nextCursor;
}
