package cn.felord.api;

import cn.felord.domain.callcenter.KfServicerListResponse;
import cn.felord.domain.callcenter.KfServicerRequest;
import cn.felord.domain.callcenter.KfServicerResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 接待人员管理
 *
 * @author dax
 * @since 2021 /7/23 13:52
 */
public interface KfServicerApi {

    /**
     * 添加接待人员
     *
     * @param request the request
     * @return the generic response
     */
    @POST("kf/servicer/add")
    Single<KfServicerResponse> addKfServicer(@Body KfServicerRequest request);

    /**
     * 删除接待人员
     *
     * @param request the request
     * @return the we com response
     */
    @POST("kf/servicer/del")
    Single<KfServicerResponse> delKfServicer(@Body KfServicerRequest request);

    /**
     * 获取接待人员列表
     *
     * @param openKfid the openKfid
     * @return the generic response
     */
    @GET("kf/servicer/list")
    Single<KfServicerListResponse> kfServicerList(@Query("open_kfid") String openKfid);
}
