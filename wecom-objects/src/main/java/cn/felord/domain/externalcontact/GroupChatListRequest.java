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

import cn.felord.enumeration.GroupChatStatus;
import lombok.Data;

/**
 * @author dax
 * @since 2021/7/15 11:37
 */
@Data
public class GroupChatListRequest {
    private GroupChatStatus statusFilter;
    private OwnerFilter ownerFilter;
    private String cursor;
    private final Integer limit;
}
