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

package cn.felord.domain.callback;

import cn.felord.enumeration.SpStatus;
import cn.felord.enumeration.StatusChangeEvent;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/5/27
 */
@Data
public class ApprovalInfo {
    @XStreamAlias("SpNo")
    private String spNo;
    @XStreamAlias("SpName")
    private String spName;
    @XStreamAlias("SpStatus")
    private SpStatus spStatus;
    @XStreamAlias("TemplateId")
    private String templateId;
    @XStreamAlias("ApplyTime")
    private Instant applyTime;
    @XStreamAlias("Applyer")
    private Applyer applyer;
    @XStreamImplicit(itemFieldName = "SpRecord")
    private List<SpRecord> spRecord;
    @XStreamImplicit(itemFieldName = "Notifyer")
    private List<CallbackUserId> notifyer;
    @XStreamImplicit(itemFieldName = "Comments")
    private List<Comments> comments;
    @XStreamAlias("StatuChangeEvent")
    private StatusChangeEvent statuChangeEvent;
}
