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
 * The ChatGroupQuitScene
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
@XStreamConverter(NumberEnumConverter.class)
public enum ChatGroupQuitScene implements CallbackNumberEnum {

    /**
     * 自己退群
     */
    SELF(0),
    /**
     * 群主或群管理员移出
     */
    BAN(1);

    private final int type;

    ChatGroupQuitScene(int type) {
        this.type = type;
    }

    /**
     * Deserialize ChatGroupQuitScene.
     *
     * @param type the type
     * @return the button type
     */
    @JsonCreator
    public static ChatGroupQuitScene deserialize(int type) {
        return Arrays.stream(ChatGroupQuitScene.values())
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
