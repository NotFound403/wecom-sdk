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
import cn.felord.enumeration.GroupChatJoinScene;
import cn.felord.enumeration.GroupChatMemberType;
import lombok.Data;

import java.time.Instant;

/**
 * The GroupChatMember
 *
 * @author dax
 * @since 2024/11/22
 */
@Data
public class GroupChatMember {
    /**
     * 群成员id
     */
    private String userid;
    /**
     * 成员类型
     */
    private GroupChatMemberType type;
    /**
     * 外部联系人在微信开放平台的唯一身份标识（微信unionid），
     * 通过此字段企业可将外部联系人与公众号/小程序用户关联起来。
     * 仅当群成员类型是微信用户（包括企业成员未添加好友），
     * 且企业绑定了微信开发者ID有此字段（查看绑定方法）。
     * 第三方不可获取，
     * 上游企业不可获取下游企业客户的unionid字段
     */
    private String unionid;
    /**
     * 入群时间
     */
    private Instant joinTime;
    /**
     * 入群方式
     */
    private GroupChatJoinScene joinScene;
    /**
     * 邀请者。目前仅当是由本企业内部成员邀请入群时会返回该值
     */
    private UserId invitor;
    /**
     * 在群里的昵称
     */
    private String groupNickname;
    /**
     * 名字。仅当 need_name = 1 时返回
     * 如果是微信用户，则返回其在微信中设置的名字
     * 如果是企业微信联系人，则返回其设置对外展示的别名或实名
     */
    private String name;
    /**
     * 企业自定义的state参数，用于区分不同的入群渠道。不超过30个UTF-8字符
     * 如果有设置此参数，在调用获取客户群详情接口时会返回每个群成员对应的该参数值
     */
    private String state;
}
