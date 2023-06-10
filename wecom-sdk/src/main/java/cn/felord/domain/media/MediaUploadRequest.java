
package cn.felord.domain.media;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Media upload request.
 */
@ToString
@Getter
public class MediaUploadRequest {

    private final int scene = 1;
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
