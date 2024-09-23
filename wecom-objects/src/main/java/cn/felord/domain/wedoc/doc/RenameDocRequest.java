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

/**
 * The type Rename doc request.
 *
 * @author dax
 * @since 2024/7/19
 */
@ToString
@Getter
public class RenameDocRequest {
    private final String docid;
    private final String formid;
    private final String newName;

    /**
     * Instantiates a new Rename doc request.
     *
     * @param docid   the docid
     * @param formid  the formid
     * @param newName the new name
     */
    RenameDocRequest(String docid, String formid, String newName) {
        this.docid = docid;
        this.formid = formid;
        this.newName = newName;
    }


    /**
     * 重命名文档
     *
     * @param docid   the docid
     * @param newName the new name
     * @return the rename doc request
     */
    public static RenameDocRequest doc(String docid, String newName) {
        return new RenameDocRequest(docid, null, newName);
    }

    /**
     * 重命名表格
     *
     * @param formid  the formid
     * @param newName the new name
     * @return the rename doc request
     */
    public static RenameDocRequest sheet(String formid, String newName) {
        return new RenameDocRequest(null, formid, newName);
    }

}
