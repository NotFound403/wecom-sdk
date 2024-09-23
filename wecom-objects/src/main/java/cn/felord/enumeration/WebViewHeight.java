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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * WebView 高度
 *
 * @author dax
 * @since 2022 /10/25
 */
public enum WebViewHeight {
    /**
     * 点击推事件
     */
    SINGLE_ROW("single_row"),
    /**
     * 跳转URL
     */
    DOUBLE_ROW("double_row");

    private final String type;

    WebViewHeight(String type) {
        this.type = type;
    }

    /**
     * Deserialize WebViewHeight
     *
     * @param type the type
     * @return the add ways
     */
    @JsonCreator
    public static WebViewHeight deserialize(String type) {
        return Arrays.stream(WebViewHeight.values())
                .filter(webViewHeight -> webViewHeight.type.equals(type))
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }
}
