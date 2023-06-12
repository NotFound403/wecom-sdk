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

package cn.felord.domain.oa;

import cn.felord.enumeration.SharePermission;
import lombok.Data;

/**
 * @author felord
 * @since 2021/11/22 10:36
 */
@Data
public class CalendarSharer {
    private final String userid;
    private final SharePermission permission;

    public CalendarSharer(String userid) {
        this(userid, SharePermission.READ_ALL);
    }

    public CalendarSharer(String userid, SharePermission permission) {
        this.userid = userid;
        this.permission = permission;
    }
}
