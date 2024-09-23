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
 * 审批申请状态变化
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
@XStreamConverter(NumberEnumConverter.class)
public enum StatusChangeEvent implements CallbackNumberEnum {

    /**
     * 提单
     */
    SUBMIT(1),
    /**
     * 同意
     */
    ACCEPTED(2),
    /**
     * 驳回
     */
    REJECTED(3),
    /**
     * 转审
     */
    REFERRAL(4),
    /**
     * 催办
     */
    REMINDERS(5),
    /**
     * 撤销
     */
    REVOKED(6),
    /**
     * 通过后撤销
     */
    REVOKE_AFTER_ADOPT(8),
    /**
     * 添加备注
     */
    MARK(10),
    /**
     * 回退给指定审批人
     */
    RETURNED(11),
    /**
     * 添加审批人
     */
    APPEND_ASSIGNEE(12),
    /**
     * 加签并同意
     */
    APPEND_AND_AGREE(13),
    /**
     * 已办理
     */
    FINISHED(14),
    /**
     * 已转交
     */
    CLAIMED(15);

    private final int type;

    StatusChangeEvent(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    @Override
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
    public static StatusChangeEvent deserialize(int type) {
        return Arrays.stream(StatusChangeEvent.values())
                .filter(formItemStatus -> formItemStatus.type == type)
                .findFirst()
                .orElse(null);
    }
}
