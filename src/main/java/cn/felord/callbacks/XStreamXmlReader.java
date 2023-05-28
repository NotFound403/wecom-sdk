package cn.felord.callbacks;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * @author felord
 * @since 2021/10/10 14:16
 */
public class XStreamXmlReader implements XmlReader {
    private static final XStream X_STREAM = init();
    @SuppressWarnings("unchecked")
    @Override
    public <T> T read(String xml, Class<T> clazz) {
        X_STREAM.processAnnotations(clazz);
        return (T) X_STREAM.fromXML(xml);
    }

    @Override
    public <T> String write(T t) {
        X_STREAM.processAnnotations(t.getClass());
        return X_STREAM.toXML(t);
    }

    public static XStream init(){
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new InstantConverter());
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.ignoreUnknownElements();
        return xStream;
    }

}
