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

import cn.felord.enumeration.Dimension;
import lombok.Getter;
import lombok.ToString;

/**
 * 删除表格连续的行（或列）的请求，注意：
 * <ul>
 *     <li>该操作会导致表格缩表</li>
 *     <li>删除的范围遵循 左闭右开</li>
 * </ul>
 *
 * @author dax
 * @since 2024 /8/16
 */
@ToString
@Getter
public class DeleteDimensionRequest {
    /**
     * 工作表唯一标识
     */
    private final String sheetId;
    private final Dimension dimension;

    /**
     * Instantiates a new Delete dimension request.
     *
     * @param sheetId   the sheet id
     * @param dimension the dimension
     */
    DeleteDimensionRequest(String sheetId, Dimension dimension) {
        this.sheetId = sheetId;
        this.dimension = dimension;
    }

    /**
     * 删除连续行
     *
     * @param sheetId the sheet id
     * @return the delete dimension request
     */
    public static DeleteDimensionRequest row(String sheetId) {
        return new DeleteDimensionRequest(sheetId, Dimension.ROW);
    }

    /**
     * 删除连续列
     *
     * @param sheetId the sheet id
     * @return the delete dimension request
     */
    public static DeleteDimensionRequest column(String sheetId) {
        return new DeleteDimensionRequest(sheetId, Dimension.COLUMN);
    }
}
