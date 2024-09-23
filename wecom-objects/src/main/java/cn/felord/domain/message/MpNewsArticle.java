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

package cn.felord.domain.message;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Mp news article.
 *
 * @author felord
 * @since 2021 /11/22 17:25
 */
@ToString
@Getter
public class MpNewsArticle extends MessageArticle {

    private final String thumbMediaId;
    private String author;
    private String contentSourceUrl;
    private String content;
    private String digest;

    /**
     * Instantiates a new Mp news article.
     *
     * @param title        the title
     * @param thumbMediaId the thumb media id
     */
    public MpNewsArticle(String title, String thumbMediaId) {
        super(title);
        this.thumbMediaId = thumbMediaId;
    }

    /**
     * Author mp news article.
     *
     * @param author the author
     * @return the mp news article
     */
    public MpNewsArticle author(String author) {
        this.author = author;
        return this;
    }

    /**
     * Content source url mp news article.
     *
     * @param contentSourceUrl the content source url
     * @return the mp news article
     */
    public MpNewsArticle contentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
        return this;
    }

    /**
     * Content mp news article.
     *
     * @param content the content
     * @return the mp news article
     */
    public MpNewsArticle content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Digest mp news article.
     *
     * @param digest the digest
     * @return the mp news article
     */
    public MpNewsArticle digest(String digest) {
        this.digest = digest;
        return this;
    }
}
