package cn.felord;

import lombok.Getter;

/**
 * @author n1
 * @since 2021/8/17 18:31
 */
@Getter
public class WeComException extends RuntimeException {
    private final Integer errcode;
    private final String errmsg;

    public WeComException(String message) {
        this(message, -9999999, null);
    }

    public WeComException(String message, Integer errcode, String errmsg) {
        super(message);
        this.errcode = errcode;
        this.errmsg = errmsg;
    }
}
