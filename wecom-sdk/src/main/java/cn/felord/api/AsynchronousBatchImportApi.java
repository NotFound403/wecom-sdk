package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.contactbook.async.BatchPartyRequest;
import cn.felord.domain.contactbook.async.BatchResultResponse;
import cn.felord.domain.contactbook.async.BatchUserRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 异步导入接口
 *
 * @author n1
 * @since 2021 /6/18 16:25
 */
public interface AsynchronousBatchImportApi {


    /**
     * 增量更新成员
     *
     * @param request the request
     * @return the generic response
     */
    @POST("batch/syncuser")
    Single<GenericResponse<String>> batchSyncUser(@Body BatchUserRequest request);

    /**
     * 全量覆盖成员
     *
     * @param request the request
     * @return the generic response
     */
    @POST("batch/replaceuser")
    Single<GenericResponse<String>> batchSyncReplaceUser(@Body BatchUserRequest request);

    /**
     * 全量覆盖部门
     *
     * @param request the request
     * @return the generic response
     */
    @POST("batch/replaceparty")
    Single<GenericResponse<String>> batchSyncReplaceParty(@Body BatchPartyRequest request);

    /**
     * 获取异步任务结果
     *
     * @param jobId the job id
     * @return the result
     */
    @GET("batch/getresult")
    Single<BatchResultResponse> getResult(@Query("jobid") String jobId);
}
