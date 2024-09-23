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
 * The enum Contact scene.
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum ContactScene {
    /**
     * 在小程序中联系
     */
    MINI_PROGRAM(1),
    /**
     * 通过二维码联系
     */
    QR_CODE(2);

    private final int type;

    ContactScene(int type) {
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
     * Deserialize contact scene.
     *
     * @param type the type
     * @return the contact scene
     */
    @JsonCreator
    public static ContactScene deserialize(int type) {
        return Arrays.stream(ContactScene.values())
                .filter(contactScene -> contactScene.type == type)
                .findFirst()
                .orElse(null);
    }
}
