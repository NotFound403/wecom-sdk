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

package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author dax
 * @since 2021/7/13 11:35
 */
@Data
public class CorpTagOptRequest {
    private final String userid;
    private final String externalUserid;
    private Set<String> addTag;
    private List<String> removeTag;


    public CorpTagOptRequest(String userid, String externalUserid, Set<String> addTag) {
        this(userid, externalUserid, addTag, null);
    }

    public CorpTagOptRequest(String userid, String externalUserid, List<String> removeTag) {
        this(userid, externalUserid, null, removeTag);
    }

    public CorpTagOptRequest(String userid, String externalUserid, Set<String> addTag, List<String> removeTag) {
        this.userid = userid;
        this.externalUserid = externalUserid;
        this.addTag = addTag;
        this.removeTag = removeTag;
    }
}
