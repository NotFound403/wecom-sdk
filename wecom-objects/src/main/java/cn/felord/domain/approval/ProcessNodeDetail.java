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
import cn.felord.enumeration.ProcessNodeStatus;
import cn.felord.enumeration.ProcessNodeType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2024/4/17
 */
@Data
public class ProcessNodeDetail {
    /**
     * 节点类型 1:审批人 2:抄送人 3:办理人
     */
    @XStreamAlias("NodeType")
    private ProcessNodeType nodeType;
    /**
     * 节点状态
     */
    @XStreamAlias("SpStatus")
    private ProcessNodeStatus spStatus;
    /**
     * 多人审批方式 1-会签；2-或签 3-依次审批
     */
    @XStreamAlias("ApvRel")
    private ApvRel apvRel;
    /**
     * 子节点列表
     */
    @XStreamImplicit(itemFieldName = "SubNodeList")
    private List<ProcessSubNode> subNodeList;
}
