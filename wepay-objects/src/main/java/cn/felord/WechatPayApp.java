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

package cn.felord;

import lombok.Data;

import java.security.KeyPair;

/**
 * @author dax
 * @since 2023/7/30
 */
@Data
public class WechatPayApp {
    /**
     * app id for wechat pay is required
     */
    private final String appId;
    /**
     * app V3 secret is required by wechat pay V3
     */
    private final String appV3Secret;
    /**
     * mchId for wechat pay is required
     */
    private final String mchId;
    /**
     * The Key pair.
     */
    private final KeyPair keyPair;
    /**
     * The Serial number.
     */
    private final String serialNumber;
    /**
     * app final secret for wechat pay is required
     */
    private String appSecret;
    /**
     * partnerKey for wechat pay is  optional
     */
    private String partnerKey;
}
