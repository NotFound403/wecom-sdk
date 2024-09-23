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

package cn.felord.domain.msgaudit;

import cn.felord.enumeration.MsgAuditEditionType;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Permit users request.
 *
 * @author dax
 * @since 2024/12/1
 */
@ToString
@Getter
public class PermitUsersRequest {
    /**
     * 版本
     */
    private final MsgAuditEditionType type;

    /**
     * Instantiates a new Permit users request.
     *
     * @param type the type
     */
    PermitUsersRequest(MsgAuditEditionType type) {
        this.type = type;
    }

    /**
     * 办公版
     *
     * @return the permit users request
     */
    public static PermitUsersRequest office() {
        return new PermitUsersRequest(MsgAuditEditionType.OFFICE);
    }

    /**
     * 服务版
     *
     * @return the permit users request
     */
    public static PermitUsersRequest service() {
        return new PermitUsersRequest(MsgAuditEditionType.SERVICE);
    }

    /**
     * 企业版
     *
     * @return the permit users request
     */
    public static PermitUsersRequest corp() {
        return new PermitUsersRequest(MsgAuditEditionType.CORP);
    }
}
