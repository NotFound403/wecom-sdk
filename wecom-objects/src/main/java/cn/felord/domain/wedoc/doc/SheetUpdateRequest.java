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

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Sheet update request.
 *
 * @author dax
 * @since 2024 /8/16
 */
@ToString
@Getter
public class SheetUpdateRequest {
    private AddSheetRequest addSheetRequest;
    private SheetId deleteSheetRequest;
    private UpdateRangeRequest updateRangeRequest;
    private DeleteDimensionRequest deleteDimensionRequest;

    private SheetUpdateRequest() {
    }

    /**
     * 新增工作表
     *
     * @param sheetName   the sheet name
     * @param rowCount    the row count
     * @param columnCount the column count
     * @return the sheet update request
     */
    public static SheetUpdateRequest addSheet(String sheetName, int rowCount, int columnCount) {
        SheetUpdateRequest sheetUpdateRequest = new SheetUpdateRequest();
        sheetUpdateRequest.addSheetRequest = new AddSheetRequest(sheetName, rowCount, columnCount);
        return sheetUpdateRequest;
    }

    /**
     * 删除工作表
     *
     * @param sheetId the sheet id
     * @return the sheet update request
     */
    public static SheetUpdateRequest deleteSheet(String sheetId) {
        SheetUpdateRequest sheetUpdateRequest = new SheetUpdateRequest();
        sheetUpdateRequest.deleteSheetRequest = new SheetId(sheetId);
        return sheetUpdateRequest;
    }

    /**
     * 更新范围内单元格内容
     *
     * @param sheetId     the sheet id
     * @param startRow    the start row
     * @param startColumn the start column
     * @param rows        the rows
     * @return the sheet update request
     */
    public static SheetUpdateRequest updateRange(String sheetId, int startRow, int startColumn, List<RowData> rows) {
        SheetUpdateRequest sheetUpdateRequest = new SheetUpdateRequest();
        sheetUpdateRequest.updateRangeRequest = new UpdateRangeRequest(sheetId, new GridData(startRow, startColumn, rows));
        return sheetUpdateRequest;
    }

    /**
     * 删除表格连续的行
     *
     * @param sheetId the sheet id
     * @return the sheet update request
     */
    public static SheetUpdateRequest deleteRowDimension(String sheetId) {
        SheetUpdateRequest sheetUpdateRequest = new SheetUpdateRequest();
        sheetUpdateRequest.deleteDimensionRequest = DeleteDimensionRequest.row(sheetId);
        return sheetUpdateRequest;
    }

    /**
     * 删除表格连续的列
     *
     * @param sheetId the sheet id
     * @return the sheet update request
     */
    public static SheetUpdateRequest deleteColumnDimension(String sheetId) {
        SheetUpdateRequest sheetUpdateRequest = new SheetUpdateRequest();
        sheetUpdateRequest.deleteDimensionRequest = DeleteDimensionRequest.column(sheetId);
        return sheetUpdateRequest;
    }
}
