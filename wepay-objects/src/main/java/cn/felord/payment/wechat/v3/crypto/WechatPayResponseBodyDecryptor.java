/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.payment.wechat.v3.crypto;

import cn.felord.payment.PayException;

/**
 * 敏感信息加密解密工具
 *
 * @author dax
 * @since 2023 /8/7
 */
public interface WechatPayResponseBodyDecryptor {


    /**
     * 解密
     *
     * @param appV3Secret    v3 secret
     * @param associatedData 额外的认证加密数据
     * @param nonce          初始化向量
     * @param cipherText     密文
     * @return 编码的明文 utf8格式
     * @throws PayException the pay exception
     */
    String decrypt(String appV3Secret, String associatedData, String nonce, String cipherText) throws PayException;

}
