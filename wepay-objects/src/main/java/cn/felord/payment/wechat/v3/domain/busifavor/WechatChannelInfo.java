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

package cn.felord.payment.wechat.v3.domain.busifavor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Wechat channel info.
 *
 * @author dax
 * @since 2024/8/23
 */
@ToString
@Getter
public class WechatChannelInfo {
    private final String finderId;
    private final String finderVideoId;
    private final String finderVideoCoverImageUrl;

    /**
     * Instantiates a new Wechat channel info.
     *
     * @param finderId                 the finder id
     * @param finderVideoId            the finder video id
     * @param finderVideoCoverImageUrl the finder video cover image url
     */
    @JsonCreator
    public WechatChannelInfo(@JsonProperty("finder_id") String finderId,
                             @JsonProperty("finder_video_id") String finderVideoId,
                             @JsonProperty("finder_video_cover_image_url") String finderVideoCoverImageUrl) {
        this.finderId = finderId;
        this.finderVideoId = finderVideoId;
        this.finderVideoCoverImageUrl = finderVideoCoverImageUrl;
    }
}
