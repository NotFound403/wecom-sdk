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
import java.util.Objects;

/**
 * 超级管理员类型
 * <ol>
 *     <li>主体为“小微/个人卖家 ”，可选择：65-经营者/法人。</li>
 *     <li>主体为“个体工商户/企业/政府机关/事业单位/社会组织”，可选择：65-经营者/法人、66- 经办人。</li>
 * </ol>
 * 经办人：经商户授权办理微信支付业务的人员
 *
 * @author dax
 * @since 2024/7/3 15:28
 */
public enum PayContactType {
    /**
     * 经营者/法人
     */
    Legal("65"),
    /**
     * 经办人
     */
    Operator("66");

    private final String type;

    PayContactType(String type) {
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
     * Deserialize PayContactType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static PayContactType deserialize(String type) {
        return Arrays.stream(PayContactType.values())
                .filter(payContactType -> Objects.equals(payContactType.type, type))
                .findFirst()
                .orElse(null);
    }

}
