package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 企业群发
 *
 * @author dax
 * @since 2021 /8/19 14:45
 */
public class GroupMessageApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Group message api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    GroupMessageApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建企业群发
     * <p>
     * 当前创建企业群发是没有办法指定群聊的，服务人员接收到群发消息推送时，是下发给所有的客户
     *
     * @param request the request
     * @return the moment list
     */
    public MsgTemplateResponse addMsgTemplate(MsgTemplateRequest request) {
        String endpoint = WeComEndpoint.GROUP_MSG_ADD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, MsgTemplateResponse.class);
    }

    /**
     * 获取群发记录列表
     * <p>
     *
     * @param request the request
     * @return the groupmsg list v 2
     */
    public GroupMsgListResponse getGroupMsgListV2(GroupMsgListRequest request) {
        String endpoint = WeComEndpoint.GROUP_MSG_LIST_V2.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, GroupMsgListResponse.class);
    }

    /**
     * 获取群发成员发送任务列表
     *
     * @param request the request
     * @return the group msg task
     */
    public GroupMsgTaskResponse getGroupMsgTask(GroupMsgTaskRequest request) {
        String endpoint = WeComEndpoint.GROUP_MSG_TASK.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, GroupMsgTaskResponse.class);
    }

    /**
     * 获取企业群发成员执行结果
     *
     * @param request the request
     * @return the group msg send result
     */
    public GroupMsgSendResultResponse getGroupMsgSendResult(GroupMsgSendResultRequest request) {
        String endpoint = WeComEndpoint.GROUP_MSG_SEND_RESULT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, GroupMsgSendResultResponse.class);
    }

    /**
     * 发送新客户欢迎语
     *
     * @param request the request
     * @return group msg send result response
     */
    public WeComResponse sendWelcomeGroupMsg(WelcomeCodeRequest request) {
        String endpoint = WeComEndpoint.GROUP_MSG_SEND_WELCOME.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, WeComResponse.class);
    }

    /**
     * 添加入群欢迎语素材
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> addWelcomeTemplate(WelcomeTemplateAddRequest request) {
        String endpoint = WeComEndpoint.GROUP_MSG_WELCOME_TEMPLATE_ADD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 编辑入群欢迎语素材
     *
     * @param request the request
     * @return the we com response
     */
    public WeComResponse editWelcomeTemplate(WelcomeTemplateEditRequest request) {
        String endpoint = WeComEndpoint.GROUP_MSG_WELCOME_TEMPLATE_EDIT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, WeComResponse.class);
    }

    /**
     * 获取入群欢迎语素材
     *
     * @param templateId the template id
     * @return the welcome template
     */
    public WelcomeTemplateResponse getWelcomeTemplate(String templateId) {
        String endpoint = WeComEndpoint.GROUP_MSG_WELCOME_TEMPLATE_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("template_id", templateId), WelcomeTemplateResponse.class);
    }

    /**
     * 删除入群欢迎语素材
     *
     * @param templateId the template id
     * @return the welcome template response
     */
    public WeComResponse delWelcomeTemplate(String templateId) {
        String endpoint = WeComEndpoint.GROUP_MSG_WELCOME_TEMPLATE_DEL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("template_id", templateId), WeComResponse.class);
    }

    /**
     * 删除入群欢迎语素材（仅适用于旧的第三方多应用套件）
     *
     * @param templateId the template id
     * @param agentId    the agent id
     * @return the we com response
     */
    public WeComResponse delWelcomeTemplate(String templateId, String agentId) {
        String endpoint = WeComEndpoint.GROUP_MSG_WELCOME_TEMPLATE_DEL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        Map<String, String> body = new HashMap<>(2);
        body.put("template_id", templateId);
        body.put("agentid", agentId);
        return workWeChatApiClient.post(uri, body, WeComResponse.class);
    }
}
