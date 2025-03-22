
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

package cn.felord.domain.wedoc.doc;

import cn.felord.enumeration.DocType;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 新建文档
 *
 * @author felord
 * @since 2021 /10/12 16:53
 */
@ToString
@Getter
public class CreateDocRequest {

    /**
     * 文档名字，文件名最多填255个字符，超过255个字符会被截断
     */
    private final String docName;
    /**
     * 文档类型
     */
    private final DocType docType;
    /**
     * 文档管理员userid
     */
    private List<String> adminUsers;
    /**
     * 父目录fileid, 在根目录时为空间spaceid
     */
    private String fatherid;
    /**
     * 空间spaceid。若指定spaceid，则fatherid也要同时指定
     */
    private String spaceid;

    /**
     * Instantiates a new Create doc request.
     *
     * @param docName the doc name
     * @param docType the doc type
     */
    CreateDocRequest(String docName, DocType docType) {
        this.docName = docName;
        this.docType = docType;
    }

    /**
     * 文档
     *
     * @param docName the doc name
     * @return the create doc request
     */
    public static CreateDocRequest doc(String docName) {
        return new CreateDocRequest(docName, DocType.DOC);
    }

    /**
     * 表格
     *
     * @param docName the doc name
     * @return the create doc request
     */
    public static CreateDocRequest sheet(String docName) {
        return new CreateDocRequest(docName, DocType.SHEET);
    }

    /**
     * 智能表格
     *
     * @param docName the doc name
     * @return the create doc request
     */
    public static CreateDocRequest smartSheet(String docName) {
        return new CreateDocRequest(docName, DocType.SMART_SHEET);
    }

    /**
     * Admin users create doc request.
     *
     * @param adminUsers the admin users
     * @return the create doc request
     */
    public CreateDocRequest adminUsers(List<String> adminUsers) {
        this.adminUsers = adminUsers;
        return this;
    }

    /**
     * Father and space create doc request.
     *
     * @param fatherId the father id
     * @param spaceId  the space id
     * @return the create doc request
     */
    public CreateDocRequest fatherAndSpace(String fatherId, String spaceId) {
        this.fatherid = fatherId;
        this.spaceid = spaceId;
        return this;
    }
}
