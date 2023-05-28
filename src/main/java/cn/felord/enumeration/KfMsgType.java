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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Objects;

/**
 * The enum Msg type.
 *
 * @author n1
 * @since 2021 /6/16 14:39
 */
public enum KfMsgType {
    /**
     * 文本
     */
    TEXT("text"),
    /**
     * 图片
     */
    IMAGE("image"),
    /**
     * 语音
     */
    VOICE("voice"),
    /**
     * 视频
     */
    VIDEO("video"),
    /**
     * 文件
     */
    FILE("file"),
    /**
     * 位置
     */
    LOCATION("location"),
    /**
     * 链接
     */
    LINK("link"),
    /**
     * 名片
     */
    BUSINESS_CARD("business_card"),
    /**
     * 小程序
     */
    MINIPROGRAM("miniprogram"),
    /**
     * 菜单
     */
    MSG_MENU("msgmenu"),
    /**
     * 事件
     */
    EVENT("event");
    private final String type;

    KfMsgType(String type) {
        this.type = type;
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

    /**
     * Deserialize range type.
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static KfMsgType deserialize(String type) {
        return Arrays.stream(KfMsgType.values())
                .filter(kfMsgType -> Objects.equals(kfMsgType.type, type))
                .findFirst()
                .orElse(null);
    }
}
