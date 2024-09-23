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

package cn.felord.domain.msgaudit;

import cn.felord.enumeration.AgreeStatus;
import lombok.Data;

import java.time.Instant;

/**
 * The type ChatAgreeDetail
 *
 * @author dax
 * @since 2024/12/1
 */
@Data
public class ChatAgreeDetail {
    /**
     * 同意状态改变的具体时间
     */
    private Instant statusChangeTime;
    /**
     * 同意会话存档的状态
     */
    private AgreeStatus agreeStatus;
    /**
     * 外部联系人
     */
    private String exteranalopenid;
}
