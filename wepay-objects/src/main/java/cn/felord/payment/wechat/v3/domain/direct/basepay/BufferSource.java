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

package cn.felord.payment.wechat.v3.domain.direct.basepay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import okhttp3.MediaType;
import okio.BufferedSource;

/**
 * 文件二进制容器
 * <p>
 * 自行转换为{@code org.springframework.web.multipart.MultipartFile}等其它类型
 * Buffer只能消费一次
 *
 * @author dax
 * @since 2024/6/26
 */
@AllArgsConstructor
@Getter
public class BufferSource {
    private final MediaType contentType;
    private final long contentLength;
    private final BufferedSource source;
}
