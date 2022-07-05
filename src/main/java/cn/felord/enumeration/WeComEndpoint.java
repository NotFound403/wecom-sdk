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
     * 更新部门，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90206">文档</a>
     */
    DEPT_UPDATE("/department/update"),
    /**
     * 删除部门，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90207">文档</a>
     */
    DEPT_DELETE("/department/delete"),
    /**
     * 获取部门列表，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90208">文档</a>
     */
    DEPT_LIST("/department/list"),
    /**
     * 创建标签，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90210">文档</a>
     */
    TAG_CREATE("/tag/create"),
    /**
     * 更新标签名字，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90211">文档</a>
     */
    TAG_UPDATE("/tag/update"),
    /**
     * 删除标签，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90212">文档</a>
     */
    TAG_DELETE("/tag/delete"),
    /**
     * 获取标签成员，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90213">文档</a>
     */
    TAG_GET_USERS("/tag/get"),
    /**
     * 增加标签成员，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90214">文档</a>
     */
    TAG_CREATE_USERS("/tag/addtagusers"),
    /**
     * 删除标签成员，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90215">文档</a>
     */
    TAG_DELETE_USERS("/tag/deltagusers"),
    /**
     * 获取标签列表，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90216">文档</a>
     */
    TAG_LIST("/tag/list"),
    /**
     * 增量更新成员，详见<a target= "_blank" href= "https://open.work.weixin.qq.com/api/doc/90000/90135/90980">文档</a>
     */
    BATCH_SYNC_USER("/batch/syncuser"),
    /**
     * 全量覆盖成员，详见<a target= "_blank" href= "https://open.work.weixin.qq.com/api/doc/90000/90135/90981">文档</a>
     */
    BATCH_REPLACE_USER("/batch/replaceuser"),
    /**
     * 全量覆盖部门，详见<a target= "_blank" href= "https://open.work.weixin.qq.com/api/doc/90000/90135/90982">文档</a>
     */
    BATCH_REPLACE_PARTY("/batch/replaceparty"),
    /**
     * 获取异步任务结果，详见<a target= "_blank" href= "https://open.work.weixin.qq.com/api/doc/90000/90135/90983">文档</a>
     */
    BATCH_GET_RESULT("/batch/getresult"),
    /**
     * 获取企业微信API域名IP段，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/92520">文档</a>
     */
    EX_CONTACTS("/externalcontact/list"),
    /**
     * 上传临时素材，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90253">文档</a>
     */
    MEDIA_UPLOAD("/media/upload"),
    /**
     * 上传永久图片，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90253">文档</a>
     */
    MEDIA_UPLOAD_IMG("/media/uploadimg"),
    /**
     * 获取企业微信API域名IP段，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/92520">文档</a>
     */
    WEBHOOK_SEND("/webhook/send"),
    /**
     * 获取企业的jsapi_ticket.
     */
    CORP_JSAPI_TICKET("/get_jsapi_ticket"),

    /**
     * 获取应用的jsapi_ticket.
     */
    AGENT_JSAPI_TICKET("/ticket/get");
    private final String pattern;

    WeComEndpoint(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Endpoint string.
     *
     * @return the string
     */
    public String endpoint() {
        return "https://qyapi.weixin.qq.com/cgi-bin" + pattern;
    }
}
