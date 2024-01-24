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

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * The type Summary.
 *
 * @author dax
 * @since 2024/5/26
 */
@Data
public class Summary {
    private final List<ApprovalTitle> summaryInfo;


    /**
     * Zh cn summary.
     *
     * @param text the text
     * @return the summary
     */
    public static Summary zhCN(String text) {
        return new Summary(Collections.singletonList(ApprovalTitle.zhCN(text)));
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

}
