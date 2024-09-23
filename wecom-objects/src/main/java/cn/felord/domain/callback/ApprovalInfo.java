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

package cn.felord.domain.callback;

import cn.felord.domain.approval.ProcessList;
import cn.felord.enumeration.SpStatus;
import cn.felord.enumeration.StatusChangeEvent;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * The type Approval info.
 *
 * @author dax
 * @since 2024/5/27
 */
@Data
public class ApprovalInfo {
    /**
     * 非自建应用审批，审批编号
     */
    @XStreamAlias("SpNo")
    private String spNo;
    /**
     * 非自建应用审批，审批模板名称
     */
    @XStreamAlias("SpName")
    private String spName;
    /**
     * 非自建应用审批，申请单状态
     */
    @XStreamAlias("SpStatus")
    private SpStatus spStatus;
    /**
     * 非自建应用审批，审批模板id
     */
    @XStreamAlias("TemplateId")
    private String templateId;
    /**
     * 非自建应用审批，审批申请提交时间
     */
    @XStreamAlias("ApplyTime")
    private Instant applyTime;
    /**
     * 非自建应用审批，申请人信息
     */
    @XStreamAlias("Applyer")
    private Applyer applyer;
    /**
     * 非自建应用审批，审批流程信息
     */
    @XStreamImplicit(itemFieldName = "SpRecord")
    private List<SpRecord> spRecord;
    /**
     * 非自建应用审批，抄送信息
     */
    @XStreamImplicit(itemFieldName = "Notifyer")
    private List<CallbackUserId> notifyer;
    /**
     * 审批流程列表
     */
    @XStreamAlias("ProcessList")
    private ProcessList processList;
    /**
     * 非自建应用审批，审批申请备注信息
     */
    @XStreamImplicit(itemFieldName = "Comments")
    private List<Comments> comments;
    /**
     * 非自建应用审批，审批申请状态变化类型
     */
    @XStreamAlias("StatuChangeEvent")
    private StatusChangeEvent statuChangeEvent;
    // --------------------------------------------------------------------------------------------------
    /**
     * 自建应用审批审批单编号，由开发者在发起申请时自定义
     */
    @XStreamAlias("ThirdNo")
    private String thirdNo;
    /**
     * 自建应用审批审批模板名称
     */
    @XStreamAlias("OpenSpName")
    private String openSpName;
    /**
     * 自建应用审批审批模板ID
     */
    @XStreamAlias("OpenTemplateId")
    private String openTemplateId;
    /**
     * 自建应用审批申请单当前审批状态
     */
    @XStreamAlias("OpenSpStatus")
    private SpStatus openSpStatus;
    /**
     * 自建应用审批提交者姓名
     */
    @XStreamAlias("ApplyUserName")
    private String applyUserName;
    /**
     * 自建应用审批提交者userid
     */
    @XStreamAlias("ApplyUserId")
    private String applyUserId;
    /**
     * 自建应用审批提交者所在部门
     */
    @XStreamAlias("ApplyUserParty")
    private String applyUserParty;
    /**
     * 自建应用审批提交者头像
     */
    @XStreamAlias("ApplyUserImage")
    private String applyUserImage;
    /**
     * 自建应用审批审批流程信息
     */
    @XStreamAlias(value = "ApprovalNodes", impl = List.class)
    private List<OpenApprovalNode> approvalNodes;
    /**
     * 自建应用审批抄送信息
     */
    @XStreamAlias(value = "NotifyNodes", impl = List.class)
    private List<OpenNotifyNode> notifyNodes;
    /**
     * 自建应用审批当前审批节点，从0开始
     */
    @XStreamAlias("Approverstep")
    private Integer approverStep;
}
