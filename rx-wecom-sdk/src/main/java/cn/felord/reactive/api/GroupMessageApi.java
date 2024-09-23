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

package cn.felord.reactive.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.MsgId;
import cn.felord.domain.common.TemplateId;
import cn.felord.domain.externalcontact.*;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 企业群发
 *
 * @author dax
 * @since 2021 /8/19 14:45
 */
public interface GroupMessageApi {

    /**
     * 创建企业群发
     * <p>
     * 当前创建企业群发是没有办法指定群聊的，服务人员接收到群发消息推送时，是下发给所有的客户
     *
     * @param request the request
     * @return the moment list
     */
    @POST("externalcontact/add_msg_template")
    Single<MsgTemplateResponse> addMsgTemplate(@Body MsgTemplateRequest request);

    /**
     * 提醒成员群发
     * <p>
     * 企业和第三方应用可调用此接口，重新触发群发通知，提醒成员完成群发任务，24小时内每个群发最多触发三次提醒。
     *
     * @param msgId the msg id
     * @return the msg template response
     */
    @POST("externalcontact/remind_groupmsg_send")
    Single<WeComResponse> remindGroupmsgSend(@Body MsgId msgId);

    /**
     * 停止企业群发
     *
     * @param msgId the msg id
     * @return the we com response
     */
    @POST("externalcontact/cancel_groupmsg_send")
    Single<WeComResponse> cancelGroupmsgSend(@Body MsgId msgId);

    /**
     * 获取群发记录列表
     * <p>
     *
     * @param request the request
     * @return the groupmsg list v 2
     */
    @POST("externalcontact/get_groupmsg_list_v2")
    Single<GroupMsgListResponse> getGroupMsgListV2(@Body GroupMsgListRequest request);

    /**
     * 获取群发成员发送任务列表
     *
     * @param request the request
     * @return the group msg task
     */
    @POST("externalcontact/get_groupmsg_task")
    Single<GroupMsgTaskResponse> getGroupMsgTask(@Body GroupMsgTaskRequest request);

    /**
     * 获取企业群发成员执行结果
     *
     * @param request the request
     * @return the group msg send result
     */
    @POST("externalcontact/get_groupmsg_send_result")
    Single<GroupMsgSendResultResponse> getGroupMsgSendResult(@Body GroupMsgSendResultRequest request);

    /**
     * 发送新客户欢迎语
     *
     * @param request the request
     * @return group msg send result response
     */
    @POST("externalcontact/send_welcome_msg")
    Single<WeComResponse> sendWelcomeGroupMsg(@Body WelcomeCodeRequest request);

    /**
     * 添加入群欢迎语素材
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/group_welcome_template/add")
    Single<GenericResponse<String>> addWelcomeTemplate(@Body WelcomeTemplateAddRequest request);

    /**
     * 编辑入群欢迎语素材
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/group_welcome_template/edit")
    Single<WeComResponse> editWelcomeTemplate(@Body WelcomeTemplateEditRequest request);

    /**
     * 获取入群欢迎语素材
     *
     * @param templateId the template id
     * @return the welcome template
     */
    @POST("externalcontact/group_welcome_template/get")
    Single<WelcomeTemplateResponse> getWelcomeTemplate(@Body TemplateId templateId);

    /**
     * 删除入群欢迎语素材
     *
     * @param templateId the template id
     * @return the welcome template response
     */
    @POST("externalcontact/group_welcome_template/del")
    Single<WeComResponse> delWelcomeTemplate(@Body TemplateId templateId);

    /**
     * 删除入群欢迎语素材（仅适用于旧的第三方多应用套件）
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/group_welcome_template/del")
    Single<WeComResponse> delWelcomeTemplate(@Body DelWelcomeTmpRequest request);
}
