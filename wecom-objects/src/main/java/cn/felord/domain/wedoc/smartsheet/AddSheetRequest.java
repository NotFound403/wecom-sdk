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
public class AddSheetRequest {

    private final String docid;
    private SmartSheetProperties properties;


    /**
     * Instantiates a new Add sheet request.
     *
     * @param docid the docid
     */
    public AddSheetRequest(String docid) {
        this.docid = docid;
    }

    /**
     * Instantiates a new Add sheet request.
     *
     * @param docId the doc id
     * @param title the title
     */
    public AddSheetRequest(String docId, String title) {
        this(docId, title, null);
    }

    /**
     * Instantiates a new Add sheet request.
     *
     * @param docId the doc id
     * @param index the index
     */
    public AddSheetRequest(String docId, int index) {
        this(docId, null, index);
    }

    /**
     * Instantiates a new Add sheet request.
     *
     * @param docId the doc id
     * @param title the title
     * @param index the index
     */
    public AddSheetRequest(String docId, String title, Integer index) {
        this.docid = docId;
        this.properties = new SmartSheetProperties(title, index);
    }

}
