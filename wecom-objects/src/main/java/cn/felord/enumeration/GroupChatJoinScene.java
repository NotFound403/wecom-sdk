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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Group chat join scene.
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum GroupChatJoinScene {
    /**
     * Direct by member group chat join scene.
     */
    DIRECT_BY_MEMBER(1),
    /**
     * Link by member group chat join scene.
     */
    LINK_BY_MEMBER(2),
    /**
     * Qr code group chat join scene.
     */
    QR_CODE(3);

    private final int type;

    GroupChatJoinScene(int type) {
        this.type = type;
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

    /**
     * Deserialize group chat join scene.
     *
     * @param type the type
     * @return the group chat join scene
     */
    @JsonCreator
    public static GroupChatJoinScene deserialize(int type) {
        return Arrays.stream(GroupChatJoinScene.values())
                .filter(groupChatJoinScene -> groupChatJoinScene.type == type)
                .findFirst()
                .orElse(null);
    }
}
