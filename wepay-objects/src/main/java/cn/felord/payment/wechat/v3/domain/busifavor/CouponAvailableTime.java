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
package cn.felord.payment.wechat.v3.domain.busifavor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 商家券核销规则-券可核销时间
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
@ToString
@Getter
public class CouponAvailableTime {

    /**
     * 领取后N天开始生效
     * <p>
     * 日期区间内，用户领券后需等待x天开始生效。例如领券后当天开始生效则无需填写，领券后第2天开始生效填1，以此类推……
     * <p>
     * 用户在有效期开始前领取商家券，则从有效期第1天开始计算天数，用户在有效期内领取商家券，则从领取当天开始计算天数。无论用户何时领取商家券，商家券在活动有效期结束后均不可用。
     * <p>
     * 需配合{@link #availableDayAfterReceive} 一同填写，不可单独填写。
     */
    private Integer waitDaysAfterReceive;
    /**
     * 生效后N天内有效
     * <p>
     * 日期区间内，券生效后x天内有效。例如生效当天内有效填1，生效后2天内有效填2，以此类推……
     * <p>
     * 注意，用户在有效期开始前领取商家券，则从有效期第1天开始计算天数，用户在有效期内领取商家券，则从领取当天开始计算天数，无论用户何时领取商家券，商家券在活动有效期结束后均不可用。
     * <p>
     * 可配合{@link  #waitDaysAfterReceive}一同填写，也可单独填写。单独填写时，有效期内领券后立即生效，生效后x天内有效。
     */
    private Integer availableDayAfterReceive;
    /**
     * 批次开始时间 rfc 3339   yyyy-MM-ddTHH:mm:ss+TIMEZONE
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private final OffsetDateTime availableBeginTime;
    /**
     * 批次结束时间 rfc 3339  yyyy-MM-ddTHH:mm:ss+TIMEZONE
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private final OffsetDateTime availableEndTime;
    /**
     * 固定周期有效时间段
     */
    private AvailableWeek availableWeek;
    /**
     * 无规律的有效时间段
     */
    private List<IrregularyAvaliableTimeItem> irregularyAvaliableTime;


    /**
     * Instantiates a new Coupon available time.
     *
     * @param availableBeginTime the available begin time
     * @param availableEndTime   the available end time
     */
    public CouponAvailableTime(OffsetDateTime availableBeginTime, OffsetDateTime availableEndTime) {
        this.availableBeginTime = availableBeginTime;
        this.availableEndTime = availableEndTime;
    }

    /**
     * Instantiates a new Coupon available time.
     *
     * @param waitDaysAfterReceive     the wait days after receive
     * @param availableDayAfterReceive the available day after receive
     * @param availableBeginTime       the available begin time
     * @param availableEndTime         the available end time
     * @param availableWeek            the available week
     * @param irregularyAvaliableTime  the irregulary avaliable time
     */
    @JsonCreator
    CouponAvailableTime(@JsonProperty("wait_days_after_receive") Integer waitDaysAfterReceive,
                        @JsonProperty("available_day_after_receive") Integer availableDayAfterReceive,
                        @JsonProperty("available_begin_time") OffsetDateTime availableBeginTime,
                        @JsonProperty("available_end_time") OffsetDateTime availableEndTime,
                        @JsonProperty("available_week") AvailableWeek availableWeek,
                        @JsonProperty("irregulary_avaliable_time") List<IrregularyAvaliableTimeItem> irregularyAvaliableTime) {
        this.waitDaysAfterReceive = waitDaysAfterReceive;
        this.availableDayAfterReceive = availableDayAfterReceive;
        this.availableBeginTime = availableBeginTime;
        this.availableEndTime = availableEndTime;
        this.availableWeek = availableWeek;
        this.irregularyAvaliableTime = irregularyAvaliableTime;
    }

    /**
     * Wait days after receive coupon available time.
     *
     * @param waitDaysAfterReceive the wait days after receive
     * @return the coupon available time
     */
    public CouponAvailableTime waitDaysAfterReceive(Integer waitDaysAfterReceive) {
        this.waitDaysAfterReceive = waitDaysAfterReceive;
        return this;
    }

    /**
     * Available day after receive coupon available time.
     *
     * @param availableDayAfterReceive the available day after receive
     * @return the coupon available time
     */
    public CouponAvailableTime availableDayAfterReceive(Integer availableDayAfterReceive) {
        this.availableDayAfterReceive = availableDayAfterReceive;
        return this;
    }

    /**
     * Available week coupon available time.
     *
     * @param availableWeek the available week
     * @return the coupon available time
     */
    public CouponAvailableTime availableWeek(AvailableWeek availableWeek) {
        this.availableWeek = availableWeek;
        return this;
    }

    /**
     * Irregulary avaliable time coupon available time.
     *
     * @param irregularyAvaliableTime the irregulary avaliable time
     * @return the coupon available time
     */
    public CouponAvailableTime irregularyAvaliableTime(List<IrregularyAvaliableTimeItem> irregularyAvaliableTime) {
        this.irregularyAvaliableTime = irregularyAvaliableTime;
        return this;
    }
}
