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

package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author dax
 * @since 2023/7/7 11:46
 */
@Data
public class CallbackResource {
    /**
     * 对开启结果数据进行加密的加密算法，目前只支持AEAD_AES_256_GCM。
     */
    @XStreamAlias("algorithm")
    private String algorithm;
    /**
     * Base64编码后的开启/停用结果数据密文。
     */
    @XStreamAlias("ciphertext")
    private String ciphertext;
    /**
     * 附加数据。
     */
    @XStreamAlias("associated_data")
    private String associatedData;
    /**
     * 加密使用的随机串。
     */
    @XStreamAlias("nonce")
    private String nonce;
}
