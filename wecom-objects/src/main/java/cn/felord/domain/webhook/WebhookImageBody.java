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

package cn.felord.domain.webhook;

import cn.felord.utils.Algorithms;
import cn.felord.utils.Base64Utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 图片消息
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class WebhookImageBody extends WebhookBody {
    private final WebhookImage image;

    /**
     * Instantiates a new Webhook image body.
     *
     * @param image the image
     */
    WebhookImageBody(WebhookImage image) {
        super("image");
        this.image = image;
    }


    /**
     * The type Webhook image.
     */
    @ToString
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class WebhookImage {
        private final String base64;
        private final String md5;
    }

    /**
     * From webhook image body.
     *
     * @param imageStream the image stream
     * @return the webhook image body
     * @throws IOException the io exception
     */
    public static WebhookImageBody from(InputStream imageStream) throws IOException {
        String base64;
        String md5;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int read;
            byte[] buffer = new byte[1024];
            while ((read = imageStream.read(buffer)) != -1) {
                baos.write(buffer, 0, read);
            }
            byte[] data = baos.toByteArray();
            base64 = Base64Utils.encodeToString(data);
            md5 = Algorithms.md5Hex(data, false);
        } finally {
            imageStream.close();
        }
        return WebhookImageBody.from(base64, md5);
    }

    /**
     * From webhook image body.
     *
     * @param base64 the base64
     * @param md5    the md5
     * @return the webhook image body
     */
    public static WebhookImageBody from(String base64, String md5) {
        return new WebhookImageBody(new WebhookImage(base64, md5));
    }
}
