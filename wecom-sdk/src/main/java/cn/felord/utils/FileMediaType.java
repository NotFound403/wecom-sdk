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
