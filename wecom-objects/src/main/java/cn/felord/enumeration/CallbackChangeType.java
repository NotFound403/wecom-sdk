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

import cn.felord.xml.convert.CallbackChangeTypeConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 回调事件变更类型
 *
 * @author dax
 * @since 2024/7/6 8:52
 */
@XStreamConverter(CallbackChangeTypeConverter.class)
public enum CallbackChangeType {

    /**
     * 新增成员事件
     */
    CREATE_USER("create_user"),
    /**
     * 更新成员事件
     */
    UPDATE_USER("update_user"),
    /**
     * 删除成员事件
     */
    DELETE_USER("delete_user"),
    /**
     * 新增部门事件
     */
    CREATE_PARTY("create_party"),
    /**
     * 更新部门事件
     */
    UPDATE_PARTY("update_party"),
    /**
     * 删除部门事件
     */
    DELETE_PARTY("delete_party"),
    /**
     * 标签变更通知
     */
    UPDATE_TAG("update_tag"),
    /**
     * 异步任务完成通知
     */
    BATCH_JOB_RESULT("batch_job_result"),
    /**
     * 创建上下游空间事件
     */
    CREATE_CHAIN("create_chain"),
    /**
     * 更新上下游空间事件
     */
    UPDATE_CHAIN("update_chain"),
    /**
     * 删除上下游空间事件
     */
    DELETE_CHAIN("delete_chain"),
    /**
     * 新增上下游分组事件
     */
    CREATE_GROUP("create_group"),
    /**
     * 更新上下游分组事件
     */
    UPDATE_GROUP("update_group"),
    /**
     * 删除上下游分组事件
     */
    DELETE_GROUP("delete_group"),
    /**
     * 企业加入上下游事件
     */
    CORP_JOIN("corp_join"),
    /**
     * 更新企业事件
     */
    UPDATE_CORP("update_corp"),
    /**
     * 移除企业事件
     */
    REMOVE_CORP("remove_corp"),
    /**
     * 添加企业客户事件
     */
    ADD_EXTERNAL_CONTACT("add_external_contact"),
    /**
     * 编辑企业客户事件
     */
    EDIT_EXTERNAL_CONTACT("edit_external_contact"),
    /**
     * 外部联系人免验证添加成员事件
     */
    ADD_HALF_EXTERNAL_CONTACT("add_half_external_contact"),
    /**
     * 删除企业客户事件
     */
    DEL_EXTERNAL_CONTACT("del_external_contact"),
    /**
     * 删除跟进成员事件
     */
    DEL_FOLLOW_USER("del_follow_user"),
    /**
     * 客户接替失败事件
     */
    TRANSFER_FAIL("transfer_fail"),
    /**
     * <ul>
     *     <li>客户群创建事件</li>
     *     <li>企业客户标签创建事件</li>
     * </ul>
     */
    CREATE("create"),
    /**
     * <ul>
     *     <li>客户群变更事件</li>
     *     <li>企业客户标签变更事件</li>
     * </ul>
     */
    UPDATE("update"),
    /**
     * <ul>
     *     <li>企业客户标签删除事件</li>
     * </ul>
     */
    DELETE("delete"),
    /**
     * 客户群解散事件
     */
    DISMISS("dismiss"),
    /**
     * <ul>
     *     <li>企业客户标签重排事件</li>
     * </ul>
     */
    SHUFFLE("shuffle"),
    /**
     * 获客额度即将耗尽事件
     */
    BALANCE_LOW("balance_low"),
    /**
     * 获客使用量已经耗尽事件
     */
    BALANCE_EXHAUSTED("balance_exhausted"),
    /**
     * 获客链接不可用事件
     */
    LINK_UNAVAILABLE("link_unavailable"),
    /**
     * 微信客户发起会话事件
     */
    CUSTOMER_START_CHAT("customer_start_chat"),
    /**
     * 删除获客链接事件
     */
    DELETE_LINK("delete_link"),
    /**
     * 通过获客链接申请好友事件
     */
    FRIEND_REQUEST("friend_request"),
    /**
     * 获客额度即将过期事件
     */
    QUOTA_EXPIRE_SOON("quota_expire_soon"),
    /**
     * 会话存档-客户同意进行聊天内容存档事件回调
     */
    MSG_AUDIT_APPROVED("msg_audit_approved"),
    /**
     * 修改文档成员事件
     */
    DOC_MEMBER_CHANGE("doc_member_change"),
    /**
     * 删除文档事件
     */
    DELETE_DOC("delete_doc"),
    /**
     * 收集表完成事件
     */
    FORM_COMPLETE("form_complete"),
    /**
     * 删除收集表事件
     */
    DELETE_FORM("delete_form"),
    /**
     * 修改收集表设置事件
     */
    FORM_SETTINGS_CHANGE("form_settings_change");
    private final String type;

    CallbackChangeType(String type) {
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
