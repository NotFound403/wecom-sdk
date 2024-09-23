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

package cn.felord.callbacks;

import cn.felord.callback.CallbackResponse;
import cn.felord.callback.XmlEntity;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author felord
 * @since 2021/10/10 14:21
 */
@XStreamAlias("xml")
@Data
public class CallbackXmlResponse implements CallbackResponse, XmlEntity {
    @XStreamAlias("Encrypt")
    private final String encrypt;
    @XStreamAlias("MsgSignature")
    private final String msgSignature;
    @XStreamAlias("TimeStamp")
    private final String timeStamp;
    @XStreamAlias("Nonce")
    private final String nonce;
}
