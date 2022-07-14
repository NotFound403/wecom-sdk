package cn.felord;

/**
 * @author xiafang
 */
public interface Cacheable {

    void put(String key, String value);

    String get(String key);
}
