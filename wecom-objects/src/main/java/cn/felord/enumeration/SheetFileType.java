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
import java.util.Objects;

/**
 * 智能表格附件文件类型
 *
 * @author dax
 * @since 2021 /9/8 11:14
 */
public enum SheetFileType {
    /**
     * 文件夹
     */
    FOLDER("Folder"),
    /**
     * 微盘文件
     */
    WE_DRIVE("Wedrive"),
    /**
     * 收集表
     */
    FORM("30"),
    /**
     * 文档
     */
    DOC("50"),
    /**
     * 表格
     */
    SHEET("51"),
    /**
     * Ppt sheet file type.
     */
    PPT("52"),
    /**
     * 思维导图
     */
    MIND_MAPPING("54"),
    /**
     * 流程图
     */
    FLOW_CHART("55"),
    /**
     * 智能表
     */
    SMART_SHEET("70");

    private final String type;

    SheetFileType(String type) {
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
     * Deserialize FieldType.
     *
     * @param type the type
     * @return the value type
     */
    @JsonCreator
    public static SheetFileType deserialize(String type) {
        return Arrays.stream(SheetFileType.values())
                .filter(valueResult -> Objects.equals(valueResult.type, type))
                .findFirst()
                .orElse(null);
    }
}
