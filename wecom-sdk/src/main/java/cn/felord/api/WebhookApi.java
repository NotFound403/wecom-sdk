/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.MediaResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.webhook.WebhookBody;
import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * 群机器人
 *
 * @author n1
 * @since 2021 /6/16 19:35
 */
public interface WebhookApi {
    /**
     * 发送机器人信息
     *
     * @param key  the key
     * @param body the body
     * @return the we com response
     */
    @POST("webhook/send")
    Single<WeComResponse> send(@Query("key") String key, @Body WebhookBody body);

    /**
     * 上传素材
     *
     * @param webhookKey         the webhook key
     * @param type               the type
     * @param media              the media
     * @param contentDisposition the content disposition
     * @return the media response
     */
    @Multipart
    @POST("webhook/upload_media")
    Single<MediaResponse> uploadMedia(@Query("key") String webhookKey,
                                      @Query("type") String type,
                                      @Part("media") MultipartBody media,
                                      @Header("Content-Disposition") String contentDisposition);
    /**
     * 上传素材
     *
     * @param webhookKey the webhook key
     * @param media      the media
     * @return the media response
     */
/*    public MediaResponse uploadMedia(String webhookKey, WeChatMultipartFile media) {
        String name = media.getName();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ContentDisposition contentDisposition = ContentDisposition.builder("form-data")
                .name("media")
                .filename(name)
                .build();
        headers.setContentDisposition(contentDisposition);
        MultiValueMap<Object, Object> body = new LinkedMultiValueMap<>();
        body.add("media", media.getResource());
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("key", webhookKey);
        query.add("type", "file");
        return workWeChatApiClient.post(WeComEndpoint.WEBHOOK_UPLOAD, query, body, headers, MediaResponse.class);
    }*/

}
