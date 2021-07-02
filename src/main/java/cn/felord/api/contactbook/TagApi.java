package cn.felord.api.contactbook;

import cn.felord.AgentDetails;
import cn.felord.api.AbstractApi;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.tag.Tag;
import cn.felord.domain.contactbook.tag.TagUserActionResponse;
import cn.felord.domain.contactbook.tag.TagUserRequest;
import cn.felord.domain.contactbook.tag.TagUserResponse;
import cn.felord.enumeration.WeComDomain;
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
 * @since 1.0.8.RELEASE
 */
public class TagApi extends AbstractApi {

    public TagApi withAgent(AgentDetails agentDetails) {
        this.withToken(agentDetails);
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
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.TAG_CREATE.endpoint(WeComDomain.CGI_BIN))
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
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.TAG_UPDATE.endpoint(WeComDomain.CGI_BIN))
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
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.TAG_DELETE.endpoint(WeComDomain.CGI_BIN))
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
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.TAG_GET_USERS.endpoint(WeComDomain.CGI_BIN))
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
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.TAG_CREATE_USERS.endpoint(WeComDomain.CGI_BIN))
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
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.TAG_DELETE_USERS.endpoint(WeComDomain.CGI_BIN))
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
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.TAG_LIST.endpoint(WeComDomain.CGI_BIN))
                .build()
                .toUri();
        return this.get(uri, new ParameterizedTypeReference<GenericResponse<Tag>>() {
        });
    }
}
