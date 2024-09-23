/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.enumeration;


import cn.felord.xml.convert.CallbackEventConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 回调事件
 *
 * @author felord.cn
 * @since 2021 /6/10
 */
@XStreamConverter(CallbackEventConverter.class)
public enum CallbackEvent {
    /**
     * 通讯录变更事件
     */
    CHANGE_CONTACT("change_contact"),
    /**
     * 客户变更事件
     */
    CHANGE_EXTERNAL_CONTACT("change_external_contact"),
    /**
     * 客户群变更事件
     */
    CHANGE_EXTERNAL_CHAT("change_external_chat"),
    /**
     * 企业客户标签变更事件
     */
    CHANGE_EXTERNAL_TAG("change_external_tag"),
    /**
     * 获客助手事件
     */
    CUSTOMER_ACQUISITION("customer_acquisition"),
    /**
     * <a href="https://developer.work.weixin.qq.com/document/path/90240#%E6%A8%A1%E6%9D%BF%E5%8D%A1%E7%89%87%E4%BA%8B%E4%BB%B6%E6%8E%A8%E9%80%81">模板卡片事件</a>
     */
    TEMPLATE_CARD_EVENT("template_card_event"),
    /**
     * 客服消息事件
     */
    KF_MSG_OR_EVENT("kf_msg_or_event"),
    /**
     * 客服账号授权变更事件
     */
    KF_ACCOUNT_AUTH_CHANGE("kf_account_auth_change"),
    /**
     * 文档变更事件
     */
    DOC_CHANGE("doc_change"),
    /**
     * 审批申请状态变更事件
     */
    SYS_APPROVAL_CHANGE("sys_approval_change"),
    /**
     * 自建应用审批状态变化通知回调
     */
    OPEN_APPROVAL_CHANGE("open_approval_change"),
    /**
     * 异步上传任务完成事件
     */
    UPLOAD_MEDIA_JOB_FINISH("upload_media_job_finish"),
    /**
     * 成员关注事件
     * <p>
     * 成员已经加入企业，管理员添加成员到应用可见范围(或移除可见范围)时
     */
    SUBSCRIBE("subscribe"),
    /**
     * 成员取消关注事件
     * <p>
     * 成员已经在应用可见范围，成员加入(或退出)企业时
     */
    UNSUBSCRIBE("unsubscribe"),
    /**
     * 进入应用
     * <p>
     * 本事件在成员进入企业微信的应用时触发
     */
    ENTER_AGENT("enter_agent"),
    /**
     * 上报地理位置
     * <p>
     * 成员同意上报地理位置后，每次在进入应用会话时都会上报一次地理位置。
     * 企业可以在管理端修改应用是否需要获取地理位置权限。
     */
    LOCATION("LOCATION"),
    /**
     * 异步任务完成事件推送
     * <p>
     * 本事件是成员在使用异步任务接口时，用于接收任务执行完毕的结果通知。
     */
    BATCH_JOB_RESULT("batch_job_result"),
    /**
     * 菜单事件
     * <ul>
     *     <li>成员点击自定义菜单后，企业微信会把点击事件推送给应用。</li>
     *     <li>点击菜单弹出子菜单，不会产生上报。</li>
     *     <li>企业微信iPhone1.2.2/Android1.2.2版本开始支持菜单事件，旧版本企业微信成员点击后将没有回应，应用不能正常接收到事件推送。</li>
     *     <li>自定义菜单可以在管理后台的应用设置界面配置。</li>
     * </ul>
     */
    CLICK("click"),
    /**
     * 产生会话回调事件
     */
    MSGAUDIT_NOTIFY("msgaudit_notify"),
    /**
     * 支付事件（自定义）
     */
    PAY_TRANSACTION("pay_transaction"),
    /**
     * 退款事件（自定义）
     */
    PAY_REFUND("pay_refund"),
    /**
     * 删除日历事件
     */
    DELETE_CALENDAR("delete_calendar"),
    /**
     * 修改日历事件
     */
    MODIFY_CALENDAR("modify_calendar"),
    /**
     * 修改日程事件
     */
    MODIFY_SCHEDULE("modify_schedule"),
    /**
     * 删除日程事件
     */
    DELETE_SCHEDULE("delete_schedule"),
    /**
     * 日程回执事件
     */
    RESPOND_SCHEDULE("respond_schedule"),
    /**
     * 上下游变更
     */
    CHANGE_CHAIN("change_chain"),
    /**
     * 修改设置工作台自定义开关事件推送
     */
    SWITCH_WORKBENCH_MODE("switch_workbench_mode"),
    /**
     * 直播回调事件
     */
    LIVING_STATUS_CHANGE("living_status_change"),
    /**
     * 会议室预定事件
     */
    BOOK_MEETING_ROOM("book_meeting_room"),
    /**
     * 会议室取消事件
     */
    CANCEL_MEETING_ROOM("cancel_meeting_room");

    private final String type;

    CallbackEvent(String type) {
        this.type = type;
    }

    /**
     * Event string.
     *
     * @return the string
     */
    public String type() {
        return type;
    }
}
