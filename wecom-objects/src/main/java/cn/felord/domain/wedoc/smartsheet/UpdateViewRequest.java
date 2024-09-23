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
 * The type Update view request.
 *
 * @author dax
 * @since 2024 /9/4
 */
@ToString
@Getter
public class UpdateViewRequest {
    private final String docid;
    private final String sheetId;
    private final String viewId;
    private String viewTitle;
    private ViewProperty property;

    /**
     * Instantiates a new Update view request.
     *
     * @param docid   the docid
     * @param sheetId the sheet id
     * @param viewId  the view id
     */
    public UpdateViewRequest(String docid, String sheetId, String viewId) {
        this.docid = docid;
        this.sheetId = sheetId;
        this.viewId = viewId;
    }

    /**
     * View title update view request.
     *
     * @param viewTitle the view title
     * @return the update view request
     */
    public UpdateViewRequest viewTitle(String viewTitle) {
        this.viewTitle = viewTitle;
        return this;
    }

    /**
     * Property update view request.
     *
     * @param property the property
     * @return the update view request
     */
    public UpdateViewRequest property(ViewProperty property) {
        this.property = property;
        return this;
    }
}
