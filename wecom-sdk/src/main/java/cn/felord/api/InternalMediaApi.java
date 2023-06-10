package cn.felord.api;

import cn.felord.domain.MediaResponse;
import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * The type Media api.
 *
 * @author n1
 * @since 2021 /6/19 9:59
 */
public interface InternalMediaApi {

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
    Single<MediaResponse> uploadWebhookMedia(@Query("media_type") String mediaType,
                                             @Body MultipartBody media);

    /**
     * 上传图片
     *
     * @param media the media
     * @return the media response
     */
    @POST("media/uploadimg")
    Single<MediaResponse> uploadImage(@Body MultipartBody media);

}
