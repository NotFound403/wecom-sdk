package cn.felord.api;

import cn.felord.domain.GenericResponse;
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
    Single<MediaResponse> uploadMedia(@Query("media_type") String mediaType,
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

}
