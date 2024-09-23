
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

package cn.felord.domain.media;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Media upload request.
 */
@ToString
@Getter
public class MediaUploadRequest {

    private final int scene;
    private final String filename;
    private final String md5;
    private final String type;
    private final String url;

    /**
     * Instantiates a new Media upload request.
     *
     * @param filename the filename
     * @param md5      the md 5
     * @param url      the url
     * @param type     the type
     */
    MediaUploadRequest(String filename, String md5, String url, String type) {
        this.scene = 1;
        this.filename = filename;
        this.md5 = md5;
        this.type = type;
        this.url = url;
    }

    /**
     * 视频
     *
     * @param filename the filename
     * @param md5      the md 5
     * @param url      the url
     * @return the media upload request
     */
    public static MediaUploadRequest video(String filename, String md5, String url) {
        return new MediaUploadRequest(filename, md5, url, "video");
    }

    /**
     * 普通文件
     *
     * @param filename the filename
     * @param md5      the md 5
     * @param url      the url
     * @return the media upload request
     */
    public static MediaUploadRequest file(String filename, String md5, String url) {
        return new MediaUploadRequest(filename, md5, url, "file");
    }
}
