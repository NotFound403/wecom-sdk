package cn.felord.utils;

import cn.felord.common.FileMediaType;
import cn.felord.common.MultipartResource;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.util.Objects;

/**
 * The type Media util.
 *
 * @author xiafang
 * @since 2023 /8/18 10:00
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
