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

package cn.felord.domain.externalcontact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Link.
 *
 * @author dax
 * @since 2021 /3/14 16:07
 */
@ToString
@Getter
public class Link {
    private final String title;
    private final String url;
    private String picurl;
    private String desc;

    /**
     * Instantiates a new Link.
     *
     * @param title the title
     * @param url   the url
     */
    public Link(String title, String url) {
        this(title, url, null, null);
    }

    /**
     * Instantiates a new Link.
     *
     * @param title  the title
     * @param url    the url
     * @param picurl the picurl
     * @param desc   the desc
     */
    @JsonCreator
    Link(@JsonProperty("title") String title, @JsonProperty("url") String url, @JsonProperty("picurl") String picurl, @JsonProperty("desc") String desc) {
        this.title = title;
        this.url = url;
        this.picurl = picurl;
        this.desc = desc;
    }

    /**
     * Picurl link.
     *
     * @param picurl the picurl
     * @return the link
     */
    public Link picurl(String picurl) {
        this.picurl = picurl;
        return this;
    }

    /**
     * Desc link.
     *
     * @param desc the desc
     * @return the link
     */
    public Link desc(String desc) {
        this.desc = desc;
        return this;
    }
}
