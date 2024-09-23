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
 * The FormItemReplyType
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum FormItemReplyType {

    /**
     * 文本
     */
    TEXT(1),
    /**
     * 单选
     */
    RADIO(2),
    /**
     * 多选
     */
    CHECKBOX(3),
    /**
     * 位置
     */
    LOCATION(5),
    /**
     * 图片
     */
    IMAGE(9),
    /**
     * 文件
     */
    FILE(10),
    /**
     * 日期
     */
    DATE(11),
    /**
     * 时间
     */
    TIME(14),
    /**
     * 下拉列表
     */
    DROPDOWN(15),
    /**
     * 体温
     */
    TEMPERATURE(16),
    /**
     * 签名
     */
    SIGNATURE(17),
    /**
     * 部门
     */
    DEPARTMENT(18),
    /**
     * 成员
     */
    MEMBER(19),
    /**
     * 时长
     */
    DURATION(22);

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
