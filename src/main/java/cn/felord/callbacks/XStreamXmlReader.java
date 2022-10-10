package cn.felord.callbacks;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author xiafang
 * @since 2022/10/10 14:16
 */
public class XStreamXmlReader implements XmlReader {
    private final XStream xStream = new XStream(new DomDriver());

    @SuppressWarnings("unchecked")
    @Override
    public <T> T read(String xml, Class<T> clazz) {
        xStream.allowTypes(new Class[]{clazz});
        xStream.processAnnotations(clazz);
        return (T) xStream.fromXML(xml);
    }


}
