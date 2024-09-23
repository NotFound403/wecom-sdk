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

package cn.felord.domain.journal;

import cn.felord.domain.approval.ApplyContentData;
import cn.felord.domain.approval.ApplyData;
import cn.felord.domain.common.UserId;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * The type Journal record detail.
 *
 * @author dax
 * @since 2024/5/27 14:48
 */
@Data
public class JournalRecordDetail {
    private String journalUuid;
    private String templateName;
    private Instant reportTime;
    private UserId submitter;
    private List<UserId> receivers;
    private List<UserId> readedReceivers;
    private ApplyData<ApplyContentData<?>> applyData;
    private List<JournalComment> comments;
}
