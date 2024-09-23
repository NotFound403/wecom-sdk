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
 * The AnswerAttachType.
 *
 * @author dax
 * @since 2021/9/9 9:22
 */
public enum AnswerAttachType {
    /**
     * 图片
     */
    IMAGE("image"),
    /**
     * 视频
     */
    VIDEO("video"),
    /**
     * 链接
     */
    LINK("link"),
    /**
     * 小程序
     */
    MINIPROGRAM("miniprogram");

    private final String type;

    AnswerAttachType(String type) {
        this.type = type;
    }

    /**
     * Deserialize AnswerAttachType
     *
     * @param type the type
     * @return the add ways
     */
    @JsonCreator
    public static AnswerAttachType deserialize(String type) {
        return Arrays.stream(AnswerAttachType.values())
                .filter(answerAttachType -> answerAttachType.type.equals(type))
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
