package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.user.*;
import cn.felord.enumeration.EmailType;
import cn.felord.enumeration.UserQrcodeSize;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.LinkedMultiValueMap;
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
public class UserApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new User api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    UserApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 自建应用与第三方应用的对接
     *
     * @param request the request
     * @return the user id convert response
     */
    public UserIdConvertResponse batchOpenUserIdToUserId(UserIdConvertRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.OPENUSERID_TO_USERID, request, UserIdConvertResponse.class);
    }

    /**
     * 创建成员
     * <p>
     * 仅通讯录同步助手或第三方通讯录应用可调用。
     *
     * @param request the request
     * @return WeComResponse we com response
     */
    public WeComResponse createUser(UserInfoRequest request) {
        String endpoint = WeComEndpoint.USER_CREATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(WeComEndpoint.USER_CREATE, request, WeComResponse.class);
    }

    /**
     * 读取成员（自建）
     * <p>
     *
     * @param userId the user id
     * @return UserInfoResponse user
     */
    public UserInfoResponse getUser(String userId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("userid", userId);
        return workWeChatApiClient.get(WeComEndpoint.USER_GET, query, UserInfoResponse.class);
    }

    /**
     * 更新成员，这里建议userid不可更改，虽然微信支持修改一次。
     * <p>
     * 仅通讯录同步助手或第三方通讯录应用可调用。
     *
     * @param request the request
     * @return WeComResponse we com response
     */
    public WeComResponse updateUser(UserInfoRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.USER_UPDATE, request, WeComResponse.class);
    }

    /**
     * 删除成员
     * <p>
     * 若是绑定了腾讯企业邮，则会同时删除邮箱帐号。
     *
     * @param userId the user id
     * @return WeComResponse we com response
     */
    public WeComResponse deleteUser(String userId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("userid", userId);
        return workWeChatApiClient.get(WeComEndpoint.USER_DELETE, query, WeComResponse.class);
    }

    /**
     * 获取成员ID列表
     *
     * @param cursor the cursor
     * @param limit  the limit
     * @return the dept user list response
     */
    public DeptUserListResponse userList(String cursor, int limit) {
        Map<String, Object> body = new HashMap<>(2);
        body.put("cursor", cursor);
        body.put("limit", limit);
        return workWeChatApiClient.post(WeComEndpoint.USER_LIST_ID, body, DeptUserListResponse.class);
    }


    /**
     * 批量删除成员
     * <p>
     * 若是绑定了腾讯企业邮，则会同时删除邮箱帐号。
     *
     * @param userIdList the user id list
     * @return WeComResponse we com response
     */
    public WeComResponse batchDelUser(List<String> userIdList) {
        return workWeChatApiClient.post(WeComEndpoint.USER_BATCH_DELETE, Collections.singletonMap("useridlist", userIdList), WeComResponse.class);
    }

    /**
     * 获取部门成员
     * <p>
     * 应用须拥有指定部门的查看权限。
     *
     * @param departmentId departmentId
     * @return SimpleUserResponse dept users
     */
    public GenericResponse<List<SimpleUser>> getDeptUsers(String departmentId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("department_id", departmentId);
        return workWeChatApiClient.get(WeComEndpoint.USER_DEPT_LIST, query, new ParameterizedTypeReference<GenericResponse<List<SimpleUser>>>() {
        });
    }

    /**
     * 获取部门成员详情（自建）
     * <p>
     * 应用须拥有指定部门的查看权限。
     *
     * @param departmentId departmentId
     * @return UserDetailResponse dept user details
     */
    public GenericResponse<List<UserDetail>> getDeptUserDetails(long departmentId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("department_id", String.valueOf(departmentId));
        return workWeChatApiClient.get(WeComEndpoint.USER_DEPT_LIST_DETAIL, query, new ParameterizedTypeReference<GenericResponse<List<UserDetail>>>() {
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
     */
    public GenericResponse<String> converToOpenid(String userId) {
        return workWeChatApiClient.post(WeComEndpoint.USERID_TO_OPENID, Collections.singletonMap("userid", userId),
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
     */
    public WeComResponse userAuth(String userId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("userid", userId);
        return workWeChatApiClient.get(WeComEndpoint.USER_AUTH, query, WeComResponse.class);
    }

    /**
     * 邀请成员
     * <p>
     * 企业可通过接口批量邀请成员使用企业微信，邀请后将通过短信或邮件下发通知。
     *
     * @param request batchInviteRequest
     * @return BatchInviteResponse batch invite response
     */
    public BatchInviteResponse inviteUsers(BatchInviteRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.USER_BATCH_INVITE, request, BatchInviteResponse.class);
    }

    /**
     * 获取加入企业二维码
     * <p>
     * 支持企业用户获取实时成员加入二维码。
     *
     * @param size size
     * @return WeComResponse join qrcode
     */
    public GenericResponse<String> getJoinQrcode(UserQrcodeSize size) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("size_type", size.type());
        return workWeChatApiClient.get(WeComEndpoint.USER_JOIN_QRCODE, query, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 手机号获取userid
     *
     * @param mobile mobile
     * @return WeComResponse active stat
     */
    public GenericResponse<String> getUserIdByMobile(String mobile) {
        return workWeChatApiClient.post(WeComEndpoint.USER_ID_BY_MOBILE, Collections.singletonMap("mobile", mobile),
                new ParameterizedTypeReference<GenericResponse<String>>() {
                });
    }

    /**
     * 邮箱获取userid
     *
     * @param email     email
     * @param emailType emailType
     * @return WeComResponse active stat
     */
    public GenericResponse<String> getUserIdByEmail(String email, EmailType emailType) {
        Map<String, Object> request = new HashMap<>(2);
        request.put("email", email);
        request.put("email_type", emailType.type());
        return workWeChatApiClient.post(WeComEndpoint.USER_ID_BY_EMAIL, request,
                new ParameterizedTypeReference<GenericResponse<String>>() {
                });
    }
}
