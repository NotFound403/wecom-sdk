package cn.felord.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author felord.cn
 * @see MultipartFile
 */
public class WeChatMultipartFile implements MultipartFile {
    private final String name;
    private final String originalFilename;
    @Nullable
    private final String contentType;
    private final byte[] content;

    public WeChatMultipartFile(@NonNull String name, @Nullable String originalFilename, @Nullable String contentType, InputStream contentStream) throws IOException {
        this(name, originalFilename, contentType, FileCopyUtils.copyToByteArray(contentStream));
    }

    public WeChatMultipartFile(@NonNull String name, @Nullable String originalFilename, @Nullable String contentType, byte[] content) {
        Assert.hasLength(name, "Name must not be null");
        this.name = name;
        this.originalFilename = originalFilename;
        this.contentType = contentType;
        this.content = content;
    }

    public static WeChatMultipartFile from(MultipartFile file) throws IOException {
        return new WeChatMultipartFile(file.getName(), file.getOriginalFilename(), file.getContentType(), file.getInputStream());
    }

    public static WeChatMultipartFile copy(MultipartFile file, ByteArrayOutputStream outputStream) throws IOException {
        FileCopyUtils.copy(file.getInputStream(), outputStream);
        byte[] bytes = outputStream.toByteArray();
        return new WeChatMultipartFile(file.getName(), file.getOriginalFilename(), file.getContentType(), bytes);
    }

    public String getName() {
        return this.name;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    @Nullable
    public String getContentType() {
        return this.contentType;
    }

    public boolean isEmpty() {
        return this.content.length == 0;
    }

    public long getSize() {
        return this.content.length;
    }

    public byte[] getBytes() {
        return this.content;
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.content);
    }

    public void transferTo(File dest) throws IOException, IllegalStateException {
        FileCopyUtils.copy(this.content, dest);
    }
}