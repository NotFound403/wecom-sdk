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
 * The enum Voice format.
 *
 * @author dax
 * @since 2021 /9/8 11:14
 */
public enum VoiceFormat {
    /**
     * Amr voice format.
     */
    AMR(0),
    /**
     * Silk voice format.
     */
    SILK(1);

    private final int type;

    VoiceFormat(int type) {

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
     * Deserialize voice format.
     *
     * @param type the type
     * @return the voice format
     */
    @JsonCreator
    public static VoiceFormat deserialize(int type) {
        return Arrays.stream(VoiceFormat.values())
                .filter(multiStyle -> multiStyle.type == type)
                .findFirst()
                .orElse(null);
    }
}
