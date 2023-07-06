package cn.felord.enumeration;

/**
 * 申请状态
 *
 * @author dax
 * @since 2023 /7/3 16:08
 */
public enum ApplymentState {
    /**
     * 资料校验中
     */
    CHECKING,
    /**
     * 待签约
     */
    NEED_SIGN,
    /**
     * 待账户验证
     */
    ACCOUNT_NEED_VERIFY,

    /**
     * 完成
     */
    FINISH,

    /**
     * 审核中
     */
    AUDITING,

    /**
     * 已冻结
     */
    FROZEN,

    /**
     * 已驳回
     */
    REJECTED,

    /**
     * 已作废
     */
    CANCELED
}
