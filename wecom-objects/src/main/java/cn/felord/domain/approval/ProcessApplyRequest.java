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

import cn.felord.enumeration.UseTemplateApprover;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * ProcessApplyRequest
 *
 * @author dax
 * @since 2024 /5/25
 */
@ToString
@Getter
public class ProcessApplyRequest extends AbstractApprovalApplyRequest {
    private ApprovalProcess process;

    /**
     * 通过接口指定审批人、抄送人
     * <p>
     * 此时approver、notifyer等参数可用
     *
     * @param creatorUserid 发起人
     * @param templateId    模板ID
     * @param nodeList      新版流程列表
     * @param controls      审批模板控件，可通过获取审批模板详情接口获取
     * @param dataValues    填充值，数量、位置应当和控件一一对应详见，没有补null
     * @param summaryList   摘要不超过3行，每行不超过20个字
     * @return the approval apply request
     */
    public static ProcessApplyRequest approverMode(String creatorUserid,
                                                   String templateId,
                                                   List<ProcessNode> nodeList,
                                                   List<TmpControl<? extends ControlConfig>> controls,
                                                   List<? extends ContentDataValue> dataValues,
                                                   List<Summary> summaryList) {
        return new ProcessApplyRequest(creatorUserid,
                templateId,
                applyData(controls, dataValues),
                summaryList,
                UseTemplateApprover.APPROVER_MODE)
                .process(new ApprovalProcess(nodeList));
    }


    /**
     * 在企微控制台指定抄送人、审批人
     * <p>
     * 使用此模板在管理后台设置的审批流程(需要保证审批流程中没有“申请人自选”节点)，支持条件审批
     *
     * @param creatorUserid 发起人
     * @param templateId    模板ID
     * @param controls      审批模板控件，可通过获取审批模板详情接口获取
     * @param dataValues    填充值，数量、位置应当和控件一一对应，没有补null
     * @param summaryList   摘要不超过3行，每行不超过20个字
     * @return the approval apply request
     */
    public static ProcessApplyRequest backendMode(String creatorUserid,
                                                  String templateId,
                                                  List<TmpControl<? extends ControlConfig>> controls,
                                                  List<? extends ContentDataValue> dataValues,
                                                  List<Summary> summaryList) {
        return new ProcessApplyRequest(creatorUserid,
                templateId,
                applyData(controls, dataValues),
                summaryList,
                UseTemplateApprover.BACKEND_MODE);
    }


    /**
     * Instantiates a new Approval apply request.
     *
     * @param creatorUserid       the creator userid
     * @param templateId          the template id
     * @param applyData           the apply data
     * @param summaryList         the summary list
     * @param useTemplateApprover the use template approver
     */
    ProcessApplyRequest(String creatorUserid,
                        String templateId,
                        ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData,
                        List<Summary> summaryList,
                        UseTemplateApprover useTemplateApprover) {
        super(creatorUserid, templateId, useTemplateApprover, applyData, summaryList);
    }

    /**
     * 提单者提单部门id，不填默认为主部门
     *
     * @param chooseDepartment the choose department
     * @return the approval apply request
     */
    @Override
    public ProcessApplyRequest chooseDepartment(Long chooseDepartment) {
        super.chooseDepartment(chooseDepartment);
        return this;
    }

    /**
     * 新版流程列表
     *
     * @param process the process
     * @return the process apply request
     */
    public ProcessApplyRequest process(ApprovalProcess process) {
        this.process = process;
        return this;
    }
}
