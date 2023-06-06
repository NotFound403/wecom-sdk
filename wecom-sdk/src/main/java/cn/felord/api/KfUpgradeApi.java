package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.callcenter.UpgradeServiceConfig;
import cn.felord.domain.callcenter.UpgradeServiceRequest;
import cn.felord.enumeration.WeComEndpoint;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Kf upgrade api.
 *
 * @author dax
 * @since 2023 /6/6
 */
public class KfUpgradeApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Kf session api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    KfUpgradeApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取配置的专员与客户群
     *
     * @return the upgrade service config
     */
    public UpgradeServiceConfig upgradeServiceConfig() {
        return workWeChatApiClient.get(WeComEndpoint.KF_UPGRADE_SERVICE_CONFIG, UpgradeServiceConfig.class);
    }

    /**
     * 为客户升级为专员或客户群服务
     *
     * @param request the request
     * @return the upgrade service config
     */
    public WeComResponse upgradeService(UpgradeServiceRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_UPGRADE_SERVICE, request, WeComResponse.class);
    }

    /**
     * 为客户取消推荐
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @return the we com response
     */
    public WeComResponse cancelService(String openKfid, String externalUserid) {
        Map<String, String> body = new HashMap<>(2);
        body.put("open_kfid", openKfid);
        body.put("external_userid", externalUserid);
        return workWeChatApiClient.post(WeComEndpoint.KF_CANCEL_UPGRADE_SERVICE, body, WeComResponse.class);
    }
}
