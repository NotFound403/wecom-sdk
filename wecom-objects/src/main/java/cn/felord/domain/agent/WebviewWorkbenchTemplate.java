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
 * The type Webview workbench template.
 *
 * @author dax
 * @since 2024/10/25
 */
@ToString
@Getter
public class WebviewWorkbenchTemplate extends WorkbenchTemplate {
    private final Webview webview;

    /**
     * Instantiates a new List workbench template.
     *
     * @param agentid the agentid
     * @param webview the webview
     */
    public WebviewWorkbenchTemplate(String agentid, Webview webview) {
        this(agentid, false, webview);
    }

    /**
     * Instantiates a new List workbench template.
     *
     * @param agentid         the agentid
     * @param replaceUserData the replace user data
     * @param webview         the webview
     */
    @JsonCreator
    public WebviewWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                                    @JsonProperty("replace_user_data") boolean replaceUserData,
                                    @JsonProperty("webview") Webview webview) {
        super(agentid, replaceUserData, WorkbenchType.WEBVIEW);
        this.webview = webview;
    }
}
