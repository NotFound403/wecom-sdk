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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * 补卡组件
 *
 * @author dax
 * @since 2024/5/27
 */
@ToString
@Getter
public class PunchCorrectionValue implements ContentDataValue {
    private final Wrapper punchCorrection;

    /**
     * Instantiates a new Punch correction value.
     *
     * @param punchCorrection the punch correction
     */
    @JsonCreator
    PunchCorrectionValue(@JsonProperty("punch_correction") Wrapper punchCorrection) {
        this.punchCorrection = punchCorrection;
    }

    /**
     * Instantiates a new Punch correction value.
     *
     * @param state the state
     * @param time  the time
     */
    public PunchCorrectionValue(String state,
                                Instant time) {
        this(new Wrapper(state, time, null, null));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        /**
         * 异常状态说明
         */
        private final String state;
        /**
         * 补卡时间，Unix时间戳
         */
        private final Instant time;
        /**
         * 版本标识，为1的时候为新版补卡，daymonthyear有值
         */
        private final Integer version;
        /**
         * 补卡日期0点Unix时间戳
         */
        private final Instant daymonthyear;


        /**
         * Instantiates a new Wrapper.
         *
         * @param state        the state
         * @param time         the time
         * @param version      the version
         * @param daymonthyear the daymonthyear
         */
        @JsonCreator
        Wrapper(@JsonProperty("state") String state,
                @JsonProperty("time") Instant time,
                @JsonProperty("version") Integer version,
                @JsonProperty("daymonthyear") Instant daymonthyear) {
            this.state = state;
            this.time = time;
            this.version = version;
            this.daymonthyear = daymonthyear;
        }
    }

}
