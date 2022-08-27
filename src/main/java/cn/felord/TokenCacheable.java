package cn.felord;

/**
 * @author xiafang
 */
public interface TokenCacheable {

    String put(String key, String token);

    String get(String key);
}
