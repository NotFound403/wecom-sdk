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
 * 敏感信息加密解密工具
 *
 * @author dax
 * @since 2024/8/7
 */
public interface WecomCipher {

    /**
     * Encrypt string.
     *
     * @param key            密钥
     * @param associatedData 额外的认证加密数据
     * @param iv             初始化向量随机串
     * @param plainText      明文
     * @return the string
     * @throws IllegalArgumentException the illegal argument exception
     */
    String encrypt(String key, String associatedData, String iv, String plainText) throws IllegalArgumentException;

    /**
     * 解密
     *
     * @param key            密钥
     * @param associatedData 额外的认证加密数据
     * @param iv             初始化向量随机串
     * @param cipherText     密文
     * @return 编码的明文 utf8格式
     * @throws IllegalArgumentException the illegal argument exception
     */
    String decrypt(String key, String associatedData, String iv, String cipherText) throws IllegalArgumentException;

}
