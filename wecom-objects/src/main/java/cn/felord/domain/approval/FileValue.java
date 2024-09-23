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

import cn.felord.domain.common.FileInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 附件组件
 *
 * @author dax
 * @since 2024 /5/26
 */
@ToString
@Getter
public class FileValue implements ContentDataValue {
    private final List<FileInfo> files;

    /**
     * Instantiates a new File value.
     *
     * @param files the files
     */
    @JsonCreator
    FileValue(@JsonProperty("files") List<FileInfo> files) {
        this.files = files;
    }

    /**
     * Instantiates a new File value.
     *
     * @param mediaIds the media ids
     */
    FileValue(Set<String> mediaIds) {
        this(mediaIds.stream()
                .map(FileInfo::new)
                .collect(Collectors.toList()));
    }

    /**
     * From file value.
     *
     * @param mediaIds the media ids
     * @return the file value
     */
    public static FileValue from(Set<String> mediaIds) {
        return new FileValue(mediaIds);
    }
}
