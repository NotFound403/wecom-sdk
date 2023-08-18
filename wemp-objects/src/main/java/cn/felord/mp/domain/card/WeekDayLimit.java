package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.WeekDay;
import lombok.Data;

/**
 * 使用时段限制
 *
 * @author xiafang
 * @since 2023 /8/18 16:02
 */
@Data
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
}