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

/**
 * The interface Xml reader.
 *
 * @author felord
 * @since 2021 /10/10 14:14
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
    <T extends XmlEntity> T read(String xml, Class<T> clazz);

    /**
     * Write string.
     *
     * @param <T> the type parameter
     * @param t   the t
     * @return the string
     */
    <T extends XmlEntity> String write(T t);
}
