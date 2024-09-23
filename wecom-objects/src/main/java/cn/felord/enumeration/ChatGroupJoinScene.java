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

import cn.felord.xml.convert.CallbackNumberEnum;
import cn.felord.xml.convert.NumberEnumConverter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.Arrays;

/**
 * The ChatGroupJoinScene
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
@XStreamConverter(NumberEnumConverter.class)
public enum ChatGroupJoinScene implements CallbackNumberEnum {

    /**
     * 由成员邀请入群（包括直接邀请入群和通过邀请链接入群）
     */
    BY_MEMBER(0),
    /**
     * 通过扫描群二维码入群
     */
    QR_CODE(3);

    private final int type;

    ChatGroupJoinScene(int type) {
        this.type = type;
    }

    /**
     * Deserialize ChatGroupJoinScene.
     *
     * @param type the type
     * @return the button type
     */
    @JsonCreator
    public static ChatGroupJoinScene deserialize(int type) {
        return Arrays.stream(ChatGroupJoinScene.values())
                .filter(answerStatus -> answerStatus.type == type)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }
}
