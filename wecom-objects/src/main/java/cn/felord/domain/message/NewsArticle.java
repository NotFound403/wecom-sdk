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
 * The type News article.
 *
 * @author felord
 * @since 2021 /11/22 17:25
 */
@ToString
@Getter
public class NewsArticle extends MessageArticle {

    private String description;
    private String url;
    private String picurl;
    private String appid;
    private String pagepath;

    /**
     * Instantiates a new News article.
     *
     * @param title the title
     */
    public NewsArticle(String title) {
        super(title);
    }

    /**
     * Description news article.
     *
     * @param description the description
     * @return the news article
     */
    public NewsArticle description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Url news article.
     *
     * @param url the url
     * @return the news article
     */
    public NewsArticle url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Picurl news article.
     *
     * @param picurl the picurl
     * @return the news article
     */
    public NewsArticle picurl(String picurl) {
        this.picurl = picurl;
        return this;
    }

    /**
     * Appid news article.
     *
     * @param appid the appid
     * @return the news article
     */
    public NewsArticle appid(String appid) {
        this.appid = appid;
        return this;
    }

    /**
     * Pagepath news article.
     *
     * @param pagepath the pagepath
     * @return the news article
     */
    public NewsArticle pagepath(String pagepath) {
        this.pagepath = pagepath;
        return this;
    }
}
