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

import java.util.Set;

/**
 * The type Smart records request.
 *
 * @author dax
 * @since 2024 /12/25
 */
@ToString
@Getter
public class SmartRecordsRequest {
    private final String docid;
    private final String sheetId;
    private final String keyType;
    private String viewId;
    private Set<String> recordIds;
    private Set<String> fieldIds;
    private Set<String> fieldTitles;
    private Integer offset;
    private Integer limit;

    /**
     * Instantiates a new Smart records request.
     *
     * @param docid   the docid
     * @param sheetId the sheet id
     * @param keyType the key type
     */
    SmartRecordsRequest(String docid, String sheetId, String keyType) {
        this.docid = docid;
        this.sheetId = sheetId;
        this.keyType = keyType;
    }

    /**
     * key用字段ID表示
     *
     * @param docid   the docid
     * @param sheetId the sheet id
     * @return the smart records request
     */
    public static SmartRecordsRequest byFieldId(String docid, String sheetId) {
        return new SmartRecordsRequest(docid, sheetId, "CELL_VALUE_KEY_TYPE_FIELD_ID");
    }

    /**
     * key用字段标题表示
     *
     * @param docid   the docid
     * @param sheetId the sheet id
     * @return the smart records request
     */
    public static SmartRecordsRequest byFieldTitle(String docid, String sheetId) {
        return new SmartRecordsRequest(docid, sheetId, "CELL_VALUE_KEY_TYPE_FIELD_TITLE");
    }

    /**
     * View id smart records request.
     *
     * @param viewId the view id
     * @return the smart records request
     */
    public SmartRecordsRequest viewId(String viewId) {
        this.viewId = viewId;
        return this;
    }

    /**
     * Record ids smart records request.
     *
     * @param recordIds the record ids
     * @return the smart records request
     */
    public SmartRecordsRequest recordIds(Set<String> recordIds) {
        this.recordIds = recordIds;
        return this;
    }

    /**
     * Field ids smart records request.
     *
     * @param fieldIds the field ids
     * @return the smart records request
     */
    public SmartRecordsRequest fieldIds(Set<String> fieldIds) {
        this.fieldIds = fieldIds;
        return this;
    }

    /**
     * Field titles smart records request.
     *
     * @param fieldTitles the field titles
     * @return the smart records request
     */
    public SmartRecordsRequest fieldTitles(Set<String> fieldTitles) {
        this.fieldTitles = fieldTitles;
        return this;
    }

    /**
     * Offset smart records request.
     *
     * @param offset the offset
     * @return the smart records request
     */
    public SmartRecordsRequest offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Limit smart records request.
     *
     * @param limit the limit
     * @return the smart records request
     */
    public SmartRecordsRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }
}
