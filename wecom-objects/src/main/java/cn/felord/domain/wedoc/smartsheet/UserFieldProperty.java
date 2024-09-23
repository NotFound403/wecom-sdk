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

package cn.felord.domain.wedoc.smartsheet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type User field property.
 *
 * @author dax
 * @since 2024 /9/4
 */
@ToString
@Getter
public class UserFieldProperty {
    private final Boolean isMultiple;
    private final Boolean isNotified;

    /**
     * Instantiates a new User field property.
     *
     * @param isMultiple the is multiple
     * @param isNotified the is notified
     */
    @JsonCreator
    public UserFieldProperty(@JsonProperty("is_multiple") Boolean isMultiple,
                             @JsonProperty("is_notified") Boolean isNotified) {
        this.isMultiple = isMultiple;
        this.isNotified = isNotified;
    }
}
