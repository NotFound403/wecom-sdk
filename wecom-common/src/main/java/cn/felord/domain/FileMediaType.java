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

package cn.felord.domain;

import cn.felord.utils.StringUtils;
import okhttp3.MediaType;

import java.util.Arrays;
import java.util.Objects;

/**
 * The enum File media type.
 *
 * @author dax
 * @since 2024/6/10 17:52
 */
public enum FileMediaType {
    /**
     * All
     */
    ALL("*", "application/octet-stream"),

    /**
     * Pdf
     */
    PDF("pdf", "application/pdf"),

    /**
     * Xml
     */
    XML("xml", "application/xml"),

    /**
     * Gif
     */
    GIF("gif", "image/gif"),

    /**
     * Jpeg
     */
    JPEG("jpeg", "image/jpeg"),

    /**
     * Jpg
     */
    JPG("jpg", "image/jpeg"),

    /**
     * Png
     */
    PNG("png", "image/png"),

    /**
     * Markdown
     */
    MARKDOWN("md", "text/markdown"),

    /**
     * Mp4
     */
    MP4("mp4", "video/mp4"),
    /**
     * Amr
     */
    AMR("amr", "audio/amr"),
    /**
     * Speex
     */
    SPEEX("speex", "voice/speex"),

    /**
     * Zip
     */
    ZIP("zip", "application/x-zip-compressed"),

    /**
     * Ppt
     */
    PPT("ppt", "application/vnd.ms-powerpoint"),

    /**
     * Pptx
     */
    PPTX("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"),

    /**
     * Doc
     */
    DOC("doc", "application/msword"),

    /**
     * Docx
     */
    DOCX("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"),

    /**
     * Xls
     */
    XLS("xls", "application/vnd.ms-excel"),

    /**
     * Xlsx
     */
    XLSX("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");


    private final String extension;
    private final String mediaType;

    FileMediaType(String extension, String mediaType) {
        this.extension = extension;
        this.mediaType = mediaType;
    }


    /**
     * 根据文件扩展名检索对应的FileMediaType
     *
     * @param fileName the file name
     * @return the media type
     */
    public static FileMediaType fromFileName(String fileName) {
        String filenameExtension = StringUtils.getFilenameExtension(fileName);
        return Arrays.stream(FileMediaType.values())
                .filter(fileMediaType ->
                        Objects.equals(fileMediaType.extension, filenameExtension))
                .findAny()
                .orElse(FileMediaType.ALL);

    }

    /**
     * 根据MediaType查找FileMediaType
     *
     * @param mediaType the media type
     * @return the file media type
     */
    public static FileMediaType extension(MediaType mediaType) {
        return Arrays.stream(FileMediaType.values())
                .filter(fileMediaType ->
                        Objects.equals(fileMediaType.mediaType, mediaType.type()))
                .findAny()
                .orElse(FileMediaType.ALL);

    }

    /**
     * Extension string.
     *
     * @return the string
     */
    public String extension() {
        return extension;
    }

    /**
     * Media type string.
     *
     * @return the string
     */
    public MediaType mediaType() {
        return MediaType.parse(mediaType);
    }
}
