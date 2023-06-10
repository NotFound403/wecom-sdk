package cn.felord.api;

import cn.felord.domain.MediaResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.webhook.WebhookBody;
import io.reactivex.rxjava3.core.Single;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

import java.io.File;

/**
 * 群机器人
 *
 * @author xiafang
 * @since 2023 /6/10 15:42
 */
public class WebhookApi {
    private final InternalWebhookApi internalWebhookApi;

    /**
     * Instantiates a new Webhook api.
     *
     * @param retrofit the retrofit
     */
    WebhookApi(Retrofit retrofit) {
        this.internalWebhookApi = retrofit.create(InternalWebhookApi.class);
    }

    /**
     * 发送机器人信息
     *
     * @param <B>  the type parameter
     * @param key  the key
     * @param body the body
     * @return the we com response
     */
    public <B extends WebhookBody> Single<WeComResponse> send(String key, B body) {
        return internalWebhookApi.send(key, body);
    }

    /**
     * 上传素材
     *
     * @param webhookKey the webhook key
     * @param file       the file
     * @return the media response
     */
    public Single<MediaResponse> uploadMedia(String webhookKey, File file) {
        RequestBody requestBody = RequestBody.create(file, MediaType.parse("image/png"));
        MultipartBody media = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("media", file.getName(), requestBody)
                .build();
        return internalWebhookApi.uploadMedia(webhookKey, "file", media);
    }


}
