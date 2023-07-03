package cn.felord.enumeration;

/**
 * @author dax
 * @since 2023/7/3 16:12
 */
public enum AccountSignState {

    /**
     * 未签约。该状态下，电商平台可查询获取签约链接，引导二级商户的超级管理员完成签约
     */
    UNSIGNED,
    /**
     * 已签约。指二级商户的超级管理员已完成签约。注意：若申请单被驳回，商户修改了商户主体名称、法人名称、超级管理员信息、主体类型等信息，则需重新签约
     */
    SIGNED,
    /**
     * 不可签约。该状态下，暂不支持超级管理员签约。一般为申请单处于已驳回、已冻结、机器校验中状态，无法签约
     */
    NOT_SIGNABLE
}
