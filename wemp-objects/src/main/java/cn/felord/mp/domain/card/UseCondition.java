package cn.felord.mp.domain.card;

import lombok.Data;

/**
 * 使用门槛（条件）字段，
 * 若不填写使用条件则在券面拼写 ：无最低消费限制，全场通用，不限品类；并在使用说明显示： 可与其他优惠共享
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class UseCondition {
    /**
     * 指定可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写适用于xxx
     */
    private String acceptCategory;
    /**
     * 指定不可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写不适用于xxxx
     */
    private String rejectCategory;
    /**
     * 满减门槛字段，可用于兑换券和代金券 ，填入后将在全面拼写消费满xx元可用。
     */
    private Integer leastCost;
    /**
     * 购买xx可用类型门槛，仅用于兑换 ，填入后自动拼写购买xxx可用
     */
    private String objectUseFor;
    /**
     * 不可以与其他类型共享门槛 ，
     * 填写false时系统将在使用须知里 拼写“不可与其他优惠共享”， 填写true时系统将在使用须知里 拼写“可与其他优惠共享”， 默认为true
     */
    private Boolean canUseWithOtherDiscount;
}