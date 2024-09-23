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

import cn.felord.enumeration.MsgAttachType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Link msg attachment.
 *
 * @author dax
 * @since 2021 /4/22 14:53
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class LinkMsgAttachment extends MsgAttachment {
    private final Link link;

    /**
     * Instantiates a new Link msg attachment.
     *
     * @param link the link
     */
    @JsonCreator
    LinkMsgAttachment(@JsonProperty("link") Link link) {
        super(MsgAttachType.LINK);
        this.link = link;
    }


    /**
     * Instantiates a new Link msg attachment.
     *
     * @param title  the title
     * @param url    the url
     * @param picurl the picurl
     * @param desc   the desc
     */
    public LinkMsgAttachment(String title, String url, String picurl, String desc) {
        this(new Link(title, url, picurl, desc));
    }

    /**
     * Instantiates a new Link msg attachment.
     *
     * @param title  the title
     * @param url    the url
     * @param picurl the picurl
     */
    public LinkMsgAttachment(String title, String url, String picurl) {
        this(new Link(title, url, picurl, null));
    }

    /**
     * Instantiates a new Link msg attachment.
     *
     * @param title the title
     * @param url   the url
     */
    public LinkMsgAttachment(String title, String url) {
        this(new Link(title, url, null, null));
    }
}
