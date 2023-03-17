package cn.felord.enumeration;

/**
 * The enum We com endpoint.
 *
 * @author n1
 * @since 2021 /6/16 14:19
 */
public enum WeComEndpoint {

    /**
     * 获取第三方应用凭证
     */
    SERVICE_GET_SUITE_TOKEN("/service/get_suite_token"),
    /**
     * 获取企业access_token
     */
    SERVICE_GET_CORP_TOKEN("/service/get_corp_token"),
    /**
     * 获取服务商凭证
     */
    SERVICE_GET_PROVIDER_TOKEN("/service/get_provider_token"),
    /**
     * corpid的转换
     */
    SERVICE_CORPID_TO_OPENCORPID("/service/corpid_to_opencorpid"),
    /**
     * 获取access_token
     */
    GET_TOKEN("/gettoken"),
    /**
     * 创建成员
     */
    USER_CREATE("/user/create"),
    /**
     * 获取成员信息
     */
    USER_GET("/user/get"),
    /**
     * 更新成员
     */
    USER_UPDATE("/user/update"),
    /**
     * 删除成员
     */
    USER_DELETE("/user/delete"),
    /**
     * 获取成员ID列表
     */
    USER_LIST_ID("/user/list_id"),
    /**
     * 获取访问用户身份
     */
    USER_AUTH_BY_CODE("/auth/getuserinfo"),
    /**
     * 获取访问用户敏感信息
     */
    USER_DETAIL_BY_USER_TICKET("/auth/getuserdetail"),
    /**
     * 批量删除成员
     */
    USER_BATCH_DELETE("/user/batchdelete"),
    /**
     * 获取部门成员
     */
    USER_DEPT_LIST("/user/simplelist"),
    /**
     * 获取部门成员详情
     */
    USER_DEPT_LIST_DETAIL("/user/list"),
    /**
     * userid与openid互换
     */
    USERID_TO_OPENID("/user/convert_to_openid"),
    /**
     * 二次验证
     */
    USER_AUTH("/user/authsucc"),
    /**
     * 邀请成员
     */
    USER_BATCH_INVITE("/batch/invite"),
    /**
     * 获取加入企业二维码
     */
    USER_JOIN_QRCODE("/corp/get_join_qrcode"),
    /**
     * 手机号获取userid
     */
    USER_ID_BY_MOBILE("/user/getuserid"),
    /**
     * email获取userid
     */
    USER_ID_BY_EMAIL("/user/get_userid_by_email"),
    /**
     * 创建部门
     */
    DEPT_CREATE("/department/create"),
    /**
     * 更新部门
     */
    DEPT_UPDATE("/department/update"),
    /**
     * 删除部门
     */
    DEPT_DELETE("/department/delete"),
    /**
     * 获取部门列表
     */
    DEPT_LIST("/department/list"),
    /**
     * 获取子部门ID列表
     */
    DEPT_SIMPLE_LIST("/department/simplelist"),
    /**
     * 获取单个部门详情
     */
    DEPT_GET("/department/get"),
    /**
     * 创建标签
     */
    TAG_CREATE("/tag/create"),
    /**
     * 更新标签名字
     */
    TAG_UPDATE("/tag/update"),
    /**
     * 删除标签
     */
    TAG_DELETE("/tag/delete"),
    /**
     * 获取标签成员
     */
    TAG_GET_USERS("/tag/get"),
    /**
     * 增加标签成员
     */
    TAG_CREATE_USERS("/tag/addtagusers"),
    /**
     * 删除标签成员
     */
    TAG_DELETE_USERS("/tag/deltagusers"),
    /**
     * 获取标签列表
     */
    TAG_LIST("/tag/list"),
    /**
     * 增量更新成员
     */
    BATCH_SYNC_USER("/batch/syncuser"),
    /**
     * 全量覆盖成员
     */
    BATCH_REPLACE_USER("/batch/replaceuser"),
    /**
     * 全量覆盖部门
     */
    BATCH_REPLACE_PARTY("/batch/replaceparty"),
    /**
     * 获取异步任务结果
     */
    BATCH_GET_RESULT("/batch/getresult"),
    /**
     * 获取企业微信API域名IP段
     */
    API_DOMAIN_IP("/get_api_domain_ip"),
    /**
     * 获取企业微信服务器的ip段
     */
    CALLBACK_IP("/getcallbackip"),
    /**
     * 自建应用与第三方应用的对接
     */
    OPENUSERID_TO_USERID("/batch/openuserid_to_userid"),
    /**
     * 获取应用的可见范围
     */
    LINKED_CORP_PERM_LIST("/linkedcorp/agent/get_perm_list"),
    /**
     * 获取互联企业成员详细信息
     */
    LINKED_CORP_USER("/linkedcorp/user/get"),
    /**
     * 获取互联企业部门成员
     */
    LINKED_CORP_USER_SIMPLELIST("/linkedcorp/user/simplelist"),
    /**
     * 获取互联企业部门列表
     */
    LINKED_CORP_DEPT_LIST("/linkedcorp/department/list"),
    /**
     * 获取配置了客户联系功能的成员列表
     */
    EXTERNALCONTACT_FOLLOW_USER_LIST("/externalcontact/get_follow_user_list"),
    /**
     * 配置客户联系「联系我」方式
     */
    EXTERNALCONTACT_ADD_CONTACT_WAY("/externalcontact/add_contact_way"),
    /**
     * 获取企业已配置的「联系我」方式
     */
    EXTERNALCONTACT_GET_CONTACT_WAY("/externalcontact/get_contact_way"),
    /**
     * 获取企业已配置的「联系我」列表
     */
    EXTERNALCONTACT_LIST_CONTACT_WAY("/externalcontact/list_contact_way"),
    /**
     * 更新企业已配置的「联系我」方式
     */
    EXTERNALCONTACT_UPDATE_CONTACT_WAY("/externalcontact/update_contact_way"),
    /**
     * 更新企业已配置的「联系我」方式
     */
    EXTERNALCONTACT_DEL_CONTACT_WAY("/externalcontact/del_contact_way"),
    /**
     * 结束临时会话
     */
    EXTERNALCONTACT_CLOSE_TEMP_CHAT("/externalcontact/close_temp_chat"),
    /**
     * 获取客户列表
     */
    EXTERNALCONTACT_LIST_USERID("/externalcontact/list"),
    /**
     * 获取客户详情
     */
    EXTERNALCONTACT_GET_USERID("/externalcontact/get"),
    /**
     * 批量获取客户详情
     */
    EXTERNALCONTACT_BATCH_USERID("/externalcontact/batch/get_by_user"),
    /**
     * 修改客户备注信息
     */
    EXTERNALCONTACT_REMARK("/externalcontact/remark"),
    /**
     * 获取规则组列表
     */
    CUSTOMER_STRATEGY_LIST("/externalcontact/customer_strategy/list"),
    /**
     * 获取规则组详情
     */
    CUSTOMER_STRATEGY_GET("/externalcontact/customer_strategy/get"),
    /**
     * 获取规则组管理范围
     */
    CUSTOMER_STRATEGY_GET_RANGE("/externalcontact/customer_strategy/get_range"),
    /**
     * 创建新的规则组
     */
    CUSTOMER_STRATEGY_CREATE("/externalcontact/customer_strategy/create"),
    /**
     * 编辑规则组及其管理范围
     */
    CUSTOMER_STRATEGY_EDIT("/externalcontact/customer_strategy/edit"),
    /**
     * 删除规则组
     */
    CUSTOMER_STRATEGY_DEL("/externalcontact/customer_strategy/del"),
    /**
     * 获取企业标签库
     */
    CORP_TAG_LIST("/externalcontact/get_corp_tag_list"),
    /**
     * 添加企业客户标签
     */
    CORP_TAG_ADD("/externalcontact/add_corp_tag"),
    /**
     * 编辑企业客户标签
     */
    CORP_TAG_EDIT("/externalcontact/edit_corp_tag"),
    /**
     * 删除企业客户标签
     */
    CORP_TAG_DEL("/externalcontact/del_corp_tag"),
    /**
     * 获取指定规则组下的企业客户标签
     */
    CORP_TAG_STRATEGY_LIST("/externalcontact/get_strategy_tag_list"),
    /**
     * 为指定规则组创建企业客户标签
     */
    CORP_TAG_STRATEGY_ADD("/externalcontact/add_strategy_tag"),
    /**
     * 编辑指定规则组下的企业客户标签
     */
    CORP_TAG_STRATEGY_EDIT("/externalcontact/edit_strategy_tag"),
    /**
     * 删除指定规则组下的企业客户标签
     */
    CORP_TAG_STRATEGY_DEL("/externalcontact/del_strategy_tag"),
    /**
     * 编辑客户企业标签
     */
    CORP_TAG_MARK("/externalcontact/mark_tag"),
    /**
     * 分配在职成员的客户
     */
    TRANSFER_CUSTOMER("/externalcontact/transfer_customer"),
    /**
     * 查询客户接替状态
     */
    TRANSFER_RESULT("/externalcontact/transfer_result"),
    /**
     * 分配在职成员的客户群
     */
    TRANSFER_GROUP_CHAT("/externalcontact/groupchat/onjob_transfer"),
    /**
     * 获取待分配的离职成员列表
     */
    UNASSIGNED_LIST("/externalcontact/get_unassigned_list"),
    /**
     * 分配离职成员的客户
     */
    OFF_TRANSFER_CUSTOMER("/externalcontact/resigned/transfer_customer"),
    /**
     * 查询离职成员客户接替状态
     */
    OFF_TRANSFER_RESULT("/externalcontact/resigned/transfer_result"),
    /**
     * 分配离职成员的客户群
     */
    OFF_TRANSFER_GROUP_CHAT("/externalcontact/groupchat/transfer"),
    /**
     * 获取客户群列表
     */
    GROUP_CHAT_LIST("/externalcontact/groupchat/list"),
    /**
     * 获取客户群详情
     */
    GROUP_CHAT_GET("/externalcontact/groupchat/get"),
    /**
     * 客户群opengid转换
     */
    OPENGID_TO_CHATID("/externalcontact/opengid_to_chatid"),
    /**
     * 配置客户群进群方式
     */
    GROUP_CHAT_ADD_JOIN_WAY("/externalcontact/groupchat/add_join_way"),
    /**
     * 获取客户群进群方式配置
     */
    GROUP_CHAT_GET_JOIN_WAY("/externalcontact/groupchat/get_join_way"),
    /**
     * 更新客户群进群方式配置
     */
    GROUP_CHAT_UPDATE_JOIN_WAY("/externalcontact/groupchat/update_join_way"),
    /**
     * 删除客户群进群方式配置
     */
    GROUP_CHAT_DEL_JOIN_WAY("/externalcontact/groupchat/del_join_way"),
    /**
     * 创建发表任务
     */
    MOMENT_TASK_ADD("/externalcontact/add_moment_task"),
    /**
     * 获取任务创建结果
     */
    MOMENT_TASK_JOB_RESULT("/externalcontact/get_moment_task_result"),
    /**
     * 获取企业全部的发表列表
     */
    MOMENT_LIST("/externalcontact/get_moment_list"),
    /**
     * 获取客户朋友圈企业发表的列表
     */
    MOMENT_TASK_GET("/externalcontact/get_moment_task"),
    /**
     * 获取客户朋友圈发表时选择的可见范围
     */
    MOMENT_CUSTOMER_LIST("/externalcontact/get_moment_customer_list"),
    /**
     * 获取客户朋友圈发表后的可见客户列表
     */
    MOMENT_SEND_RESULT("/externalcontact/get_moment_send_result"),
    /**
     * 停止发表企业朋友圈
     */
    CANCEL_MOMENT_TASK("/externalcontact/cancel_moment_task"),
    /**
     * 获取客户朋友圈的互动数据
     */
    MOMENT_COMMENTS("/externalcontact/get_moment_comments"),
    /**
     * 获取客户朋友圈规则组列表
     */
    MOMENT_STRATEGY_LIST("/externalcontact/moment_strategy/list"),
    /**
     * 获取客户朋友圈规则组详情
     */
    MOMENT_STRATEGY_GET("/externalcontact/moment_strategy/get"),
    /**
     * 获取客户朋友圈管理范围
     */
    MOMENT_STRATEGY_RANGE("/externalcontact/moment_strategy/get_range"),
    /**
     * 创建新的客户朋友圈规则组
     */
    MOMENT_STRATEGY_CREATE("/externalcontact/moment_strategy/create"),
    /**
     * 编辑客户朋友圈规则组及其管理范围
     */
    MOMENT_STRATEGY_EDIT("/externalcontact/moment_strategy/edit"),
    /**
     * 删除客户朋友圈规则组
     */
    MOMENT_STRATEGY_DEL("/externalcontact/moment_strategy/del"),
    /**
     * 创建企业群发
     */
    GROUP_MSG_ADD("/externalcontact/add_msg_template"),
    /**
     * 提醒成员群发
     */
    REMIND_GROUPMSG_SEND("/externalcontact/remind_groupmsg_send"),
    /**
     * 停止企业群发
     */
    CANCEL_GROUPMSG_SEND("/externalcontact/cancel_groupmsg_send"),
    /**
     * 获取群发记录列表
     */
    GROUP_MSG_LIST_V2("/externalcontact/get_groupmsg_list_v2"),
    /**
     * 获取群发成员发送任务列表
     */
    GROUP_MSG_TASK("/externalcontact/get_groupmsg_task"),
    /**
     * 获取企业群发成员执行结果
     */
    GROUP_MSG_SEND_RESULT("/externalcontact/get_groupmsg_send_result"),
    /**
     * 发送新客户欢迎语
     */
    GROUP_MSG_SEND_WELCOME("/externalcontact/send_welcome_msg"),
    /**
     * 添加入群欢迎语素材
     */
    GROUP_MSG_WELCOME_TEMPLATE_ADD("/externalcontact/group_welcome_template/add"),
    /**
     * 修改入群欢迎语素材
     */
    GROUP_MSG_WELCOME_TEMPLATE_EDIT("/externalcontact/group_welcome_template/edit"),
    /**
     * 获取入群欢迎语素材
     */
    GROUP_MSG_WELCOME_TEMPLATE_GET("/externalcontact/group_welcome_template/get"),
    /**
     * 删除入群欢迎语素材
     */
    GROUP_MSG_WELCOME_TEMPLATE_DEL("/externalcontact/group_welcome_template/del"),
    /**
     * 获取「联系客户统计」数据
     */
    STATISTIC_USER_BEHAVIOR_DATA("/externalcontact/get_user_behavior_data"),
    /**
     * 获取「群聊数据统计」数据-按群主聚合的方式
     */
    STATISTIC_GROUP_CHAT_BY_OWNER("/externalcontact/groupchat/statistic"),
    /**
     * 获取「群聊数据统计」数据-按自然日聚合的方式
     */
    STATISTIC_GROUP_CHAT_BY_DAY("/externalcontact/groupchat/statistic_group_by_day"),
    /**
     * 创建商品图册
     */
    PRODUCT_ALBUM_CREATE("/externalcontact/add_product_album"),
    /**
     * 获取商品图册
     */
    PRODUCT_ALBUM_GET("/externalcontact/get_product_album"),
    /**
     * 获取商品图册列表
     */
    PRODUCT_ALBUM_LIST("/externalcontact/get_product_album_list"),
    /**
     * 编辑商品图册
     */
    PRODUCT_ALBUM_EDIT("/externalcontact/update_product_album"),
    /**
     * 获取商品图册列表
     */
    PRODUCT_ALBUM_DEL("/externalcontact/delete_product_album"),
    /**
     * 新建敏感词规则
     */
    INTERCEPT_RULE_CREATE("/externalcontact/add_intercept_rule"),
    /**
     * 获取敏感词规则列表
     */
    INTERCEPT_RULE_LIST("/externalcontact/get_intercept_rule_list"),
    /**
     * 获取敏感词规则详情
     */
    INTERCEPT_RULE_GET("/externalcontact/get_intercept_rule"),
    /**
     * 修改敏感词规则
     */
    INTERCEPT_RULE_UPDATE("/externalcontact/update_intercept_rule"),
    /**
     * 删除敏感词规则
     */
    INTERCEPT_RULE_DEL("/externalcontact/del_intercept_rule"),
    /**
     * 外部联系人openid转换
     */
    EXTERNAL_USER_TO_OPENID("/externalcontact/convert_to_openid"),
    /**
     * 添加客服账号
     */
    KF_ACCOUNT_CREATE("/kf/account/add"),
    /**
     * 删除客服账号
     */
    KF_ACCOUNT_DEL("/kf/account/del"),
    /**
     * 修改客服账号
     */
    KF_ACCOUNT_UPDATE("/kf/account/update"),
    /**
     * 获取客服账号列表
     */
    KF_ACCOUNT_LIST("/kf/account/list"),
    /**
     * 获取客服账号链接
     */
    KF_ADD_CONTACT_WAY("/kf/add_contact_way"),
    /**
     * 添加接待人员
     */
    KF_SERVICER_CREATE("/kf/servicer/add"),
    /**
     * 删除接待人员
     */
    KF_SERVICER_DEL("/kf/servicer/del"),
    /**
     * 获取接待人员列表
     */
    KF_SERVICER_LIST("/kf/servicer/list"),
    /**
     * 获取会话状态
     */
    KF_SERVICE_STATE_GET("/kf/service_state/get"),
    /**
     * 变更会话状态
     */
    KF_SERVICE_STATE_TRANS("/kf/service_state/trans"),
    /**
     * 读取消息
     */
    KF_SYNC_MSG("/kf/sync_msg"),
    /**
     * 创建日历
     */
    OA_CALENDAR_ADD("/oa/calendar/add"),
    /**
     * 更新日历
     */
    OA_CALENDAR_UPDATE("/oa/calendar/update"),
    /**
     * 获取日历详情
     */
    OA_CALENDAR_GET("/oa/calendar/get"),
    /**
     * 删除日历
     */
    OA_CALENDAR_DEL("/oa/calendar/update"),
    /**
     * 创建日程
     */
    OA_SCHEDULE_ADD("/oa/schedule/add"),
    /**
     * 更新日程
     */
    OA_SCHEDULE_UPDATE("/oa/schedule/update"),
    /**
     * 新增日程参与者
     */
    OA_SCHEDULE_ADD_ATTENDEES("/oa/schedule/add_attendees"),
    /**
     * 删除日程参与者
     */
    OA_SCHEDULE_DEL_ATTENDEES("/oa/schedule/del_attendees"),
    /**
     * 获取日程详情
     */
    OA_SCHEDULE_GET("/oa/schedule/get"),
    /**
     * 取消日程
     */
    OA_SCHEDULE_DEL("/oa/schedule/del"),
    /**
     * 获取日历下的日程列表
     */
    OA_SCHEDULE_BY_CALENDAR("/oa/schedule/get_by_calendar"),
    /**
     * 上传临时素材
     */
    MEDIA_UPLOAD("/media/upload"),
    /**
     * 获取临时素材
     */
    MEDIA_GET("/media/get"),
    /**
     * 上传永久图片
     */
    MEDIA_UPLOAD_IMG("/media/uploadimg"),
    /**
     * 上传附件资源
     */
    MEDIA_UPLOAD_ATTACHMENT("/media/upload_attachment"),
    /**
     * 生成异步上传任务
     */
    MEDIA_UPLOAD_BY_URL("/media/upload_by_url"),
    /**
     * 企业微信 Webhook API
     */
    WEBHOOK_SEND("/webhook/send"),
    /**
     * 企业微信 Webhook 上传 API
     */
    WEBHOOK_UPLOAD("/webhook/upload_media"),
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
    AGENT_SETTINGS("/agent/set"),
    /**
     * 发送应用消息
     */
    MESSAGE_SEND("/message/send"),
    /**
     * 更新模版卡片消息
     */
    UPDATE_TEMPLATE_CARD("/message/update_template_card"),
    /**
     * 撤回应用消息
     */
    MESSAGE_RECALL("/message/recall"),
    /**
     * 创建收集表
     */
    WEDOC_CREATE_FORM("/wedoc/create_form"),
    /**
     * 编辑收集表
     */
    WEDOC_MODIFY_FORM("/wedoc/modify_form"),
    /**
     * 获取收集表信息
     */
    WEDOC_GET_FORM("/wedoc/get_form_info"),
    /**
     * 收集表的统计信息查询
     */
    WEDOC_FORM_STATISTIC("/wedoc/get_form_statistic"),
    /**
     * 读取收集表答案
     */
    WEDOC_FORM_ANSWER("/wedoc/get_form_answer");

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
