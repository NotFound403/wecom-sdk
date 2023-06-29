package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.corpay.external.MchDetailResponse;
import cn.felord.domain.corpay.external.MchId;
import cn.felord.domain.corpay.external.MchScopeRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 对外收款
 *
 * @author dax
 * @since 2023 /6/29 13:53
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
     */
    @POST("externalpay/getmerchant")
    MchDetailResponse getMerchant(@Body MchId mchId);

    /**
     * 设置商户号使用范围
     * <p>
     * 通过该接口可以设置已绑定商户号的使用范围
     * <p>
     * 只允许对外收款应用的接口凭证调用该接口
     *
     * @param request the request
     * @return the mch use scope
     */
    WeComResponse setMchUseScope(@Body MchScopeRequest request);
}
