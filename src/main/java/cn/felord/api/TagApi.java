package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.tag.Tag;
import cn.felord.domain.contactbook.tag.TagUserActionResponse;
import cn.felord.domain.contactbook.tag.TagUserRequest;
import cn.felord.domain.contactbook.tag.TagUserResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
     * @see WeComEndpoint#TAG_CREATE WeComEndpoint#TAG_CREATEWeComEndpoint#TAG_CREATE
     */
    public GenericResponse<String> createTag(Tag request) {
        String endpoint = WeComEndpoint.TAG_CREATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 更新标签名字
     *
     * @param request the request
     * @return WeComResponse we com response
     * @see WeComEndpoint#TAG_UPDATE WeComEndpoint#TAG_UPDATE
     */
    public WeComResponse updateTag(Tag request) {
        String endpoint = WeComEndpoint.TAG_UPDATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, WeComResponse.class);
    }

    /**
     * 删除标签
     *
     * @param tagId tagId
     * @return WeComResponse we com response
     * @see WeComEndpoint#TAG_DELETE WeComEndpoint#TAG_DELETEWeComEndpoint#TAG_DELETE
     */
    public WeComResponse deleteTag(Integer tagId) {
        String endpoint = WeComEndpoint.TAG_DELETE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("tagid", tagId)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, WeComResponse.class);
    }

    /**
     * 获取标签成员
     *
     * @param tagId tagId
     * @return UserInfoResponse tag users
     * @see WeComEndpoint#TAG_GET_USERS WeComEndpoint#TAG_GET_USERSWeComEndpoint#TAG_GET_USERS
     */
    public TagUserResponse getTagUsers(Integer tagId) {
        String endpoint = WeComEndpoint.TAG_GET_USERS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("tagid", tagId)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, TagUserResponse.class);
    }

    /**
     * 增加标签成员
     *
     * @param request the request
     * @return WeComResponse tag user action response
     * @see WeComEndpoint#TAG_CREATE_USERS WeComEndpoint#TAG_CREATE_USERSWeComEndpoint#TAG_CREATE_USERS
     */
    public TagUserActionResponse addTagUsers(TagUserRequest request) {
        String endpoint = WeComEndpoint.TAG_CREATE_USERS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, TagUserActionResponse.class);
    }

    /**
     * 删除标签成员
     *
     * @param request the request
     * @return WeComResponse tag user action response
     * @see WeComEndpoint#TAG_DELETE_USERS WeComEndpoint#TAG_DELETE_USERSWeComEndpoint#TAG_DELETE_USERS
     */
    public TagUserActionResponse deleteTagUsers(TagUserRequest request) {
        String endpoint = WeComEndpoint.TAG_DELETE_USERS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, TagUserActionResponse.class);
    }

    /**
     * 获取标签列表
     *
     * @return UserInfoResponse tags
     * @see WeComEndpoint#TAG_LIST WeComEndpoint#TAG_LISTWeComEndpoint#TAG_LIST
     */
    public GenericResponse<Tag> getTags() {
        String endpoint = WeComEndpoint.TAG_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, new ParameterizedTypeReference<GenericResponse<Tag>>() {
        });
    }
}
