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
 * 审批模板控件类型
 *
 * @author dax
 * @since 2021 /9/9 9:22
 */
public enum ContactCtrlMode {

    /**
     * 部门
     */
    DEPARTMENT("department"),
    /**
     * 成员
     */
    USER("user");

    private final String mode;

    ContactCtrlMode(String mode) {
        this.mode = mode;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getMode() {
        return mode;
    }


    /**
     * Deserialize approval ctrl mode.
     *
     * @param mode the mode
     * @return the approval ctrl mode
     */
    @JsonCreator
    public static ContactCtrlMode deserialize(String mode) {
        return Arrays.stream(ContactCtrlMode.values())
                .filter(contactType -> contactType.mode.equals(mode))
                .findFirst()
                .orElse(null);
    }
}
