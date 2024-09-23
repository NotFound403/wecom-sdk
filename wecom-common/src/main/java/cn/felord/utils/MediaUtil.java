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

package cn.felord.utils;

import cn.felord.domain.FileMediaType;
import cn.felord.domain.MultipartResource;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.util.Objects;

/**
 * The type Media util.
 *
 * @author dax
 * @since 2024/8/18 10:00
 */
public final class MediaUtil {
    private MediaUtil() {
    }

    /**
     * To multipart body multipart body.
     *
     * @param resource the resource
     * @return the multipart body
     */
    public static MultipartBody toMultipartBody(MultipartResource resource) {
        String fileName = resource.getFileName();
        MediaType mediaType = Objects.nonNull(resource.getMediaType()) ?
                resource.getMediaType() : FileMediaType.fromFileName(fileName).mediaType();
        RequestBody requestBody = RequestBody.create(resource.getSource(), mediaType);
        return new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("media", fileName, requestBody)
                .build();
    }
}
