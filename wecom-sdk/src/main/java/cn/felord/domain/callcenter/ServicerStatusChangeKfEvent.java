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

package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfEventType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Servicer status change kf event.
 *
 * @author dax
 * @since 2023 /6/4
 */
@ToString
@Getter
public class ServicerStatusChangeKfEvent extends KfEvent {

    private final String recallMsgid;

    /**
     * Instantiates a new Servicer status change kf event.
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param recallMsgid    the recall msgid
     */
    @JsonCreator
    public ServicerStatusChangeKfEvent(@JsonProperty("open_kfid") String openKfid,
                                       @JsonProperty("external_userid") String externalUserid,
                                       @JsonProperty("recall_msgid") String recallMsgid) {
        super(KfEventType.SERVICER_STATUS_CHANGE, openKfid, externalUserid);
        this.recallMsgid = recallMsgid;
    }
}
