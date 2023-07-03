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

package cn.felord.wecom.api;

import cn.felord.callbacks.CallbackCrypto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 通用回调，这里照搬即可，记得权限放行，过滤器拦截器也放行，改变请求体响应体结构会造成验签失败
 * <p>
 * 所有配置回调的地方都可以配置成一个接口，格式/wecom/callback/企微企业id/企微应用id
 * <p>
 * 企微企业id去企业微信控制台找
 * 企微应用id，如果是自建的应用去应用管理查看agentid，如果是企微内置的应用查看{@link cn.felord.enumeration.NativeAgent}
 *
 * @author felord.cn
 * @since 1.0.0
 */
@AllArgsConstructor
@RestController
@RequestMapping("/wecom/callback")
public class CallbackController {
    private final CallbackCrypto callbackCrypto;

    /**
     * 验证回调URL
     *
     * @param msgSignature the msg signature
     * @param timestamp    the timestamp
     * @param nonce        the nonce
     * @param echostr      the echostr
     * @param corpId       the corp id
     * @param agentId      the agent id
     * @return the long
     */
    @GetMapping("/{corpId}/{agentId}")
    public String verifyUrl(@RequestParam("msg_signature") String msgSignature,
                            @RequestParam String timestamp,
                            @RequestParam String nonce,
                            @RequestParam String echostr,
                            @PathVariable String corpId,
                            @PathVariable String agentId) {
        return callbackCrypto.decryptMsg(agentId, corpId, msgSignature, timestamp, nonce, echostr);
    }

    /**
     * 消费回调数据
     *
     * @param msgSignature the msg signature
     * @param timestamp    the timestamp
     * @param nonce        the nonce
     * @param xmlBody      the xml body
     * @param corpId       the corp id
     * @param agentId      the agent id
     * @return the string
     */
    @PostMapping("/{corpId}/{agentId}")
    public String consume(@RequestParam("msg_signature") String msgSignature,
                          @RequestParam String timestamp,
                          @RequestParam String nonce,
                          @RequestBody String xmlBody,
                          @PathVariable String corpId,
                          @PathVariable String agentId) {
        return callbackCrypto
                .accept(agentId, corpId, msgSignature, timestamp, nonce, xmlBody);
    }

}
