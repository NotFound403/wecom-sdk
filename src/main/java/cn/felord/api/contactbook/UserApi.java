package cn.felord.api.contactbook;

import cn.felord.Agent;
import cn.felord.api.AbstractApi;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.user.*;
import cn.felord.enumeration.DeptUserFetchType;
import cn.felord.enumeration.EmailType;
import cn.felord.enumeration.UserQrcodeSize;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通讯录管理-成员管理
 *
 * @author n1
 * @since 2021 /6/17 11:09
 */
public class UserApi extends AbstractApi {

    protected UserApi() {
    }

    /**
     * Agent user api.
     *
     * @param agent the agent
     * @return the user api
     */
    protected static UserApi agent(Agent agent) {
        UserApi userApi = new UserApi();
        userApi.withAgent(agent);
        return userApi;
    }

    /**
     * 创建成员
     * <p>
     * 仅通讯录同步助手或第三方通讯录应用可调用。
     *
     * @param request the request
     * @return WeComResponse we com response
     * @see WeComEndpoint#USER_CREATE WeComEndpoint#USER_CREATE
     */
    public WeComResponse createUser(UserInfoRequest request) {
        String endpoint = WeComEndpoint.USER_CREATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, WeComResponse.class);
    }

    /**
     * 读取成员
     * <p>
     * 在通讯录同步助手中此接口可以读取企业通讯录的所有成员的信息，而自建应用可以读取该应用设置的可见范围内的成员信息。
     *
     * @param userId the user id
     * @return UserInfoResponse user
     * @see WeComEndpoint#USER_GET WeComEndpoint#USER_GET
     */
    public UserInfoResponse getUser(String userId) {
        String endpoint = WeComEndpoint.USER_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("userid", userId)
                .build()
                .toUri();
        return this.get(uri, UserInfoResponse.class);
    }

    /**
     * 更新成员，这里建议userid不可更改，虽然微信支持修改一次。
     * <p>
     * 仅通讯录同步助手或第三方通讯录应用可调用。
     *
     * @param request the request
     * @return WeComResponse we com response
     * @see WeComEndpoint#USER_UPDATE WeComEndpoint#USER_UPDATE
     */
    public WeComResponse updateUser(UserInfoRequest request) {
        String endpoint = WeComEndpoint.USER_UPDATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, WeComResponse.class);
    }

    /**
     * 删除成员
     * <p>
     * 若是绑定了腾讯企业邮，则会同时删除邮箱帐号。
     *
     * @param userId the user id
     * @return WeComResponse we com response
     * @see WeComEndpoint#USER_DELETE WeComEndpoint#USER_DELETE
     */
    public WeComResponse deleteUser(String userId) {
        String endpoint = WeComEndpoint.USER_DELETE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("userid", userId)
                .build()
                .toUri();
        return this.get(uri, WeComResponse.class);
    }

    /**
     * 批量删除成员
     * <p>
     * 若是绑定了腾讯企业邮，则会同时删除邮箱帐号。
     *
     * @param userIdList the user id list
     * @return WeComResponse we com response
     * @see WeComEndpoint#USER_BATCH_DELETE WeComEndpoint#USER_BATCH_DELETE
     */
    public WeComResponse batchDelUser(List<String> userIdList) {
        String endpoint = WeComEndpoint.USER_BATCH_DELETE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, Collections.singletonMap("useridlist", userIdList), WeComResponse.class);
    }

    /**
     * 获取部门成员
     * <p>
     * 应用须拥有指定部门的查看权限。
     *
     * @param departmentId departmentId
     * @param type         the type
     * @return SimpleUserResponse dept users
     * @see WeComEndpoint#USER_DEPT_LIST WeComEndpoint#USER_DEPT_LIST
     */
    public GenericResponse<List<SimpleUser>> getDeptUsers(String departmentId, DeptUserFetchType type) {
        String endpoint = WeComEndpoint.USER_DEPT_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("department_id", departmentId)
                .queryParam("fetch_child", type.type())
                .build()
                .toUri();
        return this.get(uri, new ParameterizedTypeReference<GenericResponse<List<SimpleUser>>>() {
        });
    }

    /**
     * 获取部门成员详情
     * <p>
     * 应用须拥有指定部门的查看权限。
     *
     * @param departmentId departmentId
     * @param type         the type
     * @return UserDetailResponse dept user details
     * @see WeComEndpoint#USER_DEPT_LIST_DETAIL WeComEndpoint#USER_DEPT_LIST_DETAIL
     */
    public GenericResponse<List<UserDetail>> getDeptUserDetails(String departmentId, DeptUserFetchType type) {
        String endpoint = WeComEndpoint.USER_DEPT_LIST_DETAIL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("department_id", departmentId)
                .queryParam("fetch_child", type.type())
                .build()
                .toUri();
        return this.get(uri, new ParameterizedTypeReference<GenericResponse<List<UserDetail>>>() {
        });
    }

    /**
     * userid与openid互换
     * <p>
     * 该接口使用场景为企业支付，在使用企业红包和向员工付款时，需要自行将企业微信的{@code userid}转成{@code openid}。
     * <p>
     * 注：需要成员使用微信登录企业微信或者关注微工作台（原企业号）才能转成{@code openid};
     * 如果是外部联系人，请使用<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90001/90143/92292">外部联系人openid转换接口</a>转换{@code openid}
     *
     * @param userId userId
     * @return OpenIdResponse generic response
     * @see WeComEndpoint#USER_BATCH_DELETE WeComEndpoint#USER_BATCH_DELETE
     */
    public GenericResponse<String> converToOpenid(String userId) {
        String endpoint = WeComEndpoint.USERID_TO_OPENID.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, Collections.singletonMap("userid", userId),
                new ParameterizedTypeReference<GenericResponse<String>>() {
                });
    }

    /**
     * 二次验证
     * <p>
     * 企业在开启二次验证时，必须在管理端填写企业二次验证页面的url。
     *
     * @param userId userId
     * @return WeComResponse we com response
     * @see WeComEndpoint#USER_AUTH WeComEndpoint#USER_AUTH
     */
    public WeComResponse userAuth(String userId) {
        String endpoint = WeComEndpoint.USER_AUTH.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("userid", userId)
                .build()
                .toUri();
        return this.get(uri, WeComResponse.class);
    }

    /**
     * 邀请成员
     * <p>
     * 企业可通过接口批量邀请成员使用企业微信，邀请后将通过短信或邮件下发通知。
     *
     * @param request batchInviteRequest
     * @return BatchInviteResponse batch invite response
     * @see WeComEndpoint#USER_BATCH_INVITE WeComEndpoint#USER_BATCH_INVITE
     */
    public BatchInviteResponse inviteUsers(BatchInviteRequest request) {
        String endpoint = WeComEndpoint.USER_BATCH_INVITE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, BatchInviteResponse.class);
    }

    /**
     * 获取加入企业二维码
     * <p>
     * 支持企业用户获取实时成员加入二维码。
     *
     * @param size size
     * @return WeComResponse join qrcode
     * @see WeComEndpoint#USER_JOIN_QRCODE WeComEndpoint#USER_JOIN_QRCODE
     */
    public GenericResponse<String> getJoinQrcode(UserQrcodeSize size) {
        String endpoint = WeComEndpoint.USER_JOIN_QRCODE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("size_type", size.type())
                .build()
                .toUri();
        return this.get(uri, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 手机号获取userid
     *
     * @param mobile mobile
     * @return WeComResponse active stat
     * @see WeComEndpoint#USER_ID_BY_MOBILE WeComEndpoint#USER_ID_BY_MOBILE
     */
    public GenericResponse<String> getUserIdByMobile(String mobile) {
        String endpoint = WeComEndpoint.USER_ID_BY_MOBILE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, Collections.singletonMap("mobile", mobile),
                new ParameterizedTypeReference<GenericResponse<String>>() {
                });
    }

    /**
     * 邮箱获取userid
     *
     * @param email email
     * @param emailType emailType
     * @return WeComResponse active stat
     * @see WeComEndpoint#USER_ID_BY_EMAIL WeComEndpoint#USER_ID_BY_EMAIL
     */
    public GenericResponse<String> getUserIdByEmail(String email, EmailType emailType) {
        String endpoint = WeComEndpoint.USER_ID_BY_EMAIL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        Map<String, Object> request = new HashMap<>(2);
        request.put("email", email);
        request.put("email_type", emailType.type());
        return this.post(uri, request,
                new ParameterizedTypeReference<GenericResponse<String>>() {
                });
    }
}
