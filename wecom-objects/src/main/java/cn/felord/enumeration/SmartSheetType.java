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
import java.util.Objects;

/**
 * The enum Smart sheet type.
 *
 * @author dax
 * @since 2024 /12/24
 */
public enum SmartSheetType {
    /**
     * 经营者/法人
     */
    DASHBOARD("dashboard"),
    /**
     * 经办人
     */
    EXTERNAL("external"),
    /**
     * Smartsheet smart sheet type.
     */
    SMARTSHEET("smartsheet");

    private final String type;

    SmartSheetType(String type) {
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
     * Deserialize smart sheet type.
     *
     * @param type the type
     * @return the smart sheet type
     */
    @JsonCreator
    public static SmartSheetType deserialize(String type) {
        return Arrays.stream(SmartSheetType.values())
                .filter(smartSheetType -> Objects.equals(smartSheetType.type, type))
                .findFirst()
                .orElse(null);
    }
}
