package cn.felord.api;

import cn.felord.domain.callcenter.KfCorpStatisticDetail;
import cn.felord.domain.callcenter.KfCorpStatisticRequest;
import cn.felord.domain.callcenter.KfServicerStatisticDetail;
import cn.felord.domain.callcenter.KfServicerStatisticRequest;
import cn.felord.domain.callcenter.KfStatisticResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 客服统计管理
 *
 * @author dax
 * @since 2023 /6/6
 */
public interface KfStatisticApi {

    /**
     * 获取「客户数据统计」企业汇总数据
     *
     * @param request the request
     * @return the kf statistic response
     */
    @POST("kf/get_corp_statistic")
    Single<KfStatisticResponse<KfCorpStatisticDetail>> corpStatistic(@Body KfCorpStatisticRequest request);

    /**
     * 获取「客户数据统计」接待人员明细数据
     *
     * @param request the request
     * @return the kf statistic response
     */
    @POST("kf/get_servicer_statistic")
    Single<KfStatisticResponse<KfServicerStatisticDetail>> servicerStatistic(@Body KfServicerStatisticRequest request);
}
