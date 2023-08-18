package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.DateInfoType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * 使用日期，有效期的信息
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@ToString
@Getter
public class DateInfo {
    /**
     * 使用时间的类型
     */
    private final DateInfoType type;
    /**
     * type为DATE_TYPE_FIX_TIME_RANGE时专用，
     * 表示起用时间。从1970年1月1日00:00:00至起用时间的秒数 （ 东八区时间,UTC+8，单位为秒 ）
     */
    private final Long beginTimestamp;
    /**
     * type为DATE_TYPE_FIX_TERM_RANGE时专用，
     * 表示结束时间 （ 东八区时间,UTC+8，单位为秒 ）
     */
    private final Long endTimestamp;
    /**
     * type为DATE_TYPE_FIX_TERM时专用，
     * 表示自领取后多少天内有效，领取后当天有效填写0（单位为天）
     */
    private final Long fixedTerm;
    /**
     * type为DATE_TYPE_FIX_TERM时专用，
     * 表示自领取后多少天开始生效。（单位为天）
     */
    private final Long fixedBeginTerm;

    /**
     * Instantiates a new Date info.
     *
     * @param type           the type
     * @param beginTimestamp the begin timestamp
     * @param endTimestamp   the end timestamp
     * @param fixedTerm      the fixed term
     * @param fixedBeginTerm the fixed begin term
     */
    @JsonCreator
    DateInfo(@JsonProperty("type") DateInfoType type,
             @JsonProperty("begin_timestamp") Long beginTimestamp,
             @JsonProperty("end_timestamp") Long endTimestamp,
             @JsonProperty("fixed_term") Long fixedTerm,
             @JsonProperty("fixed_begin_term") Long fixedBeginTerm) {
        this.type = type;
        this.beginTimestamp = beginTimestamp;
        this.endTimestamp = endTimestamp;
        this.fixedTerm = fixedTerm;
        this.fixedBeginTerm = fixedBeginTerm;
    }

    /**
     * 永久有效类型
     *
     * @return the date info
     */
    public static DateInfo permanent() {
        return new DateInfo(DateInfoType.DATE_TYPE_PERMANENT, null, null, null, null);
    }

    /**
     * Time range date info.
     *
     * @param beginTimestamp the begin timestamp
     * @return the date info
     */
    public static DateInfo timeRange(Instant beginTimestamp) {
        return new DateInfo(DateInfoType.DATE_TYPE_FIX_TIME_RANGE, beginTimestamp.getEpochSecond(), null, null, null);
    }

    /**
     * Term range date info.
     *
     * @param endTimestamp the end timestamp
     * @return the date info
     */
    public static DateInfo termRange(Instant endTimestamp) {
        return new DateInfo(DateInfoType.DATE_TYPE_FIX_TIME_RANGE, null, endTimestamp.getEpochSecond(), null, null);
    }

    /**
     * Term date info.
     *
     * @param fixedTerm      the fixed term
     * @param fixedBeginTerm the fixed begin term
     * @return the date info
     */
    public static DateInfo term(Long fixedTerm, Long fixedBeginTerm) {
        return new DateInfo(DateInfoType.DATE_TYPE_FIX_TIME_RANGE, null, null, fixedTerm, fixedBeginTerm);
    }
}