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

import cn.felord.domain.wedrive.FileId;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Wedrive file value.
 *
 * @author dax
 * @since 2024/10/14
 */
@ToString
@Getter
public class WedriveFileValue implements ContentDataValue {
    private final List<FileId> wedriveFiles;


    /**
     * Instantiates a new Wedrive file value.
     *
     * @param wedriveFiles the wedrive files
     */
    @JsonCreator
    WedriveFileValue(@JsonProperty("wedrive_files") List<FileId> wedriveFiles) {
        this.wedriveFiles = wedriveFiles;
    }

    /**
     * From wedrive file value.
     *
     * @param fileIds the file ids
     * @return the wedrive file value
     */
    public static WedriveFileValue from(List<String> fileIds) {
        List<FileId> fileIdList = fileIds.stream()
                .map(FileId::new)
                .collect(Collectors.toList());
        return new WedriveFileValue(fileIdList);
    }

}
