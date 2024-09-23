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
 * 视频号消息类型
 *
 * @author dax
 * @since 2024/5/26
 */
public enum ChannelsSubType {
    /**
     * 视频号动态
     */
    HISTORY(1),
    /**
     * 视频号直播
     */
    LIVE(2),
    /**
     * 视频号名片
     */
    PROFILE(3);

    private final int type;

    ChannelsSubType(int type) {
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
     * Deserialize ChannelsSubType
     *
     * @param type the type
     * @return the approval notify type
     */
    @JsonCreator
    public static ChannelsSubType deserialize(int type) {
        return Arrays.stream(ChannelsSubType.values())
                .filter(subType -> subType.type == type)
                .findFirst()
                .orElse(null);
    }
}
