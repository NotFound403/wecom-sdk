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

import cn.felord.enumeration.ApvRel;
import cn.felord.enumeration.ProcessNodeType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 流程节点
 *
 * @author dax
 * @since 2024 /4/9
 */
@ToString
@Getter

public class ProcessNode {
    /**
     * 节点类型 1:审批人 2:抄送人 3:办理人
     */
    private final ProcessNodeType type;
    /**
     * 多人审批方式 1-会签；2-或签 3-依次审批
     */
    private final ApvRel apvRel;
    /**
     * 用户id
     */
    private final List<String> userid;

    /**
     * Instantiates a new Process node.
     *
     * @param type   the type
     * @param apvRel the apv rel
     * @param userid the userid
     */
    @JsonCreator
    ProcessNode(@JsonProperty("type") ProcessNodeType type,
                @JsonProperty("apv_rel") ApvRel apvRel,
                @JsonProperty("userid") List<String> userid) {
        this.type = type;
        this.apvRel = apvRel;
        this.userid = userid;
    }

    /**
     * Create process node.
     *
     * @param type   the type
     * @param apvRel the apv rel
     * @param userid the userid
     * @return the process node
     */
    public static ProcessNode create(ProcessNodeType type, ApvRel apvRel, List<String> userid) {
        return new ProcessNode(type, apvRel, userid);
    }

    /**
     * 审批人
     *
     * @param apvRel the apv rel
     * @param userid the userid
     * @return the process node
     */
    public static ProcessNode assignees(ApvRel apvRel, List<String> userid) {
        return create(ProcessNodeType.ASSIGNEE, apvRel, userid);
    }

    /**
     * 抄送节点，支持前抄送后抄送
     *
     * @param userid the userid
     * @return the process node
     */
    public static ProcessNode cc(List<String> userid) {
        return create(ProcessNodeType.CC, ApvRel.ALL, userid);
    }

    /**
     * 办理人节点
     *
     * @param userid the userid
     * @return the process node
     */
    public static ProcessNode processor(List<String> userid) {
        return create(ProcessNodeType.PROCESSOR, ApvRel.ALL, userid);
    }
}
