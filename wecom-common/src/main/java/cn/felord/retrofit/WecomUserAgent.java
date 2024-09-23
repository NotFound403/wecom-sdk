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

package cn.felord.retrofit;

import java.util.Optional;

/**
 * The type Wecom user agent.
 *
 * @author dax
 * @since 2024/10/13
 */
public final class WecomUserAgent {
    /**
     * 版本号
     */
    public static final String VERSION = "1.2.9";
    /**
     * UserAgent
     */
    public static final String WECOM_USER_AGENT;

    static {
        WECOM_USER_AGENT = "Wecom/" + VERSION + Optional.ofNullable(System.getProperty("java.version"))
                .map(javaVersion -> " Java/" + javaVersion)
                .orElse("");
    }

    private WecomUserAgent() {
    }
}
