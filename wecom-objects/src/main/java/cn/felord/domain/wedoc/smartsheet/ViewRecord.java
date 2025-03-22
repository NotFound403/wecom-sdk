/*
 * Copyright (c) 2025. felord.cn
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

package cn.felord.domain.wedoc.smartsheet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.Map;

/**
 * @author dax
 * @since 2024/12/25
 */
@ToString
@Getter
public class ViewRecord {
    private final String recordId;
    private final Instant createTime;
    private final Instant updateTime;
    private final String creatorName;
    private final String updaterName;
    private final Map<String, ?> values;

    @JsonCreator
    ViewRecord(@JsonProperty("record_id") String recordId,
               @JsonProperty("create_time") long createTime,
               @JsonProperty("update_time") long updateTime,
               @JsonProperty("creator_name") String creatorName,
               @JsonProperty("updater_name") String updaterName,
               @JsonProperty("values") Map<String, ?> values) {
        this.recordId = recordId;
        this.createTime = Instant.ofEpochMilli(createTime);
        this.updateTime = Instant.ofEpochMilli(updateTime);
        this.creatorName = creatorName;
        this.updaterName = updaterName;
        this.values = values;
    }

    //todo 需要根据类型写解析方法？ getUsers getString getNumber getInstant getOptions
}
