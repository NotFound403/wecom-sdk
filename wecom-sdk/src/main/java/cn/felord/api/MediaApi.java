package cn.felord.api;

import cn.felord.domain.MediaResponse;
import cn.felord.enumeration.MediaAttachmentType;
import cn.felord.enumeration.MediaTypeEnum;
import io.reactivex.rxjava3.core.Single;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Query;

import java.io.File;

/**
 * The type Media api.
 *
 * @author xiafang
 * @since 2023 /6/10 17:09
 */
public class MediaApi {
    private final InternalMediaApi internalMediaApi;


    /**
     * Instantiates a new Media api.
     *
     * @param retrofit the retrofit
     */
    MediaApi(Retrofit retrofit) {
        this.internalMediaApi = retrofit.create(InternalMediaApi.class);
    }

    /**
     * 上传附件资源
     *
     * @param mediaType      the media type
     * @param attachmentType the attachment type
     * @param media          the media
     * @return the media response
     */
    public Single<MediaResponse> uploadAttachment(MediaTypeEnum mediaType,
                                                  MediaAttachmentType attachmentType,
                                                  @Body MultipartBody media) {
        return internalMediaApi.uploadAttachment();
    }

    /**
     * 上传临时素材
     *
     * @param mediaType the media type
     * @param media     the media
     * @return the media response
     */
    public Single<MediaResponse> uploadMedia(@Query("media_type") String mediaType,
                                             @Body MultipartBody media) {

    }

    /**
     * 上传图片
     *
     * @param file the file
     * @return the media response
     */
    public Single<MediaResponse> uploadImage(File file) {
        RequestBody requestBody = RequestBody.create(file, MediaType.parse("image/png"));
        MultipartBody media = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("media", file.getName(), requestBody)
                .build();
        return internalMediaApi.uploadImage(media);
    }
}
