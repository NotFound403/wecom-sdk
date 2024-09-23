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

package cn.felord.domain.wedoc.doc;

import lombok.Data;

/**
 * 更新范围内单元格内容请求，单次更新的范围大小需满足以下限制：
 * <p>
 * <ul>
 *     <li>范围行数 不大于 1000</li>
 *     <li>范围列数 不大于 200</li>
 *     <li>范围内的总单元格数量 不大于 10000</li>
 * </ul>
 *
 * @author dax
 * @since 2024 /8/16
 */
@Data
public class UpdateRangeRequest {
    /**
     * 工作表唯一标识
     */
    private final String sheetId;
    /**
     * 写入指定区域的数据
     */
    private final GridData gridData;
}
