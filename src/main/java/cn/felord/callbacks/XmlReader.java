package cn.felord.callbacks;

/**
 * The interface Xml reader.
 *
 * @author xiafang
 * @since 2022 /10/10 14:14
 */
public interface XmlReader {

    /**
     * Read t.
     *
     * @param <T>   the type parameter
     * @param xml   the xml
     * @param clazz the clazz
     * @return the t
     */
    <T> T read(String xml, Class<T> clazz);
}
