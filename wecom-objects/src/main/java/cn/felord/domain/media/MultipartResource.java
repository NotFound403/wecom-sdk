package cn.felord.domain.media;

import cn.felord.utils.FileTools;
import lombok.Getter;
import okhttp3.MediaType;

import java.io.IOException;
import java.io.InputStream;

/**
 * The type Multipart resource.
 *
 * @author dax
 * @since 2023 /6/27 10:24
 */
@Getter
public class MultipartResource {
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
        this.mediaType = mediaType;
        this.fileName = fileName;
        this.source = source;
    }
}
