/*
 * Copyright (c) 2025. felord.cn
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

package cn.felord.domain.wedoc.smartsheet;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Cell location value.
 */
@ToString
@Getter
public class CellLocationValue {
    private final String id;
    private final String latitude;
    private final String longitude;
    private final String title;
    private final Integer sourceType;


    /**
     * Instantiates a new Cell location value.
     *
     * @param id        the id
     * @param latitude  the latitude
     * @param longitude the longitude
     * @param title     the title
     */
    public CellLocationValue(String id, String latitude, String longitude, String title) {
        this(id, latitude, longitude, title, 1);
    }

    /**
     * Instantiates a new Cell location value.
     *
     * @param id         the id
     * @param latitude   the latitude
     * @param longitude  the longitude
     * @param title      the title
     * @param sourceType the source type
     */
    public CellLocationValue(String id, String latitude, String longitude, String title, Integer sourceType) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.sourceType = sourceType;
    }
}
