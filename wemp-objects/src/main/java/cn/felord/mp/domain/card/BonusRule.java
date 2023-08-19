package cn.felord.mp.domain.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 积分规则
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@ToString
@Getter
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

    /**
     * Instantiates a new Bonus rule.
     */
    public BonusRule() {
    }

    /**
     * Instantiates a new Bonus rule.
     *
     * @param costMoneyUnit        the cost money unit
     * @param increaseBonus        the increase bonus
     * @param maxIncreaseBonus     the max increase bonus
     * @param initIncreaseBonus    the init increase bonus
     * @param costBonusUnit        the cost bonus unit
     * @param reduceMoney          the reduce money
     * @param maxReduceBonus       the max reduce bonus
     * @param leastMoneyToUseBonus the least money to use bonus
     */
    @JsonCreator
    BonusRule(@JsonProperty("cost_money_unit") Integer costMoneyUnit, @JsonProperty("increase_bonus") Integer increaseBonus,
              @JsonProperty("max_increase_bonus") Integer maxIncreaseBonus, @JsonProperty("init_increase_bonus") Integer initIncreaseBonus,
              @JsonProperty("cost_bonus_unit") Integer costBonusUnit, @JsonProperty("reduce_money") Integer reduceMoney,
              @JsonProperty("max_reduce_bonus") Integer maxReduceBonus, @JsonProperty("least_money_to_use_bonus") Integer leastMoneyToUseBonus) {
        this.costMoneyUnit = costMoneyUnit;
        this.increaseBonus = increaseBonus;
        this.maxIncreaseBonus = maxIncreaseBonus;
        this.initIncreaseBonus = initIncreaseBonus;
        this.costBonusUnit = costBonusUnit;
        this.reduceMoney = reduceMoney;
        this.maxReduceBonus = maxReduceBonus;
        this.leastMoneyToUseBonus = leastMoneyToUseBonus;
    }

    /**
     * Cost money unit bonus rule.
     *
     * @param costMoneyUnit the cost money unit
     * @return the bonus rule
     */
    public BonusRule costMoneyUnit(Integer costMoneyUnit) {
        this.costMoneyUnit = costMoneyUnit;
        return this;
    }

    /**
     * Increase bonus bonus rule.
     *
     * @param increaseBonus the increase bonus
     * @return the bonus rule
     */
    public BonusRule increaseBonus(Integer increaseBonus) {
        this.increaseBonus = increaseBonus;
        return this;
    }

    /**
     * Max increase bonus bonus rule.
     *
     * @param maxIncreaseBonus the max increase bonus
     * @return the bonus rule
     */
    public BonusRule maxIncreaseBonus(Integer maxIncreaseBonus) {
        this.maxIncreaseBonus = maxIncreaseBonus;
        return this;
    }

    /**
     * Init increase bonus bonus rule.
     *
     * @param initIncreaseBonus the init increase bonus
     * @return the bonus rule
     */
    public BonusRule initIncreaseBonus(Integer initIncreaseBonus) {
        this.initIncreaseBonus = initIncreaseBonus;
        return this;
    }

    /**
     * Cost bonus unit bonus rule.
     *
     * @param costBonusUnit the cost bonus unit
     * @return the bonus rule
     */
    public BonusRule costBonusUnit(Integer costBonusUnit) {
        this.costBonusUnit = costBonusUnit;
        return this;
    }

    /**
     * Reduce money bonus rule.
     *
     * @param reduceMoney the reduce money
     * @return the bonus rule
     */
    public BonusRule reduceMoney(Integer reduceMoney) {
        this.reduceMoney = reduceMoney;
        return this;
    }

    /**
     * Max reduce bonus bonus rule.
     *
     * @param maxReduceBonus the max reduce bonus
     * @return the bonus rule
     */
    public BonusRule maxReduceBonus(Integer maxReduceBonus) {
        this.maxReduceBonus = maxReduceBonus;
        return this;
    }

    /**
     * Least money to use bonus bonus rule.
     *
     * @param leastMoneyToUseBonus the least money to use bonus
     * @return the bonus rule
     */
    public BonusRule leastMoneyToUseBonus(Integer leastMoneyToUseBonus) {
        this.leastMoneyToUseBonus = leastMoneyToUseBonus;
        return this;
    }
}