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

package cn.felord.callbacks;

import cn.felord.WeComException;

/**
 * 企业微信回调异常处理
 */
public class WeComCallbackException extends WeComException {

    /**
     * The constant ValidateSignatureError.
     */
    public final static int ValidateSignatureError = -40001;
    /**
     * The constant ParseJsonError.
     */
    public final static int ParseJsonError = -40002;
    /**
     * The constant ComputeSignatureError.
     */
    public final static int ComputeSignatureError = -40003;
    /**
     * The constant IllegalAesKey.
     */
    public final static int IllegalAesKey = -40004;
    /**
     * The constant ValidateCorpidError.
     */
    public final static int ValidateCorpidError = -40005;
    /**
     * The constant EncryptAESError.
     */
    public final static int EncryptAESError = -40006;
    /**
     * The constant DecryptAESError.
     */
    public final static int DecryptAESError = -40007;
    /**
     * The constant IllegalBuffer.
     */
    public final static int IllegalBuffer = -40008;
    /**
     * The constant EncodeBase64Error.
     */
    public final static int EncodeBase64Error = -40009;
    /**
     * The constant DecodeBase64Error.
     */
    public final static int DecodeBase64Error = -40010;
    /**
     * The constant GenReturnJsonError.
     */
    public final static int GenReturnJsonError = -40011;


    /**
     * Instantiates a new We com callback exception.
     *
     * @param code the code
     */
    public WeComCallbackException(int code) {
        super(getMessage(code));
    }

    private static String getMessage(int code) {
        switch (code) {
            case ValidateSignatureError:
                return "签名验证错误";
            case ParseJsonError:
                return "json解析失败";
            case ComputeSignatureError:
                return "sha加密生成签名失败";
            case IllegalAesKey:
                return "SymmetricKey非法";
            case ValidateCorpidError:
                return "corpid校验失败";
            case EncryptAESError:
                return "aes加密失败";
            case DecryptAESError:
                return "aes解密失败";
            case IllegalBuffer:
                return "解密后得到的buffer非法";
            case EncodeBase64Error:
                return "base64加密错误";
            case DecodeBase64Error:
                return "base64解密错误";
            case GenReturnJsonError:
                return "json生成失败";
            default:
                return "回调处理失败，原因未知";
        }
    }
}
