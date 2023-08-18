package cn.felord.mp.domain.card;

import lombok.Data;

/**
 * 积分规则
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class BonusRule {
    /**
     * 消费金额。以分为单位
     */
    private Integer costMoneyUnit;
    /**
     * 对应增加的积分
     */
    private Integer increaseBonus;
    /**
     * 用户单次可获取的积分上限
     */
    private Integer maxIncreaseBonus;
    /**
     * 初始设置积分
     */
    private Integer initIncreaseBonus;
    /**
     * 每使用X积分
     */
    private Integer costBonusUnit;
    /**
     * 抵扣xx元，（这里以分为单位）
     */
    private Integer reduceMoney;
    /**
     * 抵扣条件，单笔最多使用xx积分
     */
    private Integer maxReduceBonus;
    /**
     * 抵扣条件，满xx元（这里以分为单位）可用
     */
    private Integer leastMoneyToUseBonus;
}