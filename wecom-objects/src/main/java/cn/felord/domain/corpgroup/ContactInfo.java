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

package cn.felord.domain.corpgroup;

import cn.felord.enumeration.IdentityType;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Contact info.
 */
@ToString
@Getter
public class ContactInfo {
    private final String name;
    private final String mobile;
    private final IdentityType identityType;
    private final String userCustomId;

    /**
     * Instantiates a new Contact info.
     *
     * @param name         the name
     * @param mobile       the mobile
     * @param identityType the identity type
     */
    public ContactInfo(String name, String mobile, IdentityType identityType) {
        this(name, mobile, identityType, null);
    }

    /**
     * Instantiates a new Contact info.
     *
     * @param name         the name
     * @param mobile       the mobile
     * @param identityType the identity type
     * @param userCustomId the user custom id
     */
    public ContactInfo(String name, String mobile, IdentityType identityType, String userCustomId) {
        this.name = name;
        this.mobile = mobile;
        this.identityType = identityType;
        this.userCustomId = userCustomId;
    }
}
