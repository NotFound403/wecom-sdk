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

package cn.felord.domain.wedoc.doc;

import lombok.Getter;
import lombok.ToString;

/**
 * 插入图片
 *
 * @author dax
 * @since 2024 /8/9
 */
@ToString
@Getter
public class DocInsertImage {
    /**
     * 文本
     */
    private final String imageId;
    /**
     * 位置
     */
    private final DocLocation location;
    /**
     * 图片的宽，单位是像素（px）， 不传默认为图片原始宽度
     */
    private final Integer width;
    /**
     * 图片的高， 单位是像素（px），不传默认为图片原始高度
     */
    private final Integer height;

    /**
     * Instantiates a new Doc insert text.
     *
     * @param imageId the image id
     * @param index   the index
     * @param width   the width
     * @param height  the height
     */
    DocInsertImage(String imageId, int index, int width, int height) {
        this(imageId, new DocLocation(index), width, height);
    }

    /**
     * Instantiates a new Doc insert image.
     *
     * @param imageId the image id
     * @param index   the index
     */
    DocInsertImage(String imageId, int index) {
        this(imageId, new DocLocation(index), null, null);
    }

    /**
     * Instantiates a new Doc insert text.
     *
     * @param imageId  the image id
     * @param location the location
     * @param width    the width
     * @param height   the height
     */
    DocInsertImage(String imageId, DocLocation location, Integer width, Integer height) {
        this.imageId = imageId;
        this.location = location;
        this.width = null;
        this.height = null;
    }
}
