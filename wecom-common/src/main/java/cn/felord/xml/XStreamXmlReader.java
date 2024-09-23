/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.xml;

import cn.felord.callback.XmlEntity;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author felord
 * @since 2021/10/10 14:16
 */
public class XStreamXmlReader implements XmlReader {
    private static final Map<Class<?>, XStream> X_STREAM_HOLDER = new ConcurrentHashMap<>();
    private static final XmlFriendlyNameCoder NAME_CODER = new XmlFriendlyNameCoder("_-", "_");
    private static final DomDriver DOM_DRIVER = new DomDriver("UTF-8", NAME_CODER);
    public static final XStreamXmlReader INSTANCE = new XStreamXmlReader();

    XStreamXmlReader() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends XmlEntity> T read(String xml, Class<T> clazz) {
        return (T) X_STREAM_HOLDER.computeIfAbsent(clazz, XStreamXmlReader::newXStream).fromXML(xml);
    }

    @Override
    public <T extends XmlEntity> String write(T t) {
        return X_STREAM_HOLDER.computeIfAbsent(t.getClass(), XStreamXmlReader::newXStream).toXML(t);
    }

    private static XStream newXStream(Class<?> clazz) {
        XStream xStream = new XStream(DOM_DRIVER);
        // 安全白名单
        xStream.allowTypeHierarchy(XmlEntity.class);
        xStream.registerConverter(new UnixInstantConverter());
        xStream.ignoreUnknownElements();
        xStream.processAnnotations(clazz);
        return xStream;
    }
}
