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

import cn.felord.enumeration.DocAuthType;
import lombok.Getter;
import lombok.ToString;

/**
 * The type File auth member.
 *
 * @author dax
 * @since 2024/7/24
 */
@ToString
@Getter
public class FileAuthMember {
    private final Integer type = 1;
    private final DocAuthType auth;
    private final String userid;
    private final String tmpExternalUserid;

    /**
     * Instantiates a new File auth member.
     *
     * @param auth              the auth
     * @param userid            the userid
     * @param tmpExternalUserid the tmp external userid
     */
    FileAuthMember(DocAuthType auth, String userid, String tmpExternalUserid) {
        this.auth = auth;
        this.userid = userid;
        this.tmpExternalUserid = tmpExternalUserid;
    }

    /**
     * 更新文档通知范围的列表-企业内成员
     *
     * @param auth   the auth
     * @param userid 企业内成员的ID
     * @return the file auth member
     */
    public static FileAuthMember updateFileUser(DocAuthType auth, String userid) {
        return new FileAuthMember(auth, userid, null);
    }

    /**
     * 更新文档通知范围的列表-企业外成员
     *
     * @param auth              the auth
     * @param tmpExternalUserid 外部用户临时ID
     * @return the file auth member
     */
    public static FileAuthMember updateFileTmpUser(DocAuthType auth, String tmpExternalUserid) {
        return new FileAuthMember(auth, null, tmpExternalUserid);
    }

    /**
     * 删除的文档通知范围列表-企业内成员
     *
     * @param userid 企业内成员的ID
     * @return the file auth member
     */
    public static FileAuthMember delFileUser(String userid) {
        return new FileAuthMember(null, userid, null);
    }

    /**
     * 删除的文档通知范围列表-外部用户
     *
     * @param tmpExternalUserid 外部用户临时ID
     * @return the file auth member
     */
    public static FileAuthMember delFileTmpUser(String tmpExternalUserid) {
        return new FileAuthMember(null, null, tmpExternalUserid);
    }
}
