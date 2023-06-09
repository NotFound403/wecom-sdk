package cn.felord.api;

import cn.felord.domain.MediaResponse;
import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * The type Media api.
 *
 * @author n1
 * @since 2021 /6/19 9:59
 */
public interface MediaApi {


    /**
     * 上传附件资源
     *
     * @param media              the media
     * @param mediaType          the media type
     * @param attachmentType     the attachment type
     * @param contentDisposition the content disposition
     * @return the media response
     */
    @Multipart
    @POST("media/upload_attachment")
    Single<MediaResponse> uploadAttachment(@Part("media") MultipartBody media,
                                           @Query("media_type") String mediaType,
                                           @Query("attachment_type") int attachmentType,
                                           @Header("Content-Disposition") String contentDisposition);

    /**
     * 上传临时素材
     *
     * @param media              the media
     * @param mediaType          the media type
     * @param contentDisposition the content disposition
     * @return the media response
     */
    @Multipart
    @POST("media/upload")
    Single<MediaResponse> uploadMedia(@Part("media") MultipartBody media,
                                      @Query("media_type") String mediaType,
                                      @Header("Content-Disposition") String contentDisposition);

    /**
     * 上传图片
     *
     * @param media              the media
     * @param contentDisposition the content disposition
     * @return the media response
     */
    @Multipart
    @POST("media/uploadimg")
    Single<MediaResponse> uploadImage(@Part("media") MultipartBody media,
                                      @Header("Content-Disposition") String contentDisposition);
}
