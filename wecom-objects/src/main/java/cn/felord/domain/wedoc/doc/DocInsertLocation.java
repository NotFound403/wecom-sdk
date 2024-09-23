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
 * 指定位置插入段落或者分页符
 *
 * @author dax
 * @since 2024 /8/9
 */
@ToString
@Getter
public class DocInsertLocation {
    /**
     * 位置
     */
    private final DocLocation location;

    /**
     * Instantiates a new Doc insert page break.
     *
     * @param index the index
     */
    DocInsertLocation(int index) {
        this(new DocLocation(index));
    }

    /**
     * Instantiates a new Doc insert page break.
     *
     * @param location the location
     */
    DocInsertLocation(DocLocation location) {
        this.location = location;
    }
}
