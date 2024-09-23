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

package cn.felord.domain.callcenter;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Upgrade service request.
 *
 * @author dax
 * @since 2024/6/6
 */
@ToString
@Getter
public class UpgradeServiceRequest {
    private final String openKfid;
    private final String externalUserid;
    private final int type;
    private final Member member;
    private final GroupChat groupchat;

    /**
     * Instantiates a new Upgrade service request.
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param type           the type
     * @param member         the member
     * @param groupchat      the groupchat
     */
    UpgradeServiceRequest(String openKfid, String externalUserid, int type, Member member, GroupChat groupchat) {
        this.openKfid = openKfid;
        this.externalUserid = externalUserid;
        this.type = type;
        this.member = member;
        this.groupchat = groupchat;
    }

    /**
     * 升级专员服务
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param member         the member
     * @return the upgrade service request
     */
    public static UpgradeServiceRequest memberUpgrade(String openKfid, String externalUserid, Member member) {
        return new UpgradeServiceRequest(openKfid, externalUserid, 1, member, null);
    }

    /**
     * 升级客户群服务
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param groupchat      the groupchat
     * @return the upgrade service request
     */
    public static UpgradeServiceRequest memberUpgrade(String openKfid, String externalUserid, GroupChat groupchat) {
        return new UpgradeServiceRequest(openKfid, externalUserid, 2, null, groupchat);
    }

    /**
     * The type Member.
     */
    @Data
    public static class Member {
        private final String userid;
        private String wording;
    }

    /**
     * The type Group chat.
     */
    @Data
    public static class GroupChat {
        private final String chatId;
        private String wording;
    }
}
