package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.oa.ScheduleAddRequest;
import cn.felord.domain.oa.ScheduleAttendees;
import cn.felord.domain.oa.ScheduleCalendarQuery;
import cn.felord.domain.oa.ScheduleDelRequest;
import cn.felord.domain.oa.ScheduleDetailResponse;
import cn.felord.domain.oa.ScheduleUpdateRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Set;

/**
 * 日程接口
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public interface ScheduleApi {

    /**
     * 创建日程
     *
     * @param request the request
     * @return the generic response
     */
    @POST("oa/schedule/add")
    Single<GenericResponse<String>> add(@Body ScheduleAddRequest request);

    /**
     * 更新日程
     *
     * @param request the request
     * @return the generic response
     */
    @POST("oa/schedule/update")
    Single<GenericResponse<String>> update(@Body ScheduleUpdateRequest request);

    /**
     * 新增日程参与者
     *
     * @param attendees the attendees
     * @return the we com response
     */
    @POST("oa/schedule/add_attendees")
    Single<WeComResponse> addAttendees(@Body ScheduleAttendees attendees);

    /**
     * 删除日程参与者
     *
     * @param attendees the attendees
     * @return the we com response
     */
    @POST("oa/schedule/del_attendees")
    Single<WeComResponse> delAttendees(@Body ScheduleAttendees attendees);

    /**
     * 获取日程详情
     *
     * @param scheduleIds the schedule ids
     * @return the schedule detail response
     */
    @POST("oa/schedule/get")
    Single<ScheduleDetailResponse> get(@Body Set<String> scheduleIds);

    /**
     * 取消日程
     *
     * @param request the request
     * @return the we com response
     */
    @POST("oa/schedule/del")
    Single<WeComResponse> del(@Body ScheduleDelRequest request);

    /**
     * 获取日历下的日程列表
     *
     * @param query the query
     * @return the by calendar
     */
    @POST("oa/schedule/get_by_calendar")
    Single<ScheduleDetailResponse> getByCalendar(ScheduleCalendarQuery query);
}
