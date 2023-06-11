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

package cn.felord.wecom.api;

import cn.felord.AgentDetails;
import cn.felord.DefaultAgent;
import cn.felord.api.WorkWeChatApi;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.approval.ApprovalDetail;
import cn.felord.domain.oa.ApprovalSpNo;
import cn.felord.enumeration.NativeAgent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Approval controller.
 *
 * @author dax
 * @since 2023 /6/9
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/approval")
public class ApprovalController {
    private final WorkWeChatApi workWeChatApi;

    /**
     * 根据审批单号获取企微审批详情
     *
     * @param spNo the sp no
     * @return the single
     */
    @GetMapping("/{spNo}")
    public ApprovalDetail>

    approvalDetails(@PathVariable String spNo) {
        AgentDetails nfsApproval = DefaultAgent.nativeAgent("企业ID", "审批密钥", NativeAgent.APPROVAL);
        return workWeChatApi.approvalApi(nfsApproval).queryApprovalDetail(new ApprovalSpNo(spNo)).map(GenericResponse::getData);
    }

}
