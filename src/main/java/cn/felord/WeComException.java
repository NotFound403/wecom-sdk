package cn.felord;

import lombok.Getter;

/**
 * @author n1
 * @since 2021/8/17 18:31
 */
@Getter
public class WeComException extends RuntimeException {
    private static final Integer DEFAULT_CODE = -9999999;
    private final Integer errcode;
    private final String hint;

    public WeComException(String errmsg) {
        super(errmsg);
        this.errcode = DEFAULT_CODE;
        this.hint = errmsg;
    }

    public WeComException(Integer errcode, String errmsg) {
        super(errmsg);
        this.errcode = errcode;
        this.hint = "https://open.work.weixin.qq.com/devtool/query?e=" + errcode;
    }
}
