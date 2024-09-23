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

package cn.felord.mp.domain.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 封面摘要结构体名称
 *
 * @author dax
 * @since 2024/8/18 17:06
 */
@ToString
@Getter
public class AbstractInfo {
    /**
     * 封面摘要简介 24个字符
     */
    @JsonProperty("abstract")
    private final String info;
    /**
     * 封面图片列表，仅支持填入一 个封面图片链接，
     * 上传图片接口 上传获取图片获得链接，填写 非CDN链接会报错，并在此填入。 建议图片尺寸像素850*350
     */
    private final List<String> iconUrlList;

    /**
     * Instantiates a new Abstract info.
     *
     * @param info        the info
     * @param iconUrlList the icon url list
     */
    @JsonCreator
    public AbstractInfo(@JsonProperty("abstract") String info, @JsonProperty("icon_url_list") List<String> iconUrlList) {
        this.info = info;
        this.iconUrlList = iconUrlList;
    }
}
