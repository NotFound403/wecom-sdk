/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.externalcontact;

import cn.felord.domain.common.UserId;
import cn.felord.enumeration.GroupChatJoinScene;
import cn.felord.enumeration.GroupChatMemberType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/15 19:52
 */
@Data
public class GroupChatDetail {
    private String chatId;
    private String name;
    private String owner;
    private Instant createTime;
    private String notice;
    private List<GroupChatMember> memberList;
    private List<UserId>  adminList;


    @Data
    public static class GroupChatMember {
        private String userid;
        private GroupChatMemberType type;
        private String unionid;
        private Instant joinTime;
        private GroupChatJoinScene joinScene;
        private UserId invitor;
        private String groupNickname;
        private String name;
    }
}
