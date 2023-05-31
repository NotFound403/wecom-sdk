/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
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
 * @author dax
 * @since 2023/5/25
 */
@ToString
@Getter
public class Approver {
    private final ApproverNodeMode attr;
    private final List<String> userid;

    public Approver(String userid) {
        this.userid = Collections.singletonList(userid);
        this.attr = ApproverNodeMode.ALL;
    }

    public Approver(ApproverNodeMode attr, List<String> userid) {
        this.attr = attr;
        this.userid = userid;
    }
}