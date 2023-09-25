package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.checkin.CheckinDataRequest;
import cn.felord.domain.checkin.CheckinDataResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author dax
 * @since 2023/9/25
 */
public interface CheckinApi {
    @POST("checkin/getcheckindata")
    CheckinDataResponse getCheckinData(@Body CheckinDataRequest request) throws WeComException;

}
