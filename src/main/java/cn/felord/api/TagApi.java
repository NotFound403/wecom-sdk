package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.TokenCacheable;
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
 * @author dax
 * @since 1.0.8.RELEASE
 */
public class TagApi extends AbstractApi {
    TagApi(TokenCacheable tokenCacheable) {
        super(tokenCacheable);
    }

    TagApi agent(AgentDetails agent) {
        this.withAgent(agent);
        return this;
    }

    /**
     * 创建标签
     *
     * @param request the request
     * @return GenericResponse
     * @see WeComEndpoint#TAG_CREATE
     */
    public GenericResponse<String> createTag(Tag request) {
        String endpoint = WeComEndpoint.TAG_CREATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 更新标签名字
     *
     * @param request the request
     * @return WeComResponse
     * @see WeComEndpoint#TAG_UPDATE
     */
    public WeComResponse updateTag(Tag request) {
        String endpoint = WeComEndpoint.TAG_UPDATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, WeComResponse.class);
    }

    /**
     * 删除标签
     *
     * @param tagId tagId
     * @return WeComResponse
     * @see WeComEndpoint#TAG_DELETE
     */
    public WeComResponse deleteTag(Integer tagId) {
        String endpoint = WeComEndpoint.TAG_DELETE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("tagid", tagId)
                .build()
                .toUri();
        return this.get(uri, WeComResponse.class);
    }

    /**
     * 获取标签成员
     *
     * @param tagId tagId
     * @return UserInfoResponse
     * @see WeComEndpoint#TAG_GET_USERS
     */
    public TagUserResponse getTagUsers(Integer tagId) {
        String endpoint = WeComEndpoint.TAG_GET_USERS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("tagid", tagId)
                .build()
                .toUri();
        return this.get(uri, TagUserResponse.class);
    }

    /**
     * 增加标签成员
     *
     * @param request the request
     * @return WeComResponse
     * @see WeComEndpoint#TAG_CREATE_USERS
     */
    public TagUserActionResponse addTagUsers(TagUserRequest request) {
        String endpoint = WeComEndpoint.TAG_CREATE_USERS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, TagUserActionResponse.class);
    }

    /**
     * 删除标签成员
     *
     * @param request the request
     * @return WeComResponse
     * @see WeComEndpoint#TAG_DELETE_USERS
     */
    public TagUserActionResponse deleteTagUsers(TagUserRequest request) {
        String endpoint = WeComEndpoint.TAG_DELETE_USERS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, TagUserActionResponse.class);
    }

    /**
     * 获取标签列表
     *
     * @return UserInfoResponse
     * @see WeComEndpoint#TAG_LIST
     */
    public GenericResponse<Tag> getTags() {
        String endpoint = WeComEndpoint.TAG_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.get(uri, new ParameterizedTypeReference<GenericResponse<Tag>>() {
        });
    }
}
