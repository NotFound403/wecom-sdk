package cn.felord.enumeration;

/**
 * The enum We com endpoint.
 *
 * @author n1
 * @since 2021 /6/16 14:19
 */
public enum WeComEndpoint {

    /**
     * 获取第三方应用凭证，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/10975#%E8%8E%B7%E5%8F%96%E7%AC%AC%E4%B8%89%E6%96%B9%E5%BA%94%E7%94%A8%E5%87%AD%E8%AF%81">文档</a>
     */
    SERVICE_GET_SUITE_TOKEN("/service/get_suite_token"),
    /**
     * 获取企业access_token，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/10975#%E8%8E%B7%E5%8F%96%E4%BC%81%E4%B8%9Aaccess-token">文档</a>
     */
    SERVICE_GET_CORP_TOKEN("/service/get_corp_token"),
    /**
     * 获取服务商凭证，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/91200">文档</a>
     */
    SERVICE_GET_PROVIDER_TOKEN("/service/get_provider_token"),
    /**
     * corpid的转换，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/97061">文档</a>
     */
    SERVICE_CORPID_TO_OPENCORPID("/service/corpid_to_opencorpid"),
    /**
     * 获取access_token，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/91039">文档</a>
     */
    GET_TOKEN("/gettoken"),
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
     * 获取成员ID列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/96067">文档</a>
     */
    USER_LIST_ID("/user/list_id"),
    /**
     * 获取访问用户身份，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/91023">文档</a>
     */
    USER_AUTH_BY_CODE("/auth/getuserinfo"),
    /**
     * 获取访问用户敏感信息，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95833">文档</a>
     */
    USER_DETAIL_BY_USER_TICKET("/auth/getuserdetail"),
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
     * 二次验证，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/90339">文档</a>
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
     * 手机号获取userid，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95402">文档</a>
     */
    USER_ID_BY_MOBILE("/user/getuserid"),
    /**
     * email获取userid，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95895">文档</a>
     */
    USER_ID_BY_EMAIL("/user/get_userid_by_email"),
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
     * 获取子部门ID列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95350">文档</a>
     */
    DEPT_SIMPLE_LIST("/department/simplelist"),
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
     * 获取企业微信API域名IP段，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92520">文档</a>
     */
    API_DOMAIN_IP("/get_api_domain_ip"),
    /**
     * 获取企业微信服务器的ip段，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/91116#33-%E8%8E%B7%E5%8F%96%E4%BC%81%E4%B8%9A%E5%BE%AE%E4%BF%A1%E6%9C%8D%E5%8A%A1%E5%99%A8%E7%9A%84ip%E6%AE%B5">文档</a>
     */
    CALLBACK_IP("/getcallbackip"),
    /**
     * 自建应用与第三方应用的对接，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95884">文档</a>
     */
    OPENUSERID_TO_USERID("/batch/openuserid_to_userid"),
    /**
     * 获取应用的可见范围，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93172">文档</a>
     */
    LINKED_CORP_PERM_LIST("/linkedcorp/agent/get_perm_list"),
    /**
     * 获取互联企业成员详细信息，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93171">文档</a>
     */
    LINKED_CORP_USER("/linkedcorp/user/get"),
    /**
     * 获取互联企业部门成员，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93168">文档</a>
     */
    LINKED_CORP_USER_SIMPLELIST("/linkedcorp/user/simplelist"),
    /**
     * 获取互联企业部门列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93170">文档</a>
     */
    LINKED_CORP_DEPT_LIST("/linkedcorp/department/list"),
    /**
     * 获取配置了客户联系功能的成员列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92571">文档</a>
     */
    EXTERNALCONTACT_FOLLOW_USER_LIST("/externalcontact/get_follow_user_list"),
    /**
     * 配置客户联系「联系我」方式，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92572">文档</a>
     */
    EXTERNALCONTACT_ADD_CONTACT_WAY("/externalcontact/add_contact_way"),
    /**
     * 获取企业已配置的「联系我」方式，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92572">文档</a>
     */
    EXTERNALCONTACT_GET_CONTACT_WAY("/externalcontact/get_contact_way"),
    /**
     * 获取企业已配置的「联系我」列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92572">文档</a>
     */
    EXTERNALCONTACT_LIST_CONTACT_WAY("/externalcontact/list_contact_way"),
    /**
     * 更新企业已配置的「联系我」方式，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92572">文档</a>
     */
    EXTERNALCONTACT_UPDATE_CONTACT_WAY("/externalcontact/update_contact_way"),
    /**
     * 更新企业已配置的「联系我」方式，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92572">文档</a>
     */
    EXTERNALCONTACT_DEL_CONTACT_WAY("/externalcontact/del_contact_way"),
    /**
     * 结束临时会话，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92572">文档</a>
     */
    EXTERNALCONTACT_CLOSE_TEMP_CHAT("/externalcontact/close_temp_chat"),
    /**
     * 获取客户列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92264">文档</a>
     */
    EXTERNALCONTACT_LIST_USERID("/externalcontact/list"),
    /**
     * 获取客户详情，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92114">文档</a>
     */
    EXTERNALCONTACT_GET_USERID("/externalcontact/get"),
    /**
     * 批量获取客户详情，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92994">文档</a>
     */
    EXTERNALCONTACT_BATCH_USERID("/externalcontact/batch/get_by_user"),
    /**
     * 修改客户备注信息，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92115">文档</a>
     */
    EXTERNALCONTACT_REMARK("/externalcontact/remark"),
    /**
     * 获取规则组列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94883">文档</a>
     */
    CUSTOMER_STRATEGY_LIST("/externalcontact/customer_strategy/list"),
    /**
     * 获取规则组详情，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94883">文档</a>
     */
    CUSTOMER_STRATEGY_GET("/externalcontact/customer_strategy/get"),
    /**
     * 获取规则组管理范围，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94883">文档</a>
     */
    CUSTOMER_STRATEGY_GET_RANGE("/externalcontact/customer_strategy/get_range"),
    /**
     * 创建新的规则组，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94883">文档</a>
     */
    CUSTOMER_STRATEGY_CREATE("/externalcontact/customer_strategy/create"),
    /**
     * 编辑规则组及其管理范围，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94883">文档</a>
     */
    CUSTOMER_STRATEGY_EDIT("/externalcontact/customer_strategy/edit"),
    /**
     * 删除规则组，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94883">文档</a>
     */
    CUSTOMER_STRATEGY_DEL("/externalcontact/customer_strategy/del"),
    /**
     * 获取企业标签库，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92117">文档</a>
     */
    CORP_TAG_LIST("/externalcontact/get_corp_tag_list"),
    /**
     * 添加企业客户标签，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92117">文档</a>
     */
    CORP_TAG_ADD("/externalcontact/add_corp_tag"),
    /**
     * 编辑企业客户标签，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92117">文档</a>
     */
    CORP_TAG_EDIT("/externalcontact/edit_corp_tag"),
    /**
     * 删除企业客户标签，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92117">文档</a>
     */
    CORP_TAG_DEL("/externalcontact/del_corp_tag"),
    /**
     * 获取指定规则组下的企业客户标签，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94882">文档</a>
     */
    CORP_TAG_STRATEGY_LIST("/externalcontact/get_strategy_tag_list"),
    /**
     * 为指定规则组创建企业客户标签，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94882">文档</a>
     */
    CORP_TAG_STRATEGY_ADD("/externalcontact/add_strategy_tag"),
    /**
     * 编辑指定规则组下的企业客户标签，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94882">文档</a>
     */
    CORP_TAG_STRATEGY_EDIT("/externalcontact/edit_strategy_tag"),
    /**
     * 删除指定规则组下的企业客户标签，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94882">文档</a>
     */
    CORP_TAG_STRATEGY_DEL("/externalcontact/del_strategy_tag"),
    /**
     * 编辑客户企业标签，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92118">文档</a>
     */
    CORP_TAG_MARK("/externalcontact/mark_tag"),
    /**
     * 分配在职成员的客户，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92125">文档</a>
     */
    TRANSFER_CUSTOMER("/externalcontact/transfer_customer"),
    /**
     * 查询客户接替状态，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94088">文档</a>
     */
    TRANSFER_RESULT("/externalcontact/transfer_result"),
    /**
     * 分配在职成员的客户群，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95703">文档</a>
     */
    TRANSFER_GROUP_CHAT("/externalcontact/groupchat/onjob_transfer"),
    /**
     * 获取客户群列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92120">文档</a>
     */
    GROUP_CHAT_LIST("/externalcontact/groupchat/list"),
    /**
     * 获取客户群详情，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92122">文档</a>
     */
    GROUP_CHAT_GET("/externalcontact/groupchat/get"),
    /**
     * 客户群opengid转换，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94822">文档</a>
     */
    OPENGID_TO_CHATID("/externalcontact/opengid_to_chatid"),
    /**
     * 配置客户群进群方式，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92229">文档</a>
     */
    GROUP_CHAT_ADD_JOIN_WAY("/externalcontact/groupchat/add_join_way"),
    /**
     * 获取客户群进群方式配置，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92229">文档</a>
     */
    GROUP_CHAT_GET_JOIN_WAY("/externalcontact/groupchat/get_join_way"),
    /**
     * 更新客户群进群方式配置，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92229">文档</a>
     */
    GROUP_CHAT_UPDATE_JOIN_WAY("/externalcontact/groupchat/update_join_way"),
    /**
     * 删除客户群进群方式配置，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92229">文档</a>
     */
    GROUP_CHAT_DEL_JOIN_WAY("/externalcontact/groupchat/del_join_way"),
    /**
     * 创建发表任务，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95094">文档</a>
     */
    MOMENT_TASK_ADD("/externalcontact/add_moment_task"),
    /**
     * 获取任务创建结果，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95094">文档</a>
     */
    MOMENT_TASK_JOB_RESULT("/externalcontact/get_moment_task_result"),
    /**
     * 获取企业全部的发表列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93333">文档</a>
     */
    MOMENT_LIST("/externalcontact/get_moment_list"),
    /**
     * 获取客户朋友圈企业发表的列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93333">文档</a>
     */
    MOMENT_TASK_GET("/externalcontact/get_moment_task"),
    /**
     * 获取客户朋友圈发表时选择的可见范围，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93333">文档</a>
     */
    MOMENT_CUSTOMER_LIST("/externalcontact/get_moment_customer_list"),
    /**
     * 获取客户朋友圈发表后的可见客户列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93333">文档</a>
     */
    MOMENT_SEND_RESULT("/externalcontact/get_moment_send_result"),
    /**
     * 获取客户朋友圈的互动数据，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93333">文档</a>
     */
    MOMENT_COMMENTS("/externalcontact/get_moment_comments"),
    /**
     * 获取客户朋友圈规则组列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94890">文档</a>
     */
    MOMENT_STRATEGY_LIST("/externalcontact/moment_strategy/list"),
    /**
     * 获取客户朋友圈规则组详情，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94890">文档</a>
     */
    MOMENT_STRATEGY_GET("/externalcontact/moment_strategy/get"),
    /**
     * 获取客户朋友圈管理范围，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94890">文档</a>
     */
    MOMENT_STRATEGY_RANGE("/externalcontact/moment_strategy/get_range"),
    /**
     * 创建新的客户朋友圈规则组，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94890">文档</a>
     */
    MOMENT_STRATEGY_CREATE("/externalcontact/moment_strategy/create"),
    /**
     * 编辑客户朋友圈规则组及其管理范围，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94890">文档</a>
     */
    MOMENT_STRATEGY_EDIT("/externalcontact/moment_strategy/edit"),
    /**
     * 删除客户朋友圈规则组，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94890">文档</a>
     */
    MOMENT_STRATEGY_DEL("/externalcontact/moment_strategy/del"),
    /**
     * 创建企业群发，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92135">文档</a>
     */
    GROUP_MSG_ADD("/externalcontact/add_msg_template"),
    /**
     * 获取群发记录列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93338">文档</a>
     */
    GROUP_MSG_LIST_V2("/externalcontact/get_groupmsg_list_v2"),
    /**
     * 获取群发成员发送任务列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93338">文档</a>
     */
    GROUP_MSG_TASK("/externalcontact/get_groupmsg_task"),
    /**
     * 获取企业群发成员执行结果，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93338">文档</a>
     */
    GROUP_MSG_SEND_RESULT("/externalcontact/get_groupmsg_send_result"),
    /**
     * 发送新客户欢迎语，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93338">文档</a>
     */
    GROUP_MSG_SEND_WELCOME("/externalcontact/send_welcome_msg"),
    /**
     * 添加入群欢迎语素材，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92366">文档</a>
     */
    GROUP_MSG_WELCOME_TEMPLATE_ADD("/externalcontact/group_welcome_template/add"),
    /**
     * 修改入群欢迎语素材，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92366">文档</a>
     */
    GROUP_MSG_WELCOME_TEMPLATE_EDIT("/externalcontact/group_welcome_template/edit"),
    /**
     * 获取入群欢迎语素材，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92366">文档</a>
     */
    GROUP_MSG_WELCOME_TEMPLATE_GET("/externalcontact/group_welcome_template/get"),
    /**
     * 删除入群欢迎语素材，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92366">文档</a>
     */
    GROUP_MSG_WELCOME_TEMPLATE_DEL("/externalcontact/group_welcome_template/del"),
    /**
     * 获取「联系客户统计」数据，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92132">文档</a>
     */
    STATISTIC_USER_BEHAVIOR_DATA("/externalcontact/get_user_behavior_data"),
    /**
     * 获取「群聊数据统计」数据-按群主聚合的方式，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92133">文档</a>
     */
    STATISTIC_GROUP_CHAT_BY_OWNER("/externalcontact/groupchat/statistic"),
    /**
     * 获取「群聊数据统计」数据-按自然日聚合的方式，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92133">文档</a>
     */
    STATISTIC_GROUP_CHAT_BY_DAY("/externalcontact/groupchat/statistic_group_by_day"),
    /**
     * 创建商品图册，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95096">文档</a>
     */
    PRODUCT_ALBUM_CREATE("/externalcontact/add_product_album"),
    /**
     * 获取商品图册，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95096">文档</a>
     */
    PRODUCT_ALBUM_GET("/externalcontact/get_product_album"),
    /**
     * 获取商品图册列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95096">文档</a>
     */
    PRODUCT_ALBUM_LIST("/externalcontact/get_product_album_list"),
    /**
     * 编辑商品图册，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95096">文档</a>
     */
    PRODUCT_ALBUM_EDIT("/externalcontact/update_product_album"),
    /**
     * 获取商品图册列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95096">文档</a>
     */
    PRODUCT_ALBUM_DEL("/externalcontact/delete_product_album"),
    /**
     * 新建敏感词规则，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95097">文档</a>
     */
    INTERCEPT_RULE_CREATE("/externalcontact/add_intercept_rule"),
    /**
     * 获取敏感词规则列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95097">文档</a>
     */
    INTERCEPT_RULE_LIST("/externalcontact/get_intercept_rule_list"),
    /**
     * 获取敏感词规则详情，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95097">文档</a>
     */
    INTERCEPT_RULE_GET("/externalcontact/get_intercept_rule"),
    /**
     * 修改敏感词规则，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95097">文档</a>
     */
    INTERCEPT_RULE_UPDATE("/externalcontact/update_intercept_rule"),
    /**
     * 删除敏感词规则，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95097">文档</a>
     */
    INTERCEPT_RULE_DEL("/externalcontact/del_intercept_rule"),
    /**
     * 外部联系人openid转换，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/92323">文档</a>
     */
    EXTERNAL_USER_TO_OPENID("/externalcontact/convert_to_openid"),
    /**
     * 添加客服账号，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94662">文档</a>
     */
    KF_ACCOUNT_CREATE("/kf/account/add"),
    /**
     * 删除客服账号，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94663">文档</a>
     */
    KF_ACCOUNT_DEL("/kf/account/del"),
    /**
     * 修改客服账号，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94664">文档</a>
     */
    KF_ACCOUNT_UPDATE("/kf/account/update"),
    /**
     * 获取客服账号列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94661">文档</a>
     */
    KF_ACCOUNT_LIST("/kf/account/list"),
    /**
     * 获取客服账号链接，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94665">文档</a>
     */
    KF_ADD_CONTACT_WAY("/kf/add_contact_way"),
    /**
     * 添加接待人员，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94646">文档</a>
     */
    KF_SERVICER_CREATE("/kf/servicer/add"),
    /**
     * 删除接待人员，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94647">文档</a>
     */
    KF_SERVICER_DEL("/kf/servicer/del"),
    /**
     * 获取接待人员列表，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94645">文档</a>
     */
    KF_SERVICER_LIST("/kf/servicer/list"),
    /**
     * 获取会话状态，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94669">文档</a>
     */
    KF_SERVICE_STATE_GET("/kf/service_state/get"),
    /**
     * 变更会话状态，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94669">文档</a>
     */
    KF_SERVICE_STATE_TRANS("/kf/service_state/trans"),
    /**
     * 读取消息，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/94670">文档</a>
     */
    KF_SYNC_MSG("/kf/sync_msg"),
    /**
     * 创建日程，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/93648#%E5%88%9B%E5%BB%BA%E6%97%A5%E7%A8%8B">文档</a>
     */
    OA_SCHEDULE_ADD("/oa/schedule/add"),
    /**
     * 上传临时素材，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/90253">文档</a>
     */
    MEDIA_UPLOAD("/media/upload"),
    /**
     * 获取临时素材，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/90254">文档</a>
     */
    MEDIA_GET("/media/get"),
    /**
     * 上传永久图片，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90253">文档</a>
     */
    MEDIA_UPLOAD_IMG("/media/uploadimg"),
    /**
     * 上传附件资源，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/95098">文档</a>
     */
    MEDIA_UPLOAD_ATTACHMENT("/media/upload_attachment"),
    /**
     * 生成异步上传任务，详见<a target= "_blank" href= "https://developer.work.weixin.qq.com/document/path/96219">文档</a>
     */
    MEDIA_UPLOAD_BY_URL("/media/upload_by_url"),
    /**
     * 企业微信 Webhook API，详见<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/92520">文档</a>
     */
    WEBHOOK_SEND("/webhook/send"),
    /**
     * 获取企业的jsapi_ticket.
     */
    CORP_JSAPI_TICKET("/get_jsapi_ticket"),

    /**
     * 获取应用的jsapi_ticket.
     */
    AGENT_JSAPI_TICKET("/ticket/get"),
    /**
     * 获取指定的应用详情.
     */
    AGENT_DETAILS("/agent/get"),
    /**
     * 设置应用.
     */
    AGENT_SETTINGS("/agent/set");
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
