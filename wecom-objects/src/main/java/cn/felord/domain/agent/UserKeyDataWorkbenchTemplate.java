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

package cn.felord.domain.agent;

import cn.felord.enumeration.WorkbenchType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Key data workbench template.
 *
 * @author dax
 * @since 2024/10/25
 */
@ToString
@Getter
public class UserKeyDataWorkbenchTemplate extends UserWorkbenchTemplate {
    private final KeyData keydata;

    /**
     * Instantiates a new User key data workbench template.
     *
     * @param agentid the agentid
     * @param userid  the userid
     * @param keydata the keydata
     */
    @JsonCreator
    public UserKeyDataWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                                        @JsonProperty("userid") String userid,
                                        @JsonProperty("keydata") KeyData keydata) {
        super(agentid, userid, WorkbenchType.KEY_DATA);
        this.keydata = keydata;
    }
}
