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
import cn.felord.domain.meetingroom.BookingInfoRequest;
import cn.felord.domain.meetingroom.BookingInfoResponse;
import cn.felord.domain.meetingroom.BookingRequest;
import cn.felord.domain.meetingroom.BookingResponse;
import cn.felord.domain.meetingroom.BookingResultResponse;
import cn.felord.domain.meetingroom.CancelBookRequest;
import cn.felord.domain.meetingroom.MeetBookingRequest;
import cn.felord.domain.meetingroom.MeetingRoomId;
import cn.felord.domain.meetingroom.RoomBookingRequest;
import cn.felord.domain.meetingroom.RoomBookingResponse;
import cn.felord.domain.meetingroom.RoomCreateRequest;
import cn.felord.domain.meetingroom.RoomListRequest;
import cn.felord.domain.meetingroom.RoomListResponse;
import cn.felord.domain.meetingroom.RoomUpdateRequest;
import cn.felord.domain.meetingroom.ScheduleBookingRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 会议室API
 *
 * @author dax
 * @since 2024/11/29
 */
public interface MeetingRoomApi {

    /**
     * 添加会议室
     * <p>
     * 企业可通过此接口添加一个会议室
     * <p>
     * 如果不填写range参数，则默认为全公司可用。
     * 如果需要为会议室设置位置信息，则必须同时填写城市（city），楼宇（building）和楼层(floor)三个参数。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("oa/meetingroom/add")
    GenericResponse<Integer> add(@Body RoomCreateRequest request) throws WeComException;

    /**
     * 查询会议室
     * <p>
     * 企业可通过此接口查询满足条件的会议室
     * <p>
     * 如果需要使用某个位置信息进行查询，则需要保证其上一级的位置信息已填写，
     * 即如需使用楼宇进行过滤，则必须同时填写城市字段。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("oa/meetingroom/list")
    RoomListResponse list(@Body RoomListRequest request) throws WeComException;

    /**
     * 编辑会议室
     * <p>
     * 企业可通过此接口编辑相关会议室的基本信息
     * <p>
     * 注意，会议室使用范围(range)为覆盖操作，而非增量添加
     * <p>
     * 如果需要修改位置信息，请同时输入城市，楼宇和楼层三个参数，已经生成的建筑，暂不支持修改经纬度。
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("oa/meetingroom/edit")
    WeComResponse edit(@Body RoomUpdateRequest request) throws WeComException;

    /**
     * 删除会议室
     * <p>
     * 企业可通过此接口删除指定的会议室
     *
     * @param meetingRoomId the meeting room id
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("oa/meetingroom/del")
    WeComResponse del(@Body MeetingRoomId meetingRoomId) throws WeComException;

    /**
     * 查询会议室的预定信息
     * <p>
     * 企业可通过此接口查询相关会议室在指定时间段的预定情况，如是否已被预定，预定者的userid等信息，不支持跨天查询。
     * <p>
     * 如果需要根据位置信息查询，则需要保证其上一级的位置信息已填写，即如需使用楼宇进行过滤，则必须同时填写城市字段。
     *
     * @param request the request
     * @return the booking info
     * @throws WeComException the weComException
     */
    @POST("oa/meetingroom/get_booking_info")
    BookingInfoResponse getBookingInfo(@Body BookingInfoRequest request) throws WeComException;

    /**
     * 预定会议室
     * <p>
     * 企业可通过此接口预定会议室并自动关联日程。
     * <p>
     * 最小预定时长为30分钟；
     * 预定时间和结束时间会自动按30分钟取整，即如果传入的开始和结束时间戳分别对应时间为15:15和15:45，则预定时会自动取整为15:00和16:00；
     * 此API仅可预定无需审批的会议室；
     * 如果当前时间已经晚于预定时间，则按以下情况进行处理：
     * 1.当前已过预定结束时间，则不允许预定
     * 2.当前在预定开始时间15分钟内，则允许预定
     * 3.当前已超过预定开始时间15分钟，则自动转换预定开始时间到下一个时间窗口，即增加30分钟到开始时间
     *
     * @param request the request
     * @return the booking response
     * @throws WeComException the weComException
     */
    @POST("oa/meetingroom/book")
    BookingResponse book(@Body BookingRequest request) throws WeComException;

    /**
     * 通过日程预定会议室
     * <p>
     * 企业可通过此接口为指定日程预定会议室，支持重复日程预定，仅可预定无需审批的会议室
     * <p>
     * 注意：通过日程预定会议室后，该日程将不能通过更新日程接口进行编辑，而只能调用新增日程参与者与删除日程参与者接口。
     * 如果需要更新日程的时间等字段，可以先取消会议室预定，再调用更新日程接口，之后再重新预定会议室。
     *
     * @param request the request
     * @return the booking result response
     * @throws WeComException the weComException
     */
    @POST("oa/meetingroom/book_by_schedule")
    BookingResultResponse bookBySchedule(@Body ScheduleBookingRequest request) throws WeComException;

    /**
     * 通过会议预定会议室
     * <p>
     * 企业可通过此接口为指定会议预定会议室，支持重复会议预定，仅可预定无需审批的会议室
     *
     * @param request the request
     * @return the booking result response
     * @throws WeComException the weComException
     */
    @POST("oa/meetingroom/book_by_meeting")
    BookingResultResponse bookByMeeting(@Body MeetBookingRequest request) throws WeComException;

    /**
     * 取消预定会议室
     * <p>
     * 企业可通过此接口取消会议室的预定
     *
     * @param request the request
     * @return the booking result response
     * @throws WeComException the weComException
     */
    @POST("oa/meetingroom/cancel_book")
    WeComResponse cancelBook(@Body CancelBookRequest request) throws WeComException;

    /**
     * 根据会议室预定ID查询预定详情
     * <p>
     * 企业可通过此接口根据预定id查询相关会议室的预定情况
     *
     * @param request the request
     * @return the booking result response
     * @throws WeComException the weComException
     */
    @POST("oa/meetingroom/bookinfo/get")
    RoomBookingResponse getBookInfo(@Body RoomBookingRequest request) throws WeComException;
}
