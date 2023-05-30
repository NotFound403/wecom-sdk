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
