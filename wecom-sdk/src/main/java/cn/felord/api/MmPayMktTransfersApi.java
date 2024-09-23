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

package cn.felord.api;

import cn.felord.WeComException;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 企业支付
 * <p>
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=4_3">支付证书使用说明</a>
 *
 * @author dax
 * @since 2024/6/28 17:58
 */
interface MmPayMktTransfersApi {

    /**
     * 发放企业红包
     * <p>
     * 发放规则：
     * <ul>
     *     <li>发送频率限制------默认1800/min</li>
     *     <li>发送个数上限------默认1800/min</li>
     *     <li>场景金额限制------默认红包金额为1-200元，如有需要，可前往商户平台进行设置和申请</li>
     *     <li>其他限制------商户单日出资金额上限--100万元；单用户单日收款金额上限--1000元；单用户可领取红包个数上限--10个</li>
     * </ul>
     * <p>
     * 注意事项：
     * <ul>
     *     <li>红包金额大于200或者小于1元时，请求参数scene_id必传。</li>
     *     <li>根据监管要求，新申请商户号使用现金红包需要满足两个条件：1、入驻时间超过90天 2、连续正常交易30天。</li>
     *     <li>移动应用的appid无法使用红包接口。</li>
     *     <li>当返回错误码为“SYSTEMERROR”时，请不要更换商户订单号，一定要使用原商户订单号重试，否则可能造成重复发放红包等资金风险。</li>
     *     <li>XML具有可扩展性，因此返回参数可能会有新增，而且顺序可能不完全遵循此文档规范，如果在解析回包的时候发生错误，请商户务必不要换单重试，请商户联系客服确认红包发放情况。如果有新回包字段，会更新到此API文档中。</li>
     *     <li>因为错误代码字段err_code的值后续可能会增加，所以商户如果遇到回包返回新的错误码，请商户务必不要换单重试，请商户联系客服确认红包发放情况。如果有新的错误码，会更新到此API文档中。</li>
     *     <li>错误代码描述字段err_code_des只供人工定位问题时做参考，系统实现时请不要依赖这个字段来做自动化处理。</li>
     *     <li>请商户在自身的系统中合理设置发放频次并做好并发控制，防范错付风险。</li>
     *     <li>因商户自身系统设置存在问题导致的资金损失，由商户自行承担。</li>
     * </ul>
     *
     * @param xmlBody the xml body
     * @return the string
     * @throws WeComException the weComException
     */
    @POST("sendworkwxredpack")
    String sendWorkWxRedPack(@Body String xmlBody) throws WeComException;

    /**
     * 查询红包记录
     * <p>
     * 注意事项：
     * <ul>
     *     <li>查询红包记录API只支持查询30天内的红包订单，30天之前的红包订单请登录商户平台查询。</li>
     *     <li>如果查询单号对应的数据不存在，那么数据不存在的原因可能是：（1）发放请求还在处理中；（2）红包发放处理失败导致红包订单没有落地。在上述情况下，商户首先需要检查该商户订单号是否确实是自己发起的，如果商户确认是自己发起的，则请商户不要直接当做红包发放失败处理，请商户隔几分钟再尝试查询，或者商户可以通过相同的商户订单号再次发起发放请求。如果商户误把还在发放中的订单直接当发放失败处理，商户应当自行承担因此产生的所有损失和责任。</li>
     *     <li>XML具有可扩展性，因此返回参数可能会有新增，而且顺序可能不完全遵循此文档规范，如果在解析回包的时候发生错误，请商户务必不要换单重试，请商户联系客服确认红包发放情况。如果有新回包字段，会更新到此API文档中。</li>
     *     <li>因为错误代码字段err_code的值后续可能会增加，所以商户如果遇到回包返回新的错误码，请商户务必不要换单重试，请商户联系客服确认红包发放情况。如果有新的错误码，会更新到此API文档中。</li>
     *     <li>错误代码描述字段err_code_des只供人工定位问题时做参考，系统实现时请不要依赖这个字段来做自动化处理。</li>
     * </ul>
     *
     * @param xmlBody the xml body
     * @return the string
     * @throws WeComException the weComException
     */
    @POST("queryworkwxredpack")
    String queryWorkWxRedPack(@Body String xmlBody) throws WeComException;

    /**
     * 向员工付款
     * <p>
     * 接口调用规则：
     * <ul>
     *     <li>给同一个实名用户付款，单笔单日限额200/200元</li>
     *     <li>一个商户同一日付款总额限额10W</li>
     *     <li>如需提额，可以在微信支付商户平台-产品中心-我的产品-运营工具-企业付款到零钱-产品设置中设置</li>
     *     <li>不支持给非实名用户打款</li>
     *     <li>单笔最小金额默认为1元</li>
     *     <li>每个用户每天最多可付款10次，可以在商户平台--API安全进行设置</li>
     *     <li>给同一个用户付款时间间隔不得低于15秒</li>
     * </ul>
     *
     * @param xmlBody the xml body
     * @return the string
     * @throws WeComException the weComException
     */
    @POST("promotion/paywwsptrans2pocket")
    String payWwSpTrans2Pocket(@Body String xmlBody) throws WeComException;

    /**
     * 向员工付款-查询付款记录
     * <p>
     * 用于商户的企业微信企业付款操作进行结果查询，返回付款操作详细结果。
     * 查询企业微信企业付款API只支持查询30天内的订单，30天之前的订单请登录商户平台查询。
     *
     * @param xmlBody the xml body
     * @return the string
     * @throws WeComException the weComException
     */
    @POST("promotion/querywwsptrans2pocket")
    String queryWwSpTrans2Pocket(@Body String xmlBody) throws WeComException;
}
