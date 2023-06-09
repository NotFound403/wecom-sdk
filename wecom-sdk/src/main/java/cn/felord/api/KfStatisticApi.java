package cn.felord.api;

import cn.felord.domain.callcenter.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

/**
 * 客服统计管理
 *
 * @author dax
 * @since 2023 /6/6
 */
public class KfStatisticApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Kf session api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    KfStatisticApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取「客户数据统计」企业汇总数据
     *
     * @param request the request
     * @return the kf statistic response
     */
    public KfStatisticResponse<KfCorpStatisticDetail> corpStatistic(KfCorpStatisticRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_CORP_STATISTIC,
                request,
                new ParameterizedTypeReference<KfStatisticResponse<KfCorpStatisticDetail>>() {
                });
    }

    /**
     * 获取「客户数据统计」接待人员明细数据
     *
     * @param request the request
     * @return the kf statistic response
     */
    public KfStatisticResponse<KfServicerStatisticDetail> servicerStatistic(KfServicerStatisticRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_SERVICER_STATISTIC,
                request,
                new ParameterizedTypeReference<KfStatisticResponse<KfServicerStatisticDetail>>() {
                });
    }
}
