package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.oa.CalendarAddRequest;
import cn.felord.domain.oa.CalendarDelRequest;
import cn.felord.domain.oa.CalendarDetailRequest;
import cn.felord.domain.oa.CalendarDetailResponse;
import cn.felord.domain.oa.CalendarUpdateRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 日历接口
 *
 * @author felord
 * @since 2021 /10/17 17:48
 */
public interface CalendarApi {

    /**
     * 创建日历
     *
     * @param request the request
     * @return the generic response
     */
    @POST("oa/calendar/add")
    Single<GenericResponse<String>> add(@Body CalendarAddRequest request);

    /**
     * 更新日历
     *
     * @param request the request
     * @return the generic response
     */
    @POST("oa/calendar/update")
    Single<WeComResponse> update(@Body CalendarUpdateRequest request);

    /**
     * 获取日历详情
     *
     * @param request the request
     * @return the calendar detail response
     */
    @POST("oa/calendar/get")
    Single<CalendarDetailResponse> get(@Body CalendarDetailRequest request);

    /**
     * 删除日历
     *
     * @param request the request
     * @return the we com response
     */
    @POST("oa/calendar/update")
    Single<WeComResponse> del(@Body CalendarDelRequest request);
}
