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
 * The MsgAuditEditionType
 *
 * @author dax
 * @since 2024/10/6
 */
public enum MsgAuditEditionType {
    /**
     * 办公版
     */
    OFFICE(1),
    /**
     * 服务版
     */
    SERVICE(2),
    /**
     * 企业版
     */
    CORP(3);

    private final int type;

    MsgAuditEditionType(int type) {
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
     * Deserialize MsgAuditEditionType
     *
     * @param type the type
     * @return the MsgAuditEditionType
     */
    @JsonCreator
    public static MsgAuditEditionType deserialize(int type) {
        return Arrays.stream(MsgAuditEditionType.values())
                .filter(callType -> callType.type == type)
                .findFirst()
                .orElse(null);
    }
}
