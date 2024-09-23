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

package cn.felord.reactive.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.common.JobId;
import cn.felord.domain.media.MediaJobResponse;
import cn.felord.domain.media.MediaResponse;
import cn.felord.domain.media.MediaUploadRequest;
import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;
import okhttp3.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 素材上传(内部)
 *
 * @author n1
 * @since 2021 /6/19 9:59
 */
interface InternalMediaApi {

    /**
     * 上传附件资源
     *
     * @param mediaType      the media type
     * @param attachmentType the attachment type
     * @param media          the media
     * @return the media response
     */
    @POST("media/upload_attachment")
    Single<MediaResponse> uploadAttachment(@Query("media_type") String mediaType,
                                           @Query("attachment_type") int attachmentType,
                                           @Body MultipartBody media);

    /**
     * 上传临时素材
     *
     * @param mediaType the media type
     * @param media     the media
     * @return the media response
     */
    @POST("media/upload")
    Single<MediaResponse> uploadMedia(@Query("type") String mediaType,
                                      @Body MultipartBody media);

    /**
     * 上传图片
     *
     * @param media the media
     * @return the media response
     */
    @POST("media/uploadimg")
    Single<MediaResponse> uploadImage(@Body MultipartBody media);

    /**
     * 获取临时素材
     *
     * @param mediaId the media id
     * @return the media
     */
    @GET("media/get")
    Single<Response> getMedia(@Query("media_id") String mediaId);

    /**
     * 获取高清语音素材
     *
     * @param mediaId the media id
     * @return the media
     */
    @GET("media/get/jssdk")
    Single<Response> getMediaJsSdk(@Query("media_id") String mediaId);

    /**
     * 生成异步上传任务
     * <p>
     * 图片（image）：暂不支持
     * 语音（voice） ：暂不支持
     * 视频（video） ：200MB，仅支持MP4格式
     * 普通文件（file）：200MB
     *
     * @param request the request
     * @return the media js sdk
     */
    @POST("media/upload_by_url")
    Single<GenericResponse<String>> uploadByUrl(@Body MediaUploadRequest request);

    /**
     * 查询异步任务结果
     *
     * @param jobId the job id
     * @return the upload by url result
     */
    @POST("media/get_upload_by_url_result")
    Single<MediaJobResponse> getUploadByUrlResult(@Body JobId jobId);

    /**
     * 创建对外收款账户-提交图片
     *
     * @param media the media
     * @return the generic response
     */
    @POST("miniapppay/upload_image")
    Single<GenericResponse<String>> uploadPayImage(@Body MultipartBody media);
}
