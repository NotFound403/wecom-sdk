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
 * The type Living create request.
 *
 * @author dax
 * @since 2024/5/24 11:36
 */
@ToString
@Getter
public class LivingCreateRequest {
    /**
     * 直播发起者的userid
     */
    private final String anchorUserid;
    /**
     * 直播的标题，最多支持20个utf8字符
     */
    private final String theme;
    /**
     * 直播开始时间的unix时间戳
     */
    private final Instant livingStart;
    /**
     * 直播持续时长秒数
     */
    private final Duration livingDuration;
    /**
     * 直播的类型
     * <p>
     * 其中大班课和小班课仅k12学校和IT行业类型能够发起
     */
    private LivingType type;
    /**
     * 直播的简介，最多支持100个utf8字符，
     * 仅对“通用直播”、“小班课”、“大班课”和“企业培训”生效，
     * “活动直播”简介通过activity_detail.description控制
     */
    private String description;
    /**
     * 授权方安装的应用agentid。仅旧的第三方多应用套件需要填此参数
     */
    private Integer agentid;
    /**
     * 指定直播开始前多久提醒用户，相对于living_start前的秒数，默认为0
     */
    private Duration remindTime;
    /**
     * 活动直播特定参数，直播间封面图的mediaId
     */
    private String activityCoverMediaid;
    /**
     * 活动直播特定参数，直播分享卡片图的mediaId
     */
    private String activityShareMediaid;
    /**
     * 活动直播特定参数，活动直播详情信息
     */
    private ActivityDetail activityDetail;

    /**
     * Instantiates a new Living create request.
     *
     * @param anchorUserid   the anchor userid
     * @param theme          the theme
     * @param livingStart    the living start
     * @param livingDuration the living duration
     */
    public LivingCreateRequest(String anchorUserid, String theme, Instant livingStart, Duration livingDuration) {
        this.anchorUserid = anchorUserid;
        this.theme = theme;
        this.livingStart = livingStart;
        this.livingDuration = livingDuration;
    }

    /**
     * Type living create request.
     *
     * @param type the type
     * @return the living create request
     */
    public LivingCreateRequest type(LivingType type) {
        this.type = type;
        return this;
    }

    /**
     * Description living create request.
     *
     * @param description the description
     * @return the living create request
     */
    public LivingCreateRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Agentid living create request.
     *
     * @param agentid the agentid
     * @return the living create request
     */
    public LivingCreateRequest agentid(Integer agentid) {
        this.agentid = agentid;
        return this;
    }

    /**
     * Remind time living create request.
     *
     * @param remindTime the remind time
     * @return the living create request
     */
    public LivingCreateRequest remindTime(Duration remindTime) {
        this.remindTime = remindTime;
        return this;
    }

    /**
     * Activity cover mediaid living create request.
     *
     * @param activityCoverMediaid the activity cover mediaid
     * @return the living create request
     */
    public LivingCreateRequest activityCoverMediaid(String activityCoverMediaid) {
        this.activityCoverMediaid = activityCoverMediaid;
        return this;
    }

    /**
     * Activity share mediaid living create request.
     *
     * @param activityShareMediaid the activity share mediaid
     * @return the living create request
     */
    public LivingCreateRequest activityShareMediaid(String activityShareMediaid) {
        this.activityShareMediaid = activityShareMediaid;
        return this;
    }

    /**
     * Activity detail living create request.
     *
     * @param activityDetail the activity detail
     * @return the living create request
     */
    public LivingCreateRequest activityDetail(ActivityDetail activityDetail) {
        this.activityDetail = activityDetail;
        return this;
    }
}
