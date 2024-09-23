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

package cn.felord.domain.living;

import cn.felord.enumeration.LivingType;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;
import java.time.Instant;

/**
 * The type Living update request.
 *
 * @author dax
 * @since 2024/11/23
 */
@ToString
@Getter
public class LivingUpdateRequest {
    /**
     * 直播id，仅允许修改预约状态下的直播id
     */
    private final String livingid;
    /**
     * 直播的标题，最多支持60个字节
     */
    private String theme;
    /**
     * 直播开始时间的unix时间戳
     */
    private Instant livingStart;
    /**
     * 直播持续时长
     */
    private Duration livingDuration;
    /**
     * 直播的类型
     */
    private LivingType type;
    /**
     * 直播的简介，最多支持300个字节
     */
    private String description;
    /**
     * 指定直播开始前多久提醒用户，相对于living_start前的秒数，默认为0
     */
    private Duration remindTime;

    /**
     * Instantiates a new Living update request.
     *
     * @param livingid the livingid
     */
    public LivingUpdateRequest(String livingid) {
        this.livingid = livingid;
    }

    /**
     * Theme living update request.
     *
     * @param theme the theme
     * @return the living update request
     */
    public LivingUpdateRequest theme(String theme) {
        this.theme = theme;
        return this;
    }

    /**
     * Living start living update request.
     *
     * @param livingStart the living start
     * @return the living update request
     */
    public LivingUpdateRequest livingStart(Instant livingStart) {
        this.livingStart = livingStart;
        return this;
    }

    /**
     * Living duration living update request.
     *
     * @param livingDuration the living duration
     * @return the living update request
     */
    public LivingUpdateRequest livingDuration(Duration livingDuration) {
        this.livingDuration = livingDuration;
        return this;
    }

    /**
     * Type living update request.
     *
     * @param type the type
     * @return the living update request
     */
    public LivingUpdateRequest type(LivingType type) {
        this.type = type;
        return this;
    }

    /**
     * Description living update request.
     *
     * @param description the description
     * @return the living update request
     */
    public LivingUpdateRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Remind time living update request.
     *
     * @param remindTime the remind time
     * @return the living update request
     */
    public LivingUpdateRequest remindTime(Duration remindTime) {
        this.remindTime = remindTime;
        return this;
    }
}
