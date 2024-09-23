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

package cn.felord.payment.wechat.enumeration;

/**
 * 支付方式
 *
 * @author dax
 * @since 2024/8/11
 */
public enum PayType {
    /**
     * Jsapi pay type.
     */
    JSAPI("jsapi"),
    /**
     * App pay type.
     */
    APP("app"),
    /**
     * H 5 pay type.
     */
    H5("h5"),
    /**
     * Native pay type.
     */
    NATIVE("native");

    private final String type;

    /**
     * Instantiates a new Pay type.
     *
     * @param type the type
     */
    PayType(String type) {
        this.type = type;
    }

    /**
     * Type string.
     *
     * @return the string
     */
    public String type() {
        return type;
    }
}

