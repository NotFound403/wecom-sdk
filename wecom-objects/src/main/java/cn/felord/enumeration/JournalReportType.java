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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 汇报方式
 *
 * @author dax
 * @since 2024/5/25 16:19
 */
public enum JournalReportType {

    /**
     * 按日汇报
     */
    DAILY(2),
    /**
     * 按周汇报
     */
    WEEKLY(3),
    /**
     * 按月汇报
     */
    MONTHLY(4);
    private final int type;

    JournalReportType(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

    /**
     * Deserialize journal report type.
     *
     * @param type the type
     * @return the journal report type
     */
    @JsonCreator
    public static JournalReportType deserialize(int type) {
        return Arrays.stream(JournalReportType.values())
                .filter(journalReportType -> journalReportType.type == type)
                .findFirst()
                .orElse(null);
    }
}
