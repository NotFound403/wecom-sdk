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

package cn.felord.utils;

import java.util.Collection;
import java.util.Map;

/**
 * The type Assert.
 *
 * @author dax
 * @since 2024/8/7
 */
public final class Assert {

    /**
     * Instantiates a new Assert.
     */
    Assert() {
    }

    /**
     * Has text.
     *
     * @param text    the text
     * @param message the message
     */
    public static void hasText(String text, String message) {
        if (StringUtils.hasNoText(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Not empty.
     *
     * @param collection the collection
     * @param message    the message
     */
    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Not empty.
     *
     * @param map     the map
     * @param message the message
     */
    public static void notEmpty(Map<?, ?> map, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void notEmpty(T[] array, String message) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
