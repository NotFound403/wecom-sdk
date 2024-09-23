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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.ToString;

/**
 * 用户工作台
 *
 * @author dax
 * @since 2024/10/25
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = KeyDataWorkbenchTemplate.class, name = "keydata"),
        @JsonSubTypes.Type(value = ImageWorkbenchTemplate.class, name = "image"),
        @JsonSubTypes.Type(value = ListWorkbenchTemplate.class, name = "list"),
        @JsonSubTypes.Type(value = WebviewWorkbenchTemplate.class, name = "webview")
})
@ToString
@Getter
public class UserWorkbenchTemplate {
    private final String agentid;
    private final String userid;
    private final WorkbenchType type;

    /**
     * Instantiates a new User workbench template.
     *
     * @param agentid the agentid
     * @param userid  the userid
     * @param type    the type
     */
    @JsonCreator
    UserWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                          @JsonProperty("userid") String userid,
                          @JsonProperty("type") WorkbenchType type) {
        this.agentid = agentid;
        this.userid = userid;
        this.type = type;
    }
}
