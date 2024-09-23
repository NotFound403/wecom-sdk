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

package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * The type At staff horizontal content.
 *
 * @author felord.cn
 * @since 2021 /9/3 15:33
 */
@Getter
public class AtStaffHorizontalContent extends HorizontalContent {
    private final String userid;

    /**
     * Instantiates a new At staff horizontal content.
     *
     * @param keyname the keyname
     * @param userid  the userid
     */
    public AtStaffHorizontalContent(String keyname, String userid) {
        this(keyname, userid, null);
    }

    /**
     * Instantiates a new At staff horizontal content.
     *
     * @param keyname the keyname
     * @param userid  the userid
     * @param value   the value
     */
    public AtStaffHorizontalContent(String keyname, String userid, String value) {
        super(HorizontalContentType.AT_STAFF, keyname, value);
        this.userid = userid;
    }

    /**
     * 需要开启ID转译 {@code enable_id_trans}
     *
     * @param keyname the keyname
     * @param userid  the userid
     * @return the at staff horizontal content
     */
    public static AtStaffHorizontalContent withTransUserId(String keyname, String userid) {
        return new AtStaffHorizontalContent(keyname, userid, "$userName=" + userid + "$");
    }

}
