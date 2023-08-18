package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.MemberCardFieldType;
import lombok.Data;

/**
 * 自定义会员信息类目
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class CustomField {
    /**
     * 会员信息类目半自定义名称，
     * 当开发者变更这类类目信息的value值时 可以选择触发系统模板消息通知用户
     */
    private MemberCardFieldType nameType;
    /**
     * 会员信息类目自定义名称，
     * 当开发者变更这类类目信息的value值时 不会触发系统模板消息通知用户
     */
    private String name;
    /**
     * 点击类目跳转外链url
     */
    private String url;
}