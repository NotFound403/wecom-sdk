package cn.felord.utils;

import cn.felord.WeComException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/**
 * @author dax
 * @since 2023/6/27 10:52
 */
public final class FileTools {
    public static final int BUFFER_SIZE = 4096;

    public static byte[] copyToByteArray(InputStream in) throws IOException {
        if (in == null) {
            return new byte[0];
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream(BUFFER_SIZE);
        copy(in, out);
        return out.toByteArray();
    }

    public static int copy(InputStream in, OutputStream out) throws IOException {
        if (Objects.isNull(in)) {
            throw new WeComException("InputStream is null");
        }
        if (Objects.isNull(out)) {
            throw new WeComException("OutputStream is null");
        }
        try {
            int byteCount = 0;
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                byteCount += bytesRead;
            }
            out.flush();
            return byteCount;
        } finally {
            try {
                in.close();
            } catch (IOException ignored) {
            }
            try {
                out.close();
            } catch (IOException ignored) {
            }
        }
    }
}
