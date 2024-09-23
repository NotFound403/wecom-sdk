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

package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;

/**
 * The type Contact info.
 *
 * @author dax
 * @since 2024/1/17
 */
@Data
public class ContactInfo {

    /**
     * 是否被成员标记为客户
     */
    private Boolean isCustomer;
    /**
     * 外部联系人临时ID，有效期为4小时。
     */
    private String tmpOpenid;
    /**
     * 脱敏后的外部联系人昵称（如果是其他外部联系人才返回）
     */
    private String name;
    /**
     * 添加此外部联系人的企业成员或外部联系人所在群聊的群主userid
     */
    private String followUserid;
    /**
     * 外部联系人所在的群聊ID（如果群聊被成员标记为客户群才返回）
     */
    private String chatId;
    /**
     * 外部联系人所在群聊的群名（如果群聊未被成员标记为客户群才返回）
     */
    private String chatName;
    /**
     * 外部联系人首次添加/进群的时间
     */
    private Instant addTime;
}
