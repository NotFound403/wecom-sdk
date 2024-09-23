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

package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.WeekDay;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 使用时段限制
 *
 * @author dax
 * @since 2024/8/18 16:02
 */
@ToString
@RequiredArgsConstructor
@Getter
public class WeekDayLimit {

    /**
     * 此处只控制显示， 不控制实际使用逻辑，不填默认不显示
     */
    private final WeekDay type;
    /**
     * 当前type类型下的起始时间（小时） ，
     * 如当前结构体内填写了MONDAY， 此处填写了10，则此处表示周一 10:00可用
     */
    private Integer beginHour;
    /**
     * 当前type类型下的起始时间（分钟） ，
     * 如当前结构体内填写了MONDAY， begin_hour填写10，此处填写了59， 则此处表示周一 10:59可用
     */
    private Integer beginMinute;
    /**
     * 当前type类型下的结束时间（小时） ，
     * 如当前结构体内填写了MONDAY， 此处填写了20， 则此处表示周一 10:00-20:00可用
     */
    private Integer endHour;
    /**
     * 当前type类型下的结束时间（分钟） ，
     * 如当前结构体内填写了MONDAY， begin_hour填写10，此处填写了59， 则此处表示周一 10:59-00:59可用
     */
    private Integer endMinute;

    /**
     * Instantiates a new Week day limit.
     *
     * @param type        the type
     * @param beginHour   the begin hour
     * @param beginMinute the begin minute
     * @param endHour     the end hour
     * @param endMinute   the end minute
     */
    @JsonCreator
    public WeekDayLimit(@JsonProperty("type") WeekDay type,
                        @JsonProperty("begin_hour") Integer beginHour,
                        @JsonProperty("begin_minute") Integer beginMinute,
                        @JsonProperty("end_hour") Integer endHour,
                        @JsonProperty("end_minute") Integer endMinute) {
        this.type = type;
        this.beginHour = beginHour;
        this.beginMinute = beginMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    /**
     * Begin hour week day limit.
     *
     * @param beginHour the begin hour
     * @return the week day limit
     */
    public WeekDayLimit beginHour(Integer beginHour) {
        this.beginHour = beginHour;
        return this;
    }

    /**
     * Begin minute week day limit.
     *
     * @param beginMinute the begin minute
     * @return the week day limit
     */
    public WeekDayLimit beginMinute(Integer beginMinute) {
        this.beginMinute = beginMinute;
        return this;
    }

    /**
     * End hour week day limit.
     *
     * @param endHour the end hour
     * @return the week day limit
     */
    public WeekDayLimit endHour(Integer endHour) {
        this.endHour = endHour;
        return this;
    }

    /**
     * End minute week day limit.
     *
     * @param endMinute the end minute
     * @return the week day limit
     */
    public WeekDayLimit endMinute(Integer endMinute) {
        this.endMinute = endMinute;
        return this;
    }
}
