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
 * 填写权限
 *
 * @author dax
 * @since 2024/3/13 17:05
 */
public enum FillOutAuth {

    /**
     * 所有人
     */
    ALL(0),

    /**
     * 企业内指定人/部门
     */
    STAFF_OR_DEPT(1),
    /**
     * 家校所有范围
     */
    SCHOOL(4);

    private final int type;

    FillOutAuth(int type) {
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
     * Deserialize fill out auth.
     *
     * @param type the type
     * @return the fill out auth
     */
    @JsonCreator
    public static FillOutAuth deserialize(int type) {
        return Arrays.stream(FillOutAuth.values())
                .filter(fillOutAuth -> fillOutAuth.type == type)
                .findFirst()
                .orElse(null);
    }

}
