/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.Code;
import cn.felord.domain.contactbook.user.TfaInfoResponse;
import cn.felord.domain.contactbook.user.TfaUser;
import cn.felord.domain.contactbook.user.UserDetailResponse;
import cn.felord.domain.contactbook.user.UserSensitiveInfoResponse;
import cn.felord.domain.contactbook.user.UserTicket;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 身份验证API
 *
 * @author felord.cn
 * @since 2021 /9/3 9:17
 */
public interface AuthApi {

    /**
     * 获取访问用户身份
     * <p>
     * 该接口用于根据code获取成员信息，适用于自建应用与代开发应用
     *
     * @param code 通过成员授权获取到的code
     * @return UserDetailResponse user info
     * @throws WeComException the weComException
     */
    @GET("auth/getuserinfo")
    UserDetailResponse getUserInfo(@Query("code") String code) throws WeComException;

    /**
     * 获取访问用户敏感信息，需要授权scope包含{@code snsapi_privateinfo}
     * <p>
     * 自建应用与代开发应用可通过该接口获取成员授权的敏感字段
     *
     * @param userTicket 成员票据
     * @return UserSensitiveInfoResponse user detail
     * @throws WeComException the weComException
     */
    @POST("auth/getuserdetail")
    UserSensitiveInfoResponse getUserDetail(@Body UserTicket userTicket) throws WeComException;

    /**
     * 获取用户二次验证信息
     * <p>
     * 仅『通讯录同步』或者自建应用可调用，如用自建应用调用，用户需要在二次验证范围和应用可见范围内
     *
     * @param code the code
     * @return the tfa info
     * @throws WeComException the weComException
     */
    @POST("auth/get_tfa_info")
    TfaInfoResponse getTfaInfo(@Body Code code) throws WeComException;

    /**
     * 此接口可以满足安全性要求高的企业进行成员验证。
     * 开启二次验证后，当且仅当成员登录时，需跳转至企业自定义的页面进行验证。验证频率可在设置页面选择。
     * <p>
     * 企业在开启二次验证时，必须在管理端填写企业二次验证页面的url。
     * 当成员登录企业微信或关注微信插件（原企业号）进入企业时，会自动跳转到企业的验证页面。
     * 在跳转到企业的验证页面时，会带上如下参数：code=CODE。
     * 企业收到code后，使用“通讯录同步助手”调用接口"根据code获取成员信息"获取成员的userid。
     * 如果成员是首次加入企业，企业获取到userid，并验证了成员信息后，调用如下接口即可让成员成功加入企业。
     *
     * @param userid the userid
     * @return the we com response
     * @throws WeComException the weComException
     */
    @GET("user/tfa_succ")
    WeComResponse authsucc(@Query("userid") String userid) throws WeComException;

    /**
     * 使用二次验证
     * <p>
     * 仅『通讯录同步』或者自建应用可调用，如用自建应用调用，用户需要在二次验证范围和应用可见范围内。
     *
     * @param tfaUser the tfa user
     * @return the tfa info
     * @throws WeComException the weComException
     */
    @POST("user/tfa_succ")
    WeComResponse authsucc(@Body TfaUser tfaUser) throws WeComException;
}
