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

package cn.felord.mp;

import lombok.Getter;

/**
 * The type Wecom exception.
 *
 * @author n1
 * @since 2021 /8/17 18:31
 */
@Getter
public class WeMpException extends RuntimeException {
    private static final Integer DEFAULT_CODE = -9999999;
    private final Integer errcode;

    /**
     * Instantiates a new weComException.
     *
     * @param cause the cause
     */
    public WeMpException(Throwable cause) {
        super(cause);
        this.errcode = DEFAULT_CODE;
    }

    /**
     * Instantiates a new weComException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public WeMpException(String message, Throwable cause) {
        super(message, cause);
        this.errcode = DEFAULT_CODE;
    }

    /**
     * Instantiates a new weComException.
     *
     * @param errmsg the errmsg
     */
    public WeMpException(String errmsg) {
        super(errmsg);
        this.errcode = DEFAULT_CODE;
    }

    /**
     * Instantiates a new weComException.
     *
     * @param errcode the errcode
     * @param errmsg  the errmsg
     */
    public WeMpException(Integer errcode, String errmsg) {
        super(errmsg);
        this.errcode = errcode;
    }
}
