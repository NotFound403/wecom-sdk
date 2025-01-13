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


import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.utils.StringUtils;
import okhttp3.Headers;
import retrofit2.Response;

import java.util.Objects;

/**
 * The type Wecom response body extractor.
 *
 * @author dax
 * @since 2025 /1/7
 */
public final class WecomResponseBodyExtractor {
    private static final String ERROR_CODE_HEADER = "error-code";
    private static final String ERROR_MSG_HEADER = "error-msg";
    private static final String SUCCESS_CODE = "0";

    private WecomResponseBodyExtractor() {
    }

    /**
     * Extract r.
     *
     * @param <R>      the type parameter
     * @param response the response
     * @return the r
     * @throws WeComException the we com exception
     */
    public static <R> R extract(Response<R> response) throws WeComException {
        Headers headers = response.headers();
        String errorCode = headers.get(ERROR_CODE_HEADER);
        // 通常不需要解析
        if (StringUtils.hasText(errorCode)) {
            if (!Objects.equals(SUCCESS_CODE, errorCode)) {
                throw new WeComException(Integer.parseInt(errorCode), headers.get(ERROR_MSG_HEADER));
            }
        } else {
            R body = response.body();
            if (body != null && WeComResponse.class.isAssignableFrom(body.getClass())) {
                WeComResponse weComResponse = (WeComResponse) body;
                if (weComResponse.isError()) {
                    throw new WeComException(weComResponse.getErrcode(), weComResponse.getErrmsg());
                }
            }
        }
        return response.body();
    }

}
