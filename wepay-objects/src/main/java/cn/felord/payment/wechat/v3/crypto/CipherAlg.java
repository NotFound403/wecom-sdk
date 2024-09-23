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

package cn.felord.payment.wechat.v3.crypto;

/**
 * 加密算法
 *
 * @author dax
 * @since 2024/8/7
 */
public enum CipherAlg {
    /**
     * Aead aes 256 gcm decrypt algs.
     */
    AEAD_AES_256_GCM("AES", "AES/GCM/NoPadding", 128);

    private final String alg;
    private final String transformation;
    private final int tagLength;

    CipherAlg(String alg, String transformation, int tagLength) {
        this.alg = alg;
        this.transformation = transformation;
        this.tagLength = tagLength;
    }

    /**
     * Alg string.
     *
     * @return the string
     */
    public String alg() {
        return alg;
    }

    /**
     * Transformation string.
     *
     * @return the string
     */
    public String transformation() {
        return transformation;
    }

    /**
     * Tag length int.
     *
     * @return the int
     */
    public int tagLength() {
        return tagLength;
    }

    /**
     * Wecom cipher wecom cipher.
     *
     * @return the wecom cipher
     */
    public WecomCipher wecomCipher() {
        return new DefaultWecomCipher(this);
    }
}
