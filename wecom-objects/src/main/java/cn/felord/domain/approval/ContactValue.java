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

package cn.felord.domain.approval;

import cn.felord.enumeration.ContactCtrlMode;
import cn.felord.utils.CollectionUtils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 成员/部门组件
 *
 * @author dax
 * @since 2024/5/27 10:31
 */
@ToString
@Getter
public class ContactValue implements ContentDataValue {
    @JsonIgnore
    private final ContactCtrlMode contactCtrlMode;
    private final List<MemberInfo> members;
    private final Set<ApprovalDeptInfo> departments;

    /**
     * Instantiates a new Contact value.
     *
     * @param members     the members
     * @param departments the departments
     */
    @JsonCreator
    ContactValue(@JsonProperty("members") List<MemberInfo> members, @JsonProperty("departments") Set<ApprovalDeptInfo> departments) {
        this.contactCtrlMode = CollectionUtils.isEmpty(members) ? ContactCtrlMode.DEPARTMENT : ContactCtrlMode.USER;
        this.members = members;
        this.departments = departments;
    }

    /**
     * 成员组件
     *
     * @param members the members
     * @return the contact value
     */
    public static ContactValue user(List<MemberInfo> members) {
        return new ContactValue(members, Collections.emptySet());
    }

    /**
     * 成员组件
     *
     * @param userIds the user ids
     * @return the contact value
     */
    public static ContactValue users(List<String> userIds) {
        List<MemberInfo> members = userIds.stream()
                .map(userId -> new MemberInfo(userId, ""))
                .collect(Collectors.toList());
        return new ContactValue(members, Collections.emptySet());
    }

    /**
     * 部门组件
     *
     * @param departments the departments
     * @return the contact value
     */
    public static ContactValue dept(Set<ApprovalDeptInfo> departments) {
        return new ContactValue(Collections.emptyList(), departments);
    }

    /**
     * 部门组件
     *
     * @param partyIds the party ids
     * @return the contact value
     */
    public static ContactValue depts(List<Long> partyIds) {
        Set<ApprovalDeptInfo> departments = partyIds.stream()
                .map(partyId -> new ApprovalDeptInfo(partyId, ""))
                .collect(Collectors.toSet());
        return new ContactValue(Collections.emptyList(), departments);
    }

    /**
     * The type Member info.
     */
    @ToString
    @Getter
    public static class MemberInfo {
        private final String userid;
        private final String name;

        /**
         * Instantiates a new Member info.
         *
         * @param userid the userid
         * @param name   the name
         */
        @JsonCreator
        public MemberInfo(@JsonProperty("userid") String userid, @JsonProperty("name") String name) {
            this.userid = userid;
            this.name = name;
        }
    }

    /**
     * The type Dept info.
     */
    @ToString
    @Getter
    public static class ApprovalDeptInfo {
        private final Long openapiId;
        private final String name;

        /**
         * Instantiates a new Dept info.
         *
         * @param openapiId the openapi id
         * @param name      the name
         */
        @JsonCreator
        public ApprovalDeptInfo(@JsonProperty("openapi_id") Long openapiId, @JsonProperty("name") String name) {
            this.openapiId = openapiId;
            this.name = name;
        }
    }
}
