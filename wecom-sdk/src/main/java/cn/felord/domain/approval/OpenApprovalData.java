
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

package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author dax
 * @since 2023/5/19 22:23
 */
@Data
public class OpenApprovalData {
    @JsonProperty("ApplyTime")
    private Long applyTime;
    @JsonProperty("ApplyUserId")
    private String applyUserId;
    @JsonProperty("ApplyUserImage")
    private String applyUserImage;
    @JsonProperty("ApplyUserParty")
    private String applyUserParty;
    @JsonProperty("ApplyUsername")
    private String applyUsername;
    @JsonProperty("ApprovalNodes")
    private ApprovalNodes approvalNodes;
    @JsonProperty("ApproverStep")
    private Long approverStep;
    @JsonProperty("NotifyNodes")
    private NotifyNodes notifyNodes;
    @JsonProperty("OpenSpName")
    private String openSpName;
    @JsonProperty("OpenSpstatus")
    private Long openSpstatus;
    @JsonProperty("OpenTemplateId")
    private String openTemplateId;
    @JsonProperty("ThirdNo")
    private String thirdNo;
}
