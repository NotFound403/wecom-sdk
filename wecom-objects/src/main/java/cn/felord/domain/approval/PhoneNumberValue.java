/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 电话组件
 *
 * @author dax
 * @since 2023 /5/27
 */
@ToString
@Getter
public class PhoneNumberValue implements ContentDataValue {

    private final Wrapper phonenumber;

    /**
     * Instantiates a new Phone number value.
     *
     * @param phonenumber the phonenumber
     */
    @JsonCreator
    PhoneNumberValue(@JsonProperty("phonenumber") Wrapper phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * Instantiates a new Phone number value.
     *
     * @param area   the area
     * @param number the number
     */
    public PhoneNumberValue(String area, String number) {
        this(new Wrapper(area, number));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final String area;
        private final String number;

        /**
         * Instantiates a new Wrapper.
         *
         * @param area   the area
         * @param number the number
         */
        @JsonCreator
        Wrapper(String area, String number) {
            this.area = area;
            this.number = number;
        }
    }
}
