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

package cn.felord.domain.contactbook.user;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author n1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoResponse extends WeComResponse {
    private String userid;
    private String name;
    private String mobile;
    private List<Long> department;
    private List<Integer> order;
    private String position;
    private String gender;
    private String email;
    private String bizEmail;
    private List<Long> isLeaderInDept;
    private List<String> directLeader;
    private String avatar;
    private String thumbAvatar;
    private String telephone;
    private String alias;
    private Extattr extattr;
    private Integer status;
    private String qrCode;
    private ExternalProfile externalProfile;
    private String externalPosition;
    private String address;
    private String openUserid;
    private Long mainDepartment;
}