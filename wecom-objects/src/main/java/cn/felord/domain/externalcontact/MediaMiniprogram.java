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
 * @author dax
 * @since 2021/5/18 16:08
 */
@ToString
@Getter
public class MediaMiniprogram {
    private final String title;
    private final String picMediaId;
    private final String appid;
    private final String page;

    @JsonCreator
    public MediaMiniprogram(@JsonProperty("title") String title,
                            @JsonProperty("pic_media_id") String picMediaId,
                            @JsonProperty("appid") String appid,
                            @JsonProperty("page") String page) {
        this.title = title;
        this.picMediaId = picMediaId;
        this.appid = appid;
        this.page = page;
    }
}
