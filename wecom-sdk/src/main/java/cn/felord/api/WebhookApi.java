/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.media.MediaResponse;
import cn.felord.domain.webhook.WebhookBody;
import cn.felord.utils.FileMediaType;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

import java.io.File;

/**
 * 群机器人
 *
 * @author dax
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
    public <B extends WebhookBody> WeComResponse send(String key, B body) {
        return internalWebhookApi.send(key, body);
    }

    /**
     * 上传素材
     *
     * @param webhookKey the webhook key
     * @param file       the file
     * @return the media response
     */
    public MediaResponse uploadMedia(String webhookKey, File file) {
        String mediaTypeStr = FileMediaType.fromFileName(file.getName());
        RequestBody requestBody = RequestBody.create(file, MediaType.parse(mediaTypeStr));
        MultipartBody media = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("media", file.getName(), requestBody)
                .build();
        return internalWebhookApi.uploadMedia(webhookKey, "file", media);
    }


}
