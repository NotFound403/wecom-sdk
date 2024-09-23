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

import cn.felord.domain.common.UserId;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/15 19:52
 */
@Data
public class GroupChatDetail {
    /**
     * 客户群ID
     */
    private String chatId;
    /**
     * 群名
     */
    private String name;
    /**
     * 群主ID
     */
    private String owner;
    /**
     * 群的创建时间
     */
    private Instant createTime;
    /**
     * 群公告
     */
    private String notice;
    /**
     * 群成员列表
     */
    private List<GroupChatMember> memberList;
    /**
     * 群管理员列表
     */
    private List<UserId>  adminList;
    /**
     * 当前群成员版本号。可以配合客户群变更事件减少主动调用本接口的次数
     */
    private String memberVersion;
}
