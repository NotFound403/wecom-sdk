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
import cn.felord.domain.WeChatMultipartFile;
import cn.felord.enumeration.MediaAttachmentType;
import cn.felord.enumeration.MediaTypeEnum;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * The type Media api.
 *
 * @author n1
 * @since 2021 /6/19 9:59
 */
public class MediaApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Media api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    MediaApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * Upload attachment media response.
     *
     * @param media     the media
     * @param mediaType the media type
     * @param type      the type
     * @return the media response
     */
    public MediaResponse uploadAttachment(WeChatMultipartFile media, MediaTypeEnum mediaType, MediaAttachmentType type) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("media_type", mediaType.name().toLowerCase());
        query.add("attachment_type", String.valueOf(type.getType()));
        return doUpload(media, WeComEndpoint.MEDIA_UPLOAD_ATTACHMENT, query);
    }

    /**
     * 上传临时素材
     *
     * @param media     the media
     * @param mediaType the media type
     * @return the media response
     */
    public MediaResponse uploadMedia(WeChatMultipartFile media, MediaTypeEnum mediaType) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("type", mediaType.name().toLowerCase());
        return doUpload(media, WeComEndpoint.MEDIA_UPLOAD, query);
    }

    /**
     * 上传图片
     *
     * @param media the media
     * @return the media response
     */
    public MediaResponse uploadImage(WeChatMultipartFile media) {
        return doUpload(media, WeComEndpoint.MEDIA_UPLOAD_IMG, null);
    }

    private MediaResponse doUpload(WeChatMultipartFile media, WeComEndpoint endpoint, MultiValueMap<String, String> query) {
        String name = media.getName();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ContentDisposition contentDisposition = ContentDisposition.builder("form-data")
                .name("media")
                .filename(name)
                .build();
        headers.setContentDisposition(contentDisposition);
        return this.doUpload(media, headers, endpoint, query);
    }

    private MediaResponse doUpload(WeChatMultipartFile media, HttpHeaders headers, WeComEndpoint endpoint, MultiValueMap<String, String> query) {
        MultiValueMap<Object, Object> body = new LinkedMultiValueMap<>();
        body.add("media", media.getResource());
        return workWeChatApiClient.post(endpoint, query, body, headers, MediaResponse.class);
    }

}
