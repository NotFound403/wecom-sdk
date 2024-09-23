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
 * The SpStatus   org  roleid  tempid  filter
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
@XStreamConverter(NumberEnumConverter.class)
public enum SpStatus implements CallbackNumberEnum {

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
     * 已撤销
     */
    REVOKED(4),
    /**
     * 通过后撤销
     */
    REVOKE_AFTER_ADOPT(6),
    /**
     * 已删除
     */
    DELETED(7),
    /**
     * 已支付
     */
    PAYED(10);

    private final int type;

    SpStatus(int type) {
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
    public static SpStatus deserialize(int type) {
        return Arrays.stream(SpStatus.values())
                .filter(formItemStatus -> formItemStatus.type == type)
                .findFirst()
                .orElse(null);
    }
}
