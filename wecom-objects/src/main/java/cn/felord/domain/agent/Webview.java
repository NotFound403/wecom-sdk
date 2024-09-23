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

import cn.felord.enumeration.WebViewHeight;
import lombok.Data;

/**
 * The type Webview.
 *
 * @author dax
 * @since 2024/10/25
 */
@Data
public class Webview implements WorkBenchBody {
    private String pagepath;
    private String jumpUrl;
    private Boolean hideTitle;
    private Boolean enableWebviewClick;
    private String url;
    private WebViewHeight height;
}
