package cn.felord.utils;

import okhttp3.RequestBody;
import okio.Buffer;

import java.io.IOException;

/**
 * The type Ok http util.
 *
 * @author xiafang
 * @since 2023 /8/2 18:12
 */
public final class OkHttpUtil {
    private OkHttpUtil() {
    }

    /**
     * 读取RequestBody中的数据为String
     *
     * @param body the body
     * @return the string
     */
    public static String requestBodyToString(RequestBody body) {
        Buffer buffer = new Buffer();
        try {
            body.writeTo(buffer);
        } catch (IOException e) {
            throw new IllegalArgumentException("Request Auth Error", e);
        }
        return buffer.readUtf8();
    }
}
