package cn.felord.enumeration;

/**
 * The enum We com endpoint.
 *
 * @author n1
 * @since 2021 /6/16 14:19
 */
public enum WeComEndpoint {
    /**
     * 获取access_token，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/91039">文档</a>
     */
    GET_TOKEN("/gettoken"),
    /**
     * 获取企业微信API域名IP段，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/92520">文档</a>
     */
    DOMAIN_IP("/get_api_domain_ip"),
    /**
     * 创建成员，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90195">文档</a>
     */
    USER_CREATE("/user/create"),
    /**
     * 获取成员信息，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90196">文档</a>
     */
    USER_GET("/user/get"),
    /**
     * 更新成员，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90197">文档</a>
     */
    USER_UPDATE("/user/update"),
    /**
     * 删除成员，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90198">文档</a>
     */
    USER_DELETE("/user/delete"),
    /**
     * 批量删除成员，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90199">文档</a>
     */
    USER_BATCH_DELETE("/user/batchdelete"),
    /**
     * 获取部门成员，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90200">文档</a>
     */
    USER_DEPT_LIST("/user/simplelist"),
    /**
     * 获取部门成员详情，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90201">文档</a>
     */
    USER_DEPT_LIST_DETAIL("/user/list"),
    /**
     * userid与openid互换，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90202">文档</a>
     */
    USERID_TO_OPENID("/user/convert_to_openid"),
    /**
     * 二次验证，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90203">文档</a>
     */
    USER_AUTH("/user/authsucc"),
    /**
     * 邀请成员，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90975">文档</a>
     */
    USER_BATCH_INVITE("/batch/invite"),
    /**
     * 获取加入企业二维码，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/91714">文档</a>
     */
    USER_JOIN_QRCODE("/corp/get_join_qrcode"),
    /**
     * 获取企业活跃成员数，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/92714">文档</a>
     */
    USER_ACTIVE_STAT("/user/get_active_stat"),
    /**
     * 创建部门，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90205">文档</a>
     */
    DEPT_CREATE("/department/create"),
    /**
     * 获取企业微信API域名IP段，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/92520">文档</a>
     */
    EX_CONTACTS("/externalcontact/list"),
    /**
     * 获取企业微信API域名IP段，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/92520">文档</a>
     */
    WEBHOOK_SEND("/webhook/send");
    private final String pattern;

    WeComEndpoint(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Endpoint string.
     *
     * @param weComDomain the we com domain
     * @return the string
     */
    public String endpoint(WeComDomain weComDomain) {
        return weComDomain.domain() + pattern;
    }
}
