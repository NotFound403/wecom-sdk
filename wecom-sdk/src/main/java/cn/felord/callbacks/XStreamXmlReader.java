/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.callbacks;

import cn.felord.domain.callback.CallbackEventBody;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.util.HashMap;
import java.util.Map;

/**
 * @author felord
 * @since 2021/10/10 14:16
 */
public class XStreamXmlReader implements XmlReader {
    private static final Map<Class<?>, XStream> XSTREAM_MAP = new HashMap<>();

    @SuppressWarnings("unchecked")
    @Override
    public <T> T read(String xml, Class<T> clazz) {
        return (T) initXStream(clazz).fromXML(xml);
    }

    @Override
    public <T> String write(T t) {
        Class<?> clazz = t.getClass();
        return initXStream(clazz).toXML(t);
    }

    private static XStream initXStream(Class<?> clazz) {
        XStream xStream = XSTREAM_MAP.get(clazz);
        if (xStream == null) {
            xStream = new XStream(new DomDriver());
            // 安全白名单
            Class<?>[] allowTypes = {CallbackXmlBody.class, CallbackEventBody.class};
            xStream.allowTypes(allowTypes);
            xStream.registerConverter(new InstantConverter());
            xStream.addPermission(AnyTypePermission.ANY);
            xStream.ignoreUnknownElements();
            xStream.processAnnotations(clazz);
            XSTREAM_MAP.put(clazz, xStream);
        }
        return xStream;
    }

}
