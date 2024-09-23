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
import cn.felord.domain.corpay.external.*;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 对外收款
 *
 * @author dax
 * @since 2024/6/29 13:53
 */
public interface ExternalCorPayApi {

    /**
     * 查询商户号详情
     * <p>
     * 通过该接口可以查询已绑定商户号信息以及商户号使用范围
     * <p>
     * 只允许对外收款应用的接口凭证调用该接口
     *
     * @param mchId the mch id
     * @return the merchant
     * @throws WeComException the weComException
     */
    @POST("externalpay/getmerchant")
    MchDetailResponse getMerchant(@Body MchId mchId) throws WeComException;

    /**
     * 设置商户号使用范围
     * <p>
     * 通过该接口可以设置已绑定商户号的使用范围
     * <p>
     * 只允许对外收款应用的接口凭证调用该接口
     *
     * @param request the request
     * @return the mch use scope
     * @throws WeComException the weComException
     */
    WeComResponse setMchUseScope(@Body MchScopeRequest request) throws WeComException;

    /**
     * 获取对外收款记录
     * <p>
     * 企业和服务商可通过此接口获取企业的对外收款记录
     * <p>
     * 补充说明:
     * <ul>
     *     <li>收款记录的起止时间间隔不能超过1个月。</li>
     *     <li>会过滤收款人不在可见范围中的收款记录，因此返回的记录数可能会小于limit设置的最大记录数。</li>
     *     <li>如果没有获取到next_cursor，说明已经拉取完所有的数据。</li>
     * </ul>
     * <p>
     * 权限说明：
     * <ul>
     *     <li>允许对外收款应用secret获取的access_token调用</li>
     *     <li>第三方应用调用需要企业授权对外收款的权限</li>
     *     <li>只会返回当前在应用可见范围内用户的收款记录</li>
     *     <li>4.1.0及以上版本中新增的部分商户号收款记录，不会返回给第三方应用和代开发应用</li>
     * </ul>
     *
     * @param request the request
     * @return the bill list
     * @throws WeComException the weComException
     */
    @POST("externalpay/get_bill_list")
    BillResponse getBillList(@Body BillRequest request) throws WeComException;

    /**
     * 获取收款项目的商户单号
     * <p>
     * 获取对外收款项目中每笔收款的商户单号
     * <p>
     * 权限说明：
     * <ul>
     *     <li>应用需具备对外收款权限</li>
     *     <li>只允许获取由应用本身创建的收款项目的收款单号列表</li>
     * </ul>
     *
     * @param paymentId the payment id
     * @return the payment info
     * @throws WeComException the weComException
     */
    @POST("externalpay/get_payment_info")
    GenericResponse<List<OutTradeNo>> getPaymentInfo(@Body PaymentId paymentId) throws WeComException;

    /**
     * 获取资金流水
     * <p>
     * 企业可通过此接口获取企业的资金流水。
     * <p>
     * 补充说明:
     * <ul>
     *     <li>可以拉取不早于2022年12月1日的资金流水记录，资金流水记录最长保留3年。</li>
     *     <li>当日的资金流水会在次日上午11点后生成。</li>
     *     <li>资金流水的起止间隔不能超过31天。</li>
     *     <li>会过滤操作人不在应用可见范围中的资金流水，因此返回的记录数可能会小于limit设置的最大记录数。</li>
     *     <li>如果没有获取到next_cursor，说明已经拉取完所有的数据。</li>
     * </ul>
     * 权限说明：
     * <ul>
     *     <li>仅允许对外收款应用secret获取的access_token调用</li>
     *     <li>仅返回在企业微信开通的商户号资金流水</li>
     * </ul>
     *
     * @param request the request
     * @return the fund flow
     * @throws WeComException the weComException
     */
    @POST("externalpay/get_fund_flow")
    FundFlowResponse getFundFlow(@Body FundFlowRequest request) throws WeComException;
}
