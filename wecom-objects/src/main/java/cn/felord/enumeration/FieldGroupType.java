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
 * 字段类型说明
 *
 * @author dax
 * @since 2021 /9/8 11:14
 */
public enum FieldGroupType {
    /**
     * 教育经历
     */
    EDU(1),
    /**
     * 工作经历
     */
    WORK(2),
    /**
     * 家庭成员
     */
    FAMILY(3),
    /**
     * 紧急联系人
     */
    CONTACT(4),
    /**
     * 合同信息
     */
    CONTRACT(5);

    private final int type;

    FieldGroupType(int type) {
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
     * Deserialize FieldType.
     *
     * @param type the type
     * @return the value type
     */
    @JsonCreator
    public static FieldGroupType deserialize(int type) {
        return Arrays.stream(FieldGroupType.values())
                .filter(valueResult -> valueResult.type == type)
                .findFirst()
                .orElse(null);
    }
}
