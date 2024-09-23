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
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.corpgroup.ChainContactRequest;
import cn.felord.domain.corpgroup.ChainCorp;
import cn.felord.domain.corpgroup.ChainCorpDetailRequest;
import cn.felord.domain.corpgroup.ChainCorpDetailResponse;
import cn.felord.domain.corpgroup.ChainGroup;
import cn.felord.domain.corpgroup.ChainGroupInfoRequest;
import cn.felord.domain.corpgroup.ChainGroupRequest;
import cn.felord.domain.corpgroup.CorpExUser;
import cn.felord.domain.corpgroup.CorpExUserRequest;
import cn.felord.domain.corpgroup.CorpId;
import cn.felord.domain.corpgroup.CorpInUser;
import cn.felord.domain.corpgroup.ExPendingIdRequest;
import cn.felord.domain.corpgroup.GroupCorpsResponse;
import cn.felord.domain.corpgroup.JobResultResponse;
import cn.felord.domain.corpgroup.PendingExUser;
import cn.felord.domain.corpgroup.ShareInfoRequest;
import cn.felord.domain.corpgroup.ShareInfoResponse;
import cn.felord.domain.corpgroup.UnionPendingIdRequest;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

/**
 * 上下游-上游调用
 *
 * @author dax
 * @since 2024/10/12
 */
public interface UpStreamApi {

    /**
     * 获取应用共享信息
     * <p>
     * 局校互联中的局端或者上下游中的上游企业通过该接口可以获取某个应用分享给的所有企业列表。
     * 特别注意，对于有敏感权限的应用，需要下级/下游企业确认后才能共享成功，若下级/下游企业未确认，则不会存在于该接口的返回列表
     *
     * @param request the request
     * @return the share info response
     * @throws WeComException the weComException
     */
    @POST("corpgroup/corp/list_app_share_info")
    ShareInfoResponse listAppShareInfo(@Body ShareInfoRequest request) throws WeComException;

    /**
     * 上下游关联客户信息-已添加客户
     * <p>
     * 场景：品牌在公众号、小程序上的微信粉丝，可以跟经销商用企微添加的微信客户打通数据
     * <p>
     * 实现效果：共享客户信息，完善客户画像，促进成交
     * <p>
     * 准备工作
     * <ul>
     *     <li>品牌有自己主体（或isv主体）的公众号、小程序</li>
     *     <li>品牌创建上下游，经销商新建企业并加入上下游</li>
     *     <li>品牌共享应用给经销商</li>
     *     <li>经销商管理员授权应用获取「企业客户」权限</li>
     * </ul>
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("corpgroup/unionid_to_external_userid")
    GenericResponse<List<CorpExUser>> unionidToExternalUserid(@Body CorpExUserRequest request) throws WeComException;

    /**
     * unionid查询pending_id
     * <p>
     * 该接口有调用频率限制，按上游企业维度，限制为：10万次/小时、48万次/天、750万次/月。
     * <ol>
     *     <li>调用该接口的应用必须是上下游共享的自建应用或代开发应用</li>
     *     <li>应用需要具有客户联系权限</li>
     *     <li>当前授权企业必须已认证或已验证；若为代开发应用，服务商必须已认证</li>
     *     <li>unionid（即微信开放平台账号主体）与openid（即小程序或服务号账号主体）需要认证，且主体名称需与上游企业的主体名称一致（<a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/product/Open_Platform_Account_Management.html#%E5%9B%9B%E3%80%81%E8%AE%A4%E8%AF%81%E4%BB%A3%E6%B3%A8%E5%86%8C%E7%9A%84%E5%B8%90%E5%8F%B7">查看由服务商代注册的开放平台账号认证流程</a>）</li>
     *     <li>openid与unionid必须是在同一个小程序获取到的</li>
     * </ol>
     * pending_id的说明
     * <ul>
     *     <li>pending_id主要用于关联微信unionid与外部联系人external_userid，可理解为临时外部联系人ID；</li>
     *     <li>上游企业可通过此接口将微信unionid转为pending_id，当微信用户成为下游企业客户后，可使用上下游external_userid转pending_id接口将下游external_userid转换为pending_id，建立unionid 到 pending_id 再到 external_userid的映射关系；</li>
     *     <li>pending_id有效期90天，共享应用内唯一。</li>
     * </ul>
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("corpgroup/unionid_to_pending_id")
    GenericResponse<String> unionidToPendingId(@Body UnionPendingIdRequest request) throws WeComException;

    /**
     * external_userid查询pending_id (上游专用)
     *
     * <ul>
     *     <li>调用该接口的应用必须是上下游共享的自建应用或代开发应用</li>
     *     <li>应用需要具有客户联系权限</li>
     *     <li>该客户的跟进人或其所在客户群群主必须在应用的可见范围之内</li>
     *     <li>上游应用须调用过{@link UpStreamApi#unionidToPendingId(UnionPendingIdRequest)}</li>
     *     <li>上游和下游企业须认证或验证；若为代开发应用，服务商必须已认证</li>
     * </ul>
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     * @see DownStreamApi#externalUseridToPendingId(ExPendingIdRequest) 下游专用
     */
    @POST("corpgroup/batch/external_userid_to_pending_id")
    GenericResponse<List<PendingExUser>> externalUseridToPendingId(@Body ExPendingIdRequest request) throws WeComException;

    /**
     * 获取上下游列表
     * <ul>
     *     <li>自建应用/代开发应用可调用，仅返回应用可见范围内的上下游列表</li>
     *     <li>上下游系统应用可调用，返回全部的上下游列表</li>
     * </ul>
     *
     * @return the chain list
     * @throws WeComException the weComException
     */
    @GET("corpgroup/corp/get_chain_list")
    GenericResponse<List<ChainCorp>> getChainList() throws WeComException;

    /**
     * 获取上下游通讯录分组
     * <p>
     * 自建应用/代开发应用和上下游系统应用可通过该接口获取企业上下游通讯录分组详情
     * <ul>
     *     <li>自建应用/代开发应用可调用，仅可指定或返回应用可见范围内的分组列表</li>
     *     <li>上下游系统应用可调用，可指定或返回全部的分组列表</li>
     * </ul>
     *
     * @param request the request
     * @return the chain group
     * @throws WeComException the weComException
     */
    @POST("corpgroup/corp/get_chain_group")
    GenericResponse<List<ChainGroup>> getChainGroup(@Body ChainGroupRequest request) throws WeComException;

    /**
     * 获取企业上下游通讯录分组下的企业详情列表
     * <p>
     * 自建应用/代开发应用和上下游系统应用可通过该接口获取企业上下游通讯录的某个分组下的企业列表
     * <p>
     * 如需获取该分组及其子分组的所有企业详情，需先获取该分组下的所有子分组，然后再获取子分组下的企业，逐层递归获取。
     *
     * @param request the request
     * @return the chain corpinfo list
     * @throws WeComException the weComException
     */
    @POST("corpgroup/corp/get_chain_corpinfo_list")
    GroupCorpsResponse getChainCorpinfoList(@Body ChainGroupInfoRequest request) throws WeComException;

    /**
     * 获取企业上下游通讯录下的企业信息
     * <p>
     * 自建应用/代开发应用和上下游系统应用可通过该接口获取企业上下游通讯录的某个企业的自定义id和所属分组的分组id
     * <ul>
     *     <li>自建应用/代开发应用可调用，仅可指定应用可见范围内的企业</li>
     *     <li>上下游系统应用可调用，可指定上下游内的所有企业</li>
     * </ul>
     *
     * @param request the request
     * @return the chain corpinfo
     * @throws WeComException the weComException
     */
    @POST("corpgroup/corp/get_chain_corpinfo")
    ChainCorpDetailResponse getChainCorpinfo(@Body ChainCorpDetailRequest request) throws WeComException;

    /**
     * 提交批量导入上下游联系人任务
     * <ul>
     *     <li>仅已验证的企业可调用</li>
     *     <li>仅上下游系统应用可调用</li>
     * </ul>
     * 同时只能存在一个导入任务。导入任务包括通过API提交的任务和从管理后台提交的导入任务。
     *
     * @param request the request
     * @return the chain corpinfo
     * @throws WeComException the weComException
     */
    @POST("corpgroup/import_chain_contact")
    GenericResponse<String> getChainCorpinfo(@Body ChainContactRequest request) throws WeComException;

    /**
     * 获取异步任务结果
     * <p>
     * 只能查询已经提交过的历史任务。
     * <p>
     * 并发限制：5
     *
     * @param jobId the job id
     * @return the result
     * @throws WeComException the weComException
     */
    @GET("corpgroup/getresult")
    JobResultResponse getResult(@Query("jobid") String jobId) throws WeComException;

    /**
     * 移除企业
     * <p>
     * 上级/上游企业通过该接口移除下游企业
     * <ul>
     *     <li>仅已验证的企业可调用</li>
     *     <li>仅上下游系统应用可调用</li>
     * </ul>
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("corpgroup/corp/remove_corp")
    WeComResponse removeCorp(@Body ChainCorpDetailRequest request) throws WeComException;

    /**
     * 查询成员自定义id
     * <p>
     * 上级企业自建应用/代开发应用通过本接口查询成员自定义 id
     * <p>
     * 自建应用、代开发应用和「上下游」原生应用可调用，仅可指定应用可见范围内的企业
     *
     * @param user the user
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("corpgroup/corp/get_chain_user_custom_id")
    GenericResponse<String> getChainUserCustomId(@Body CorpInUser user) throws WeComException;

    /**
     * 获取下级企业加入的上下游
     * <p>
     * 上级企业自建应用/代开发应用通过本接口查询下级企业所在上下游
     * <p>
     * 自建应用、代开发应用和「上下游」原生应用可调用，仅可指定应用可见范围内的企业
     *
     * @param corpId the corp id
     * @return the chain user custom id
     * @throws WeComException the weComException
     */
    @POST("corpgroup/corp/get_chain_user_custom_id")
    GenericResponse<List<ChainCorp>> getChainUserCustomId(@Body CorpId corpId) throws WeComException;
}
