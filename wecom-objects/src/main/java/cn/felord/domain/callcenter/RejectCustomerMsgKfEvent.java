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

package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfEventType;
import cn.felord.enumeration.RejectSwitch;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@ToString
@Getter
public class RejectCustomerMsgKfEvent extends KfEvent {
    private final String externalUserid;
    private final String servicerUserid;
    private final RejectSwitch rejectSwitch;

    @JsonCreator
    public RejectCustomerMsgKfEvent(@JsonProperty("open_kfid") String openKfid,
                                    @JsonProperty("external_userid") String externalUserid,
                                    @JsonProperty("servicer_userid") String servicerUserid,
                                    @JsonProperty("reject_switch") RejectSwitch rejectSwitch) {
        super(KfEventType.REJECT_CUSTOMER_MSG_SWITCH_CHANGE, openKfid);
        this.externalUserid = externalUserid;
        this.servicerUserid = servicerUserid;
        this.rejectSwitch = rejectSwitch;
    }
}
