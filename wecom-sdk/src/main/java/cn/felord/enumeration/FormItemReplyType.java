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
 * The FormItemReplyType
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum FormItemReplyType {


    /**
     * Text form item reply type.
     */
    TEXT(1),
    /**
     * Radio form item reply type.
     */
    RADIO(2),
    /**
     * Multi selection form item reply type.
     */
    MULTI_SELECTION(3),
    /**
     * Location form item reply type.
     */
    LOCATION(5),
    /**
     * Username form item reply type.
     */
    USERNAME(6),
    /**
     * Department form item reply type.
     */
    DEPARTMENT(7),
    /**
     * Image form item reply type.
     */
    IMAGE(9),
    /**
     * File form item reply type.
     */
    FILE(10),
    /**
     * Date form item reply type.
     */
    DATE(11),
    /**
     * Time form item reply type.
     */
    TIME(14),
    /**
     * Dropdown form item reply type.
     */
    DROPDOWN(15),
    /**
     * Temperature form item reply type.
     */
    TEMPERATURE(16),
    /**
     * Signature form item reply type.
     */
    SIGNATURE(17);

    private final int type;

    FormItemReplyType(int type) {
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
     * Deserialize button type.
     *
     * @param type the type
     * @return the button type
     */
    @JsonCreator
    public static FormItemReplyType deserialize(int type) {
        return Arrays.stream(FormItemReplyType.values())
                .filter(formItemReplyType -> formItemReplyType.type == type)
                .findFirst()
                .orElse(null);
    }
}
