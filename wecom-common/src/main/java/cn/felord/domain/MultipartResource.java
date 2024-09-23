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

import cn.felord.utils.FileTools;
import okhttp3.MediaType;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Multipart resource.
 *
 * @author dax
 * @since 2024/6/27 10:24
 */
public class MultipartResource {
    private static final Pattern pattern = Pattern.compile("\\.([^.]+)$");
    private final MediaType mediaType;
    private final String fileName;
    private final byte[] source;


    /**
     * Instantiates a new Multipart resource.
     *
     * @param fileName    the file name
     * @param inputStream the input stream
     * @throws IOException the io exception
     */
    public MultipartResource(String fileName, InputStream inputStream) throws IOException {
        this(null, fileName, inputStream);
    }

    /**
     * Instantiates a new Multipart resource.
     *
     * @param mediaType   the media type
     * @param fileName    the file name
     * @param inputStream the input stream
     * @throws IOException the io exception
     */
    public MultipartResource(MediaType mediaType, String fileName, InputStream inputStream) throws IOException {
        this(mediaType, fileName, FileTools.copyToByteArray(inputStream));
    }

    /**
     * Instantiates a new Multipart resource.
     *
     * @param fileName the file name
     * @param source   the source
     */
    public MultipartResource(String fileName, byte[] source) {
        this(null, fileName, source);
    }

    /**
     * Instantiates a new Multipart resource.
     *
     * @param mediaType the media type
     * @param fileName  the fileName
     * @param source    the source
     */
    public MultipartResource(MediaType mediaType, String fileName, byte[] source) {
        Matcher matcher = pattern.matcher(fileName);
        if (!matcher.find()) {
            throw new IllegalArgumentException("the fileName must have extension, eg. pic.png");
        }
        this.mediaType = mediaType;
        this.fileName = fileName;
        this.source = source;
    }

    /**
     * Gets media type.
     *
     * @return the media type
     */
    public MediaType getMediaType() {
        return mediaType;
    }

    /**
     * Gets file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Get source byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getSource() {
        return source;
    }
}
