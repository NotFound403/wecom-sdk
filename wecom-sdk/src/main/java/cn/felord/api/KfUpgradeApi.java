package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.callcenter.KfAndExternalUser;
import cn.felord.domain.callcenter.KfExternalUserRequest;
import cn.felord.domain.callcenter.KfExternalUserResponse;
import cn.felord.domain.callcenter.UpgradeServiceConfig;
import cn.felord.domain.callcenter.UpgradeServiceRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 升级服务
 *
 * @author dax
 * @since 2023 /6/6
 */
public interface KfUpgradeApi {

    /**
     * 获取配置的专员与客户群
     *
     * @return the upgrade service config
     */
    @GET("kf/customer/get_upgrade_service_config")
    Single<UpgradeServiceConfig> upgradeServiceConfig();

    /**
     * 为客户升级为专员或客户群服务
     *
     * @param request the request
     * @return the upgrade service config
     */
    @POST("kf/customer/upgrade_service")
    Single<WeComResponse> upgradeService(@Body UpgradeServiceRequest request);

    /**
     * 为客户取消推荐
     *
     * @param kfAndExternalUser the kf and external user
     * @return the we com response
     */
    @POST("kf/customer/cancel_upgrade_service")
    Single<WeComResponse> cancelService(@Body KfAndExternalUser kfAndExternalUser);

    /**
     * 获取客户基础信息
     *
     * @param request the request
     * @return the kf external user response
     */
    @POST("kf/customer/batchget")
    Single<KfExternalUserResponse> batchKfExternalUsers(KfExternalUserRequest request);
}
