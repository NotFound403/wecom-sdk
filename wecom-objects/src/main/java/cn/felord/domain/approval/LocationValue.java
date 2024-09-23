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

package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * 位置组件
 *
 * @author dax
 * @since 2024 /5/27
 */
@ToString
@Getter
public class LocationValue implements ContentDataValue {

    private final Wrapper location;

    /**
     * Instantiates a new Location value.
     *
     * @param location the location
     */
    @JsonCreator
    LocationValue(@JsonProperty("location") Wrapper location) {
        this.location = location;
    }

    /**
     * Instantiates a new Location value.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @param title     the title
     * @param address   the address
     * @param time      the time
     * @return the location value
     */
    public static LocationValue from(String latitude,
                                     String longitude,
                                     String title,
                                     String address,
                                     Instant time) {
        return new LocationValue(new Wrapper(latitude, longitude, title, address, time));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final String latitude;
        private final String longitude;
        private final String title;
        private final String address;
        private final Instant time;

        /**
         * Instantiates a new Wrapper.
         *
         * @param latitude  the latitude
         * @param longitude the longitude
         * @param title     the title
         * @param address   the address
         * @param time      the time
         */
        @JsonCreator
        Wrapper(@JsonProperty("latitude") String latitude,
                @JsonProperty("longitude") String longitude,
                @JsonProperty("title") String title,
                @JsonProperty("address") String address,
                @JsonProperty("time") Instant time) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.title = title;
            this.address = address;
            this.time = time;
        }
    }
}
