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
 * The type Checkbox field property.
 *
 * @author dax
 * @since 2024 /9/4
 */
@ToString
@Getter
public class AttachmentFieldProperty {
    private final String displayMode;

    /**
     * Instantiates a new Checkbox field property.
     *
     * @param displayMode the display mode
     */
    @JsonCreator
    AttachmentFieldProperty(@JsonProperty("display_mode") String displayMode) {
        this.displayMode = displayMode;
    }

    /**
     * 列表样式
     *
     * @return the attachment field property
     */
    public static AttachmentFieldProperty list() {
        return new AttachmentFieldProperty("DISPLAY_MODE_LIST");
    }

    /**
     * 宫格样式
     *
     * @return the attachment field property
     */
    public static AttachmentFieldProperty grid() {
        return new AttachmentFieldProperty("DISPLAY_MODE_GRID");
    }

}
