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

package cn.felord.utils;

import okhttp3.MediaType;

import java.util.Arrays;
import java.util.Objects;

/**
 * The enum File media type.
 *
 * @author dax
 * @since 2023 /6/10 17:52
 */
public enum FileMediaType {
    /**
     * All
     */
    ALL("*", MediaType.parse("*/*")),

    /**
     * Pdf
     */
    PDF("pdf", MediaType.parse("application/pdf")),

    /**
     * Xml
     */
    XML("xml", MediaType.parse("application/xml")),

    /**
     * Gif
     */
    GIF("gif", MediaType.parse("image/gif")),

    /**
     * Jpeg
     */
    JPEG("jpeg", MediaType.parse("image/jpeg")),

    /**
     * Jpg
     */
    JPG("jpg", MediaType.parse("image/jpeg")),

    /**
     * Png
     */
    PNG("png", MediaType.parse("image/png")),

    /**
     * Markdown
     */
    MARKDOWN("md", MediaType.parse("text/markdown")),

    /**
     * Mp4
     */
    MP4("mp4", MediaType.parse("video/mp4")),
    /**
     * Amr
     */
    AMR("amr", MediaType.parse("audio/amr")),
    /**
     * Speex
     */
    SPEEX("speex", MediaType.parse("voice/speex")),

    /**
     * Zip
     */
    ZIP("zip", MediaType.parse("application/x-zip-compressed")),

    /**
     * Ppt
     */
    PPT("ppt", MediaType.parse("application/vnd.ms-powerpoint")),

    /**
     * Pptx
     */
    PPTX("pptx", MediaType.parse("application/vnd.openxmlformats-officedocument.presentationml.presentation")),

    /**
     * Doc
     */
    DOC("doc", MediaType.parse("application/msword")),

    /**
     * Docx
     */
    DOCX("docx", MediaType.parse("application/vnd.openxmlformats-officedocument.wordprocessingml.document")),

    /**
     * Xls
     */
    XLS("xls", MediaType.parse("application/vnd.ms-excel")),

    /**
     * Xlsx
     */
    XLSX("xlsx", MediaType.parse("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));


    private final String extension;
    private final MediaType mediaType;

    FileMediaType(String extension, MediaType mediaType) {
        this.extension = extension;
        this.mediaType = mediaType;
    }


    /**
     * From file name media type.
     *
     * @param fileName the file name
     * @return the media type
     */
    public static MediaType fromFileName(String fileName) {
        String filenameExtension = StringUtils.getFilenameExtension(fileName);
        return Arrays.stream(FileMediaType.values())
                .filter(fileMediaType ->
                        Objects.equals(fileMediaType.extension, filenameExtension))
                .findAny()
                .orElse(FileMediaType.ALL).mediaType;

    }
}
