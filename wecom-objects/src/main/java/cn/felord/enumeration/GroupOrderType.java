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
 * 客户群排序方式
 *
 * @author dax
 * @since 2024/5/25 16:19
 */
public enum GroupOrderType {


    /**
     * 新增群的数量
     */
    INCREMENT(1),
    /**
     * 群总数
     */
    TOTAL(2),
    /**
     * 新增群人数
     */
    MEMBER_INCREMENT(3),
    /**
     * 群总人数
     */
    MEMBER_TOTAL(4);
    private final int type;

    GroupOrderType(int type) {
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
     * Deserialize AttendanceType.
     *
     * @param type the type
     * @return AttendanceType
     */
    @JsonCreator
    public static GroupOrderType deserialize(int type) {
        return Arrays.stream(GroupOrderType.values())
                .filter(groupOrderType -> groupOrderType.type == type)
                .findFirst()
                .orElse(null);
    }
}
