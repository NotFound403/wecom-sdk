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

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author felord
 * @since 2021/10/10 14:21
 */
@XStreamAlias("xml")
public class CallbackXmlResponse implements CallbackResponse, XmlEntity {
    @XStreamAlias("Encrypt")
    private final String encrypt;
    @XStreamAlias("MsgSignature")
    private final String msgSignature;
    @XStreamAlias("TimeStamp")
    private final String timeStamp;
    @XStreamAlias("Nonce")
    private final String nonce;

    CallbackXmlResponse(String encrypt, String msgSignature, String timeStamp, String nonce) {
        this.encrypt = encrypt;
        this.msgSignature = msgSignature;
        this.timeStamp = timeStamp;
        this.nonce = nonce;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public String getMsgSignature() {
        return msgSignature;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getNonce() {
        return nonce;
    }

    @Override
    public String toString() {
        return "CallbackXmlResponse{" +
                "encrypt='" + encrypt + '\'' +
                ", msgSignature='" + msgSignature + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", nonce='" + nonce + '\'' +
                '}';
    }
}
