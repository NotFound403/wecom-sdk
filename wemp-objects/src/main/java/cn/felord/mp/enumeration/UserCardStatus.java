package cn.felord.mp.enumeration;

/**
 * 当前code对应卡券的状态
 * <p>
 * code未被添加或被转赠领取的情况则统一报错：invalid serial code
 *
 * @author dax
 * @since 2023 /8/19
 */
public enum UserCardStatus {
    /**
     * 正常
     */
    NORMAL,
    /**
     * 已核销
     */
    CONSUMED,
    /**
     * 已过期
     */
    EXPIRE,
    /**
     * 转赠中
     */
    GIFTING,
    /**
     * 转赠超时
     */
    GIFT_TIMEOUT,
    /**
     * 已删除
     */
    DELETE,
    /**
     * 已失效
     */
    UNAVAILABLE
}