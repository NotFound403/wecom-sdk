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

package cn.felord.callback;

import cn.felord.utils.Base64Utils;

/**
 * The type Callback authentication.
 *
 * @author felord
 * @since 2021 /10/12 20:30
 */
public class CallbackSettings {
    private final String token;
    private final byte[] aesKey;
    private final String receiveid;

    /**
     * Instantiates a new Callback authentication.
     *
     * @param token          the token
     * @param encodingAesKey the encoding aes key
     * @param receiveid      the receiveid
     */
    public CallbackSettings(String token, String encodingAesKey, String receiveid) {
        if (encodingAesKey.length() != 43) {
            throw new IllegalArgumentException("Illegal Aes Key");
        }
        this.token = token;
        this.aesKey = Base64Utils.decodeFromString(encodingAesKey + "=");
        this.receiveid = receiveid;
    }

    public String getToken() {
        return token;
    }

    public byte[] getAesKey() {
        return aesKey;
    }

    public String getReceiveid() {
        return receiveid;
    }
}
