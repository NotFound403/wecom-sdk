/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.enumeration;

import cn.felord.callbacks.EventEnumConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 回调事件
 *
 * @author felord.cn
 * @since 2021/6/10
 */
@XStreamConverter(EventEnumConverter.class)
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
    UPLOAD_MEDIA_JOB_FINISH("upload_media_job_finish");

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
