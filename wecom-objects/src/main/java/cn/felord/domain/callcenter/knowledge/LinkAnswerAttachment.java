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

package cn.felord.domain.callcenter.knowledge;

import cn.felord.domain.callcenter.KfLink;
import cn.felord.enumeration.AnswerAttachType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Link answer attachment.
 *
 * @author dax
 * @since 2024/10/5
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class LinkAnswerAttachment extends AnswerAttachment {
    private final KfLink link;


    /**
     * Instantiates a new Link answer attachment.
     *
     * @param link the link
     */
    @JsonCreator
    LinkAnswerAttachment(@JsonProperty("link") KfLink link) {
        super(AnswerAttachType.LINK);
        this.link = link;
    }

    /**
     * From link answer attachment.
     *
     * @param title the title
     * @param url   the url
     * @return the link answer attachment
     */
    public static LinkAnswerAttachment from(String title, String url) {
        return from(title, url, null, null);
    }

    /**
     * From link answer attachment.
     *
     * @param title the title
     * @param url   the url
     * @param desc  the desc
     * @return the link answer attachment
     */
    public static LinkAnswerAttachment from(String title, String url, String desc) {
        return from(title, url, desc, null);
    }

    /**
     * From link answer attachment.
     *
     * @param title  the title
     * @param url    the url
     * @param desc   the desc
     * @param picUrl the pic url
     * @return the video answer attachment
     */
    public static LinkAnswerAttachment from(String title, String url, String desc, String picUrl) {
        KfLink kfLink = new KfLink();
        kfLink.setTitle(title);
        kfLink.setUrl(url);
        kfLink.setDesc(desc);
        kfLink.setPicUrl(picUrl);
        return new LinkAnswerAttachment(kfLink);
    }
}
