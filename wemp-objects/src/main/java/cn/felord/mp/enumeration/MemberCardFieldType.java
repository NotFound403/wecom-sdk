package cn.felord.mp.enumeration;

/**
 * 会员信息类目半自定义名称，
 * 当开发者变更这类类目信息的value值时，可以选择触发系统模板消息通知用户
 *
 * @author xiafang
 * @since 2023 /8/18 16:42
 */
public enum MemberCardFieldType {

    /**
     * 等级
     */
    FIELD_NAME_TYPE_LEVEL,
    /**
     * 优惠券
     */
    FIELD_NAME_TYPE_COUPON,
    /**
     * 印花
     */
    FIELD_NAME_TYPE_STAMP,
    /**
     * 折扣
     */
    FIELD_NAME_TYPE_DISCOUNT,
    /**
     * 成就
     */
    FIELD_NAME_TYPE_ACHIEVEMEN,
    /**
     * 里程
     */
    FIELD_NAME_TYPE_MILEAGE,
    /**
     * 集点
     */
    FIELD_NAME_TYPE_SET_POINTS,
    /**
     * 次数
     */
    FIELD_NAME_TYPE_TIMS
}
