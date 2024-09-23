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

import cn.felord.enumeration.ApproverNodeMode;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * 审批人，
 * <p>
 * 已过时，新的审批人抄送人机制
 *
 * @author dax
 * @since 2024 /5/25
 */
@Deprecated
@ToString
@Getter
public class Approver {
    private final ApproverNodeMode attr;
    private final List<String> userid;

    /**
     * 单签
     *
     * @param userid the userid
     */
    public Approver(String userid) {
        this(ApproverNodeMode.ALL, Collections.singletonList(userid));
    }

    /**
     * 或签
     *
     * @param userid the userid
     * @return the approver
     */
    public static Approver or(List<String> userid) {
        return new Approver(ApproverNodeMode.OR, userid);
    }

    /**
     * 会签
     *
     * @param userid the userid
     * @return the approver
     */
    public static Approver all(List<String> userid) {
        return new Approver(ApproverNodeMode.ALL, userid);
    }

    /**
     * Instantiates a new Approver.
     *
     * @param attr   the attr
     * @param userid the userid
     */
    public Approver(ApproverNodeMode attr, List<String> userid) {
        this.attr = attr;
        this.userid = userid;
    }
}
