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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Summary.
 *
 * @author dax
 * @since 2024 /5/26
 */
@ToString
@Getter
public class Summary {
    private final List<ApprovalTitle> summaryInfo;


    @JsonCreator
    Summary(@JsonProperty("summary_info") List<ApprovalTitle> summaryInfo) {
        this.summaryInfo = summaryInfo;
    }

    /**
     * 单个中文
     *
     * @param text the text
     * @return the summary
     */
    public static Summary zhCN(String text) {
        return new Summary(Collections.singletonList(ApprovalTitle.zhCN(text)));
    }

    /**
     * 多个中文
     *
     * @param texts the texts
     * @return the summary
     */
    public static Summary zhCN(List<String> texts) {
        return new Summary(texts.stream()
                .map(ApprovalTitle::zhCN)
                .collect(Collectors.toList()));
    }

    /**
     * Summary summary.
     *
     * @param title the title
     * @return the summary
     */
    public static Summary summary(ApprovalTitle title) {
        return new Summary(Collections.singletonList(title));
    }

    /**
     * Summary summary.
     *
     * @param titles the titles
     * @return the summary
     */
    public static Summary summary(List<ApprovalTitle> titles) {
        return new Summary(titles);
    }
}
