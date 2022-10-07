package cn.felord.api;

import cn.felord.domain.contactbook.user.UserDetailResponse;
import cn.felord.domain.contactbook.user.UserSensitiveInfoResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

/**
 * 身份验证API
 *
 * @author felord.cn
 * @since 2021 /9/3 9:17
 */
public class AuthApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Auth api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    AuthApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取访问用户身份
     * <p>
     * 该接口用于根据code获取成员信息，适用于自建应用与代开发应用
     *
     * @param code 通过成员授权获取到的code
     * @return UserDetailResponse user detail response
     */
    public UserDetailResponse getUserInfo(String code) {
        String endpoint = WeComEndpoint.USER_AUTH_BY_CODE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("code", code)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, UserDetailResponse.class);
    }


    /**
     * 获取访问用户敏感信息，需要授权scope包含{@code snsapi_privateinfo}
     * <p>
     * 自建应用与代开发应用可通过该接口获取成员授权的敏感字段
     *
     * @param userTicket 成员票据
     * @return UserSensitiveInfoResponse user sensitive info response
     */
    public UserSensitiveInfoResponse getUserDetail(String userTicket) {
        String endpoint = WeComEndpoint.USER_DETAIL_BY_USER_TICKET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri,
                Collections.singletonMap("user_ticket", userTicket),
                UserSensitiveInfoResponse.class);
    }
}
