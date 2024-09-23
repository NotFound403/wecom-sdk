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

package cn.felord.domain.wedoc.smartsheet;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Add sheet request.
 *
 * @author dax
 * @since 2024 /8/30
 */
@ToString
@Getter
public class UpdateSheetRequest {

    private final String docid;
    private final SmartSheetProperties properties;


    /**
     * Instantiates a new Add sheet request.
     *
     * @param docId   the doc id
     * @param sheetId the sheet id
     */
    public UpdateSheetRequest(String docId, String sheetId) {
        this(docId, sheetId, null);
    }

    /**
     * Instantiates a new Add sheet request.
     *
     * @param docId   the doc id
     * @param sheetId the sheet id
     * @param title   the title
     */
    public UpdateSheetRequest(String docId, String sheetId, String title) {
        this.docid = docId;
        this.properties = new SmartSheetProperties(title, null, sheetId);
    }

}
