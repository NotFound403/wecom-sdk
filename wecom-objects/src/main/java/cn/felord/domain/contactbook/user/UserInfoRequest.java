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

package cn.felord.domain.contactbook.user;

import cn.felord.enumeration.Gender;
import lombok.Data;

import java.util.List;

/**
 * @author n1
 */
@Data
public class UserInfoRequest {
    private String userid;
    /**
     * 如果userid由系统自动生成，则仅允许修改一次。
     */
    private String newUserid;
    private String name;
    private String alias;
    private String mobile;
    private List<Long> department;
    private List<Integer> order;
    private String position;
    private Gender gender;
    private String email;
    private String bizMail;
    private String telephone;
    private List<Long> isLeaderInDept;
    private List<String> directLeader;
    private String avatarMediaid;
    private Integer enable;
    private Extattr extattr;
    private Boolean toInvite;
    private ExternalProfile externalProfile;
    private String externalPosition;
    private String nickname;
    private String address;
    private Long mainDepartment;
}
