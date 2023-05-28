package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.tag.Tag;
import cn.felord.domain.contactbook.tag.TagUserActionResponse;
import cn.felord.domain.contactbook.tag.TagUserRequest;
import cn.felord.domain.contactbook.tag.TagUserResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.LinkedMultiValueMap;

/**
 * 通讯录管理-标签管理
 * <p>
 * 标签属于应用
 *
 * @author felord.cn
 * @since 2021 /9/11
 */
public class TagApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Tag api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    TagApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建标签
     *
     * @param request the request
     * @return GenericResponse generic response
     */
    public GenericResponse<String> createTag(Tag request) {
        return workWeChatApiClient.post( WeComEndpoint.TAG_CREATE, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 更新标签名字
     *
     * @param request the request
     * @return WeComResponse we com response
     */
    public WeComResponse updateTag(Tag request) {

        return workWeChatApiClient.post(WeComEndpoint.TAG_UPDATE, request, WeComResponse.class);
    }

    /**
     * 删除标签
     *
     * @param tagId tagId
     * @return WeComResponse we com response
     */
    public WeComResponse deleteTag(Integer tagId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("tagid", String.valueOf(tagId));
        return workWeChatApiClient.get(WeComEndpoint.TAG_DELETE,query, WeComResponse.class);
    }

    /**
     * 获取标签成员
     *
     * @param tagId tagId
     * @return UserInfoResponse tag users
     */
    public TagUserResponse getTagUsers(Integer tagId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("tagid", String.valueOf(tagId));
        return workWeChatApiClient.get(WeComEndpoint.TAG_GET_USERS, query, TagUserResponse.class);
    }

    /**
     * 增加标签成员
     *
     * @param request the request
     * @return WeComResponse tag user action response
     */
    public TagUserActionResponse addTagUsers(TagUserRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.TAG_CREATE_USERS, request, TagUserActionResponse.class);
    }

    /**
     * 删除标签成员
     *
     * @param request the request
     * @return WeComResponse tag user action response
     */
    public TagUserActionResponse deleteTagUsers(TagUserRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.TAG_DELETE_USERS, request, TagUserActionResponse.class);
    }

    /**
     * 获取标签列表
     *
     * @return UserInfoResponse tags
     */
    public GenericResponse<Tag> getTags() {
        return workWeChatApiClient.get(WeComEndpoint.TAG_LIST, new ParameterizedTypeReference<GenericResponse<Tag>>() {
        });
    }
}
