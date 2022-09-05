package cn.felord.domain;

import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
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

    public WeChatMultipartFile(String name, @Nullable byte[] content) {
        this(name, "", null, content);
    }

    public WeChatMultipartFile(String name, InputStream contentStream) throws IOException {
        this(name, "", null, FileCopyUtils.copyToByteArray(contentStream));
    }

    public WeChatMultipartFile(String name, @Nullable String originalFilename, @Nullable String contentType, @Nullable byte[] content) {
        Assert.hasLength(name, "Name must not be null");
        this.name = name;
        this.originalFilename = originalFilename != null ? originalFilename : "";
        this.contentType = contentType;
        this.content = content != null ? content : new byte[0];
    }

    public WeChatMultipartFile(String name, @Nullable String originalFilename, @Nullable String contentType, InputStream contentStream) throws IOException {
        this(name, originalFilename, contentType, FileCopyUtils.copyToByteArray(contentStream));
    }


    @SneakyThrows
    public static MultipartFile fromResource(Resource resource){
        return new WeChatMultipartFile(resource.getFilename(),resource.getInputStream());
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

    public byte[] getBytes() throws IOException {
        return this.content;
    }

    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    public void transferTo(File dest) throws IOException, IllegalStateException {
        FileCopyUtils.copy(this.content, dest);
    }
}