/*
 * Copyright (c) 2025. felord.cn
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

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Add record request.
 *
 * @author dax
 * @since 2024 /12/23
 */
@ToString
@Getter
public class AddRecordRequest {
    private final String docid;
    private final String sheetId;
    private final String keyType;
    private final List<RecordValues> records;


    /**
     * Instantiates a new Add record request.
     *
     * @param docId   the doc id
     * @param sheetId the sheet id
     * @param keyType the key type
     * @param records the records
     */
    AddRecordRequest(String docId, String sheetId, String keyType, List<RecordValues> records) {
        this.docid = docId;
        this.sheetId = sheetId;
        this.keyType = keyType;
        this.records = records;
    }


    /**
     * key用字段标题表示
     *
     * @param docId   the doc id
     * @param sheetId the sheet id
     * @param records the records
     * @return the add record request
     */
    public static AddRecordRequest byFieldId(String docId, String sheetId, List<RecordValues> records) {
        return new AddRecordRequest(docId, sheetId, "CELL_VALUE_KEY_TYPE_FIELD_ID", records);
    }

    /**
     * key用字段ID表示
     *
     * @param docId   the doc id
     * @param sheetId the sheet id
     * @param records the records
     * @return the add record request
     */
    public static AddRecordRequest byFieldTitle(String docId, String sheetId, List<RecordValues> records) {
        return new AddRecordRequest(docId, sheetId, "CELL_VALUE_KEY_TYPE_FIELD_TITLE", records);
    }
}
