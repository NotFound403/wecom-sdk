package cn.felord.api.contactbook;

import cn.felord.AgentDetails;
import cn.felord.api.AbstractApi;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.tag.Tag;
import cn.felord.domain.contactbook.user.UserInfoRequest;
import cn.felord.domain.contactbook.user.UserInfoResponse;
import cn.felord.enumeration.WeComDomain;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 标签管理
 * <p>
 * 标签属于应用
 *
 * @author felord.cn
 * @since 1.0.8.RELEASE
 */
public class TagApi extends AbstractApi {
    public TagApi(AgentDetails agentDetails) {
        super(agentDetails);
    }

    /**
     * 创建成员
     * <p>
     * 仅通讯录同步助手或第三方通讯录应用可调用。
     *
     * @param request the request
     * @return WeComResponse
     * @see WeComEndpoint#USER_CREATE
     */
    public WeComResponse createTag(Tag request) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.USER_CREATE.endpoint(WeComDomain.CGI_BIN))
                .build()
                .toUri();
        return this.weComClient().post(uri, request, WeComResponse.class);
    }

    /**
     * 读取成员
     * <p>
     * 在通讯录同步助手中此接口可以读取企业通讯录的所有成员的信息，而自建应用可以读取该应用设置的可见范围内的成员信息。
     *
     * @param userId the user id
     * @return UserInfoResponse
     * @see WeComEndpoint#USER_GET
     */
    public UserInfoResponse getUser(String userId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.USER_GET.endpoint(WeComDomain.CGI_BIN))
                .queryParam("userid", userId)
                .build()
                .toUri();
        return this.weComClient().get(uri, UserInfoResponse.class);
    }

    /**
     * 更新成员，这里建议userid不可更改，虽然微信支持修改一次。
     * <p>
     * 仅通讯录同步助手或第三方通讯录应用可调用。
     *
     * @param request the request
     * @return WeComResponse
     * @see WeComEndpoint#USER_UPDATE
     */
    public WeComResponse updateUser(UserInfoRequest request) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.USER_UPDATE.endpoint(WeComDomain.CGI_BIN))
                .build()
                .toUri();
        return this.weComClient().post(uri, request, WeComResponse.class);
    }
}
