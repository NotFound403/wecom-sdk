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

import cn.felord.enumeration.BoolEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type File config.
 *
 * @author dax
 * @since 2024/5/25 16:59
 */
@ToString
@Getter
public class FileConfig implements ControlConfig {
    private final Wrapper file;

    /**
     * Instantiates a new File config.
     *
     * @param file the file
     */
    @JsonCreator
    FileConfig(@JsonProperty("file") Wrapper file) {
        this.file = file;
    }

    /**
     * From file config.
     *
     * @param isOnlyPhoto the is only photo
     * @return the file config
     */
    public static FileConfig from(BoolEnum isOnlyPhoto) {
        return new FileConfig(new Wrapper(isOnlyPhoto));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final BoolEnum isOnlyPhoto;

        /**
         * Instantiates a new Wrapper.
         *
         * @param isOnlyPhoto the is only photo
         */
        @JsonCreator
        Wrapper(@JsonProperty("is_only_photo") BoolEnum isOnlyPhoto) {
            this.isOnlyPhoto = isOnlyPhoto;
        }
    }

}
