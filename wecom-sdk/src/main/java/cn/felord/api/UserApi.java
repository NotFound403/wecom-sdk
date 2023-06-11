/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.UserId;
import cn.felord.domain.contactbook.user.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

/**
 * 通讯录管理-成员管理
 *
 * @author n1
 * @since 2021 /6/17 11:09
 */
public interface UserApi {


    /**
     * 自建应用与第三方应用的对接
     *
     * @param request the request
     * @return the user id convert response
     */
    @POST("batch/openuserid_to_userid")
    UserIdConvertResponse batchOpenUserIdToUserId(@Body UserIdConvertRequest request);

    /**
     * 创建成员
     * <p>
     * 仅通讯录同步助手或第三方通讯录应用可调用。
     *
     * @param request the request
     * @return WeComResponse we com response
     */
    @POST("user/create")
    WeComResponse createUser(@Body UserInfoRequest request);

    /**
     * 读取成员（自建）
     * <p>
     * 敏感信息需要授权
     *
     * @param userId the user id
     * @return UserInfoResponse user
     */
    @GET("user/get")
    UserInfoResponse getUser(@Query("userid") String userId);

    /**
     * 更新成员，这里建议userid不可更改，虽然微信支持修改一次。
     * <p>
     * 仅通讯录同步助手或第三方通讯录应用可调用。
     *
     * @param request the request
     * @return WeComResponse we com response
     */
    @POST("user/update")
    WeComResponse updateUser(@Body UserInfoRequest request);

    /**
     * 删除成员
     * <p>
     * 若是绑定了腾讯企业邮，则会同时删除邮箱帐号。
     *
     * @param userId the user id
     * @return WeComResponse we com response
     */
    @GET("user/delete")
    WeComResponse deleteUser(@Query("userid") String userId);

    /**
     * 获取成员ID列表
     *
     * @param cursor the cursor
     * @param limit  the limit
     * @return the dept user list response
     */
    @GET("user/list_id")
    DeptUserListResponse userList(@Query("cursor") String cursor, @Query("limit") int limit);

    /**
     * 批量删除成员
     * <p>
     * 若是绑定了腾讯企业邮，则会同时删除邮箱帐号。
     *
     * @param userIdList the user id list
     * @return WeComResponse we com response
     */
    @POST("user/batchdelete")
    WeComResponse batchDelUser(@Body List<String> userIdList);

    /**
     * 获取部门成员
     * <p>
     * 应用须拥有指定部门的查看权限。
     *
     * @param departmentId departmentId
     * @return SimpleUserResponse dept users
     */
    @GET("user/simplelist")
    GenericResponse<List<SimpleUser>> getDeptUsers(@Query("department_id") long departmentId);

    /**
     * 获取部门成员详情（自建）
     * <p>
     * 应用须拥有指定部门的查看权限。
     *
     * @param departmentId departmentId
     * @return UserDetailResponse dept user details
     */
    @GET("user/list")
    GenericResponse<List<UserDetail>> getDeptUserDetails(@Query("department_id") long departmentId);

    /**
     * userid与openid互换
     * <p>
     * 该接口使用场景为企业支付，在使用企业红包和向员工付款时，需要自行将企业微信的{@code userid}转成{@code openid}。
     * <p>
     * 注：需要成员使用微信登录企业微信或者关注微工作台（原企业号）才能转成{@code openid};
     * 如果是外部联系人，请使用<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90001/90143/92292">外部联系人openid转换接口</a>转换{@code openid}
     *
     * @param request the request
     * @return OpenIdResponse generic response
     */
    @POST("user/convert_to_openid")
    GenericResponse<String> converToOpenid(@Body UserId request);

    /**
     * 二次验证
     * <p>
     * 企业在开启二次验证时，必须在管理端填写企业二次验证页面的url。
     *
     * @param userId userId
     * @return WeComResponse we com response
     */
    @GET("user/authsucc")
    WeComResponse userAuth(@Query("userid") String userId);

    /**
     * 邀请成员
     * <p>
     * 企业可通过接口批量邀请成员使用企业微信，邀请后将通过短信或邮件下发通知。
     *
     * @param request batchInviteRequest
     * @return BatchInviteResponse batch invite response
     */
    @POST("batch/invite")
    BatchInviteResponse inviteUsers(@Body BatchInviteRequest request);

    /**
     * 获取加入企业二维码
     * <p>
     * 支持企业用户获取实时成员加入二维码。
     *
     * @param userQrcodeSize 范围 [1,4]
     * @return WeComResponse join qrcode
     */
    @GET("corp/get_join_qrcode")
    GenericResponse<String> getJoinQrcode(@Query("size_type") int userQrcodeSize);


    /**
     * 手机号获取userid
     * <p>
     * 错误率过高会被限流
     *
     * @param mobile mobile
     * @return WeComResponse active stat
     */
    @POST("user/getuserid")
    GenericResponse<String> getUserIdByMobile(@Body Mobile mobile);

    /**
     * 邮箱获取userid
     *
     * @param request the request
     * @return WeComResponse active stat
     */
    @POST("user/get_userid_by_email")
    GenericResponse<String> getUserIdByEmail(@Body EmailUserRequest request);
}
