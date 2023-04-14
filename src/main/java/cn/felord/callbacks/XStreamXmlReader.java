package cn.felord.callbacks;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * @author felord
 * @since 2021/10/10 14:16
 */
public class XStreamXmlReader implements XmlReader {
    @SuppressWarnings("unchecked")
    @Override
    public <T> T read(String xml, Class<T> clazz) {
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new InstantConverter());
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.ignoreUnknownElements();
        xStream.processAnnotations(clazz);
        return (T) xStream.fromXML(xml);
    }

    @Override
    public <T> String write(T t) {
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new InstantConverter());
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.ignoreUnknownElements();
        xStream.processAnnotations(t.getClass());
        return xStream.toXML(t);
    }
}
