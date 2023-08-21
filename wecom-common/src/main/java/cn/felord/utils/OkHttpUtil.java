/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.utils;

import okhttp3.RequestBody;
import okio.Buffer;

import java.io.IOException;

/**
 * The type Ok http util.
 *
 * @author dax
 * @since 2023 /8/2 18:12
 */
public final class OkHttpUtil {
    private OkHttpUtil() {
    }

    /**
     * 读取RequestBody中的数据为String
     *
     * @param body the body
     * @return the string
     */
    public static String requestBodyToString(RequestBody body) {
        Buffer buffer = new Buffer();
        try {
            body.writeTo(buffer);
        } catch (IOException e) {
            throw new IllegalArgumentException("Request Auth Error", e);
        }
        return buffer.readUtf8();
    }
}
