/*
 * Copyright (c) 2025. felord.cn
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
 * The enum Form fork finish type.
 *
 * @author dax
 * @since 2024/3/13 17:24
 */
public enum FormForkFinishType {
    /**
     * 允许
     */
    ALLOW(0),
    /**
     * 仅当天
     */
    SAME_DAY(1),
    /**
     * 最后五天内
     */
    FIVE_DAY(2),
    /**
     * 一个月内
     */
    ONE_MONTH(3),
    /**
     * 下一次生成前
     */
    NEXT(4);

    private final int type;

    FormForkFinishType(int type) {
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
     * Deserialize form fork finish type.
     *
     * @param type the type
     * @return the form fork finish type
     */
    @JsonCreator
    public static FormForkFinishType deserialize(int type) {
        return Arrays.stream(FormForkFinishType.values())
                .filter(formForkFinishType -> formForkFinishType.type == type)
                .findFirst()
                .orElse(null);
    }

}
