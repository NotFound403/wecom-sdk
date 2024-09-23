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

import cn.felord.xml.convert.CallbackNumberEnum;
import cn.felord.xml.convert.NumberEnumConverter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.Arrays;

/**
 * The NodeStatus
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
@XStreamConverter(NumberEnumConverter.class)
public enum NodeStatus implements CallbackNumberEnum {


    /**
     * 审批中
     */
    APPROVAL(1),
    /**
     * 已通过
     */
    ACCEPTED(2),
    /**
     * 已驳回
     */
    REJECTED(3),
    /**
     * 已转审
     */
    TRANSFERRED(4),
    /**
     * 已退回（仅在查询详情返回）
     */
    RETURNED(11),
    /**
     * 已加签（仅在查询详情返回）
     */
    APPEND_ASSIGNEE(12),
    /**
     * 已同意并加签（仅在查询详情返回）
     */
    APPEND_AND_AGREE(13);

    private final int type;

    NodeStatus(int type) {
        this.type = type;
    }

    /**
     * Deserialize NodeStatus.
     *
     * @param type the type
     * @return the button type
     */
    @JsonCreator
    public static NodeStatus deserialize(int type) {
        return Arrays.stream(NodeStatus.values())
                .filter(answerStatus -> answerStatus.type == type)
                .findFirst()
                .orElse(null);
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
}
