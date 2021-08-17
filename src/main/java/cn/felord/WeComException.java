package cn.felord;

/**
 * @author n1
 * @since 2021/8/17 18:31
 */
public class WeComException extends RuntimeException {
    public WeComException(String message) {
        super(message);
    }

    public WeComException(String message, Throwable cause) {
        super(message, cause);
    }
}
