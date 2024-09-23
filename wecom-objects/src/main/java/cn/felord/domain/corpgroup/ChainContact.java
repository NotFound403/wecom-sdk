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

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class ChainContact {
    private final String corpName;
    private final List<ContactInfo> contactInfoList;
    private String customId;
    private String groupPath;

    public ChainContact(String corpName, List<ContactInfo> contactInfoList) {
        this.corpName = corpName;
        this.contactInfoList = contactInfoList;
    }

    public ChainContact(String corpName, List<ContactInfo> contactInfoList, String customId) {
        this.corpName = corpName;
        this.contactInfoList = contactInfoList;
        this.customId = customId;
    }

    public ChainContact(List<ContactInfo> contactInfoList, String corpName, String groupPath) {
        this.corpName = corpName;
        this.contactInfoList = contactInfoList;
        this.groupPath = groupPath;
    }

    public ChainContact(String corpName, List<ContactInfo> contactInfoList, String customId, String groupPath) {
        this.corpName = corpName;
        this.contactInfoList = contactInfoList;
        this.customId = customId;
        this.groupPath = groupPath;
    }
}
