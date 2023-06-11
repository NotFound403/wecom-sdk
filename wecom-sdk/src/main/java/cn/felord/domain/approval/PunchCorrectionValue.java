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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/5/27
 */
@ToString
@Getter
public class PunchCorrectionValue implements ContentDataValue {
    private final Wrapper punchCorrection;

    @JsonCreator
    public PunchCorrectionValue(@JsonProperty("punchCorrection") Wrapper punchCorrection) {
        this.punchCorrection = punchCorrection;
    }

    /**
     * The type Wrapper.
     */
    @Data
    public static class Wrapper {
        private String state;
        private Instant time;

    }

}
