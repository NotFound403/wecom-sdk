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
package cn.felord.payment.wechat.v3.domain.payscore;

import lombok.Getter;
import lombok.ToString;

/**
 * 查询支付分订单请求参数
 *
 * @author felord.cn
 * @since 1.0.2.RELEASE
 */
@ToString
@Getter
public class QueryServiceOrderParams {
    /**
     * 服务ID，必填
     */
    private final String serviceId;
    /**
     * 商户服务订单号，同{@link QueryServiceOrderParams#queryId} 二选一，而且不能同时为null
     */
    private final String outOrderNo;
    /**
     * 回跳查询ID，同{@link QueryServiceOrderParams#outOrderNo} 二选一，而且不能同时为null
     */
    private final String queryId;

    /**
     * Instantiates a new Query service order params.
     *
     * @param serviceId  the service id
     * @param outOrderNo the out order no
     * @param queryId    the query id
     */
    QueryServiceOrderParams(String serviceId, String outOrderNo, String queryId) {
        this.serviceId = serviceId;
        this.outOrderNo = outOrderNo;
        this.queryId = queryId;
    }

    /**
     * With out order no query service order params.
     *
     * @param serviceId  the service id
     * @param outOrderNo the out order no
     * @return the query service order params
     */
    public static QueryServiceOrderParams byOutOrderNo(String serviceId, String outOrderNo) {
        return new QueryServiceOrderParams(serviceId, outOrderNo, null);
    }

    /**
     * With out query id query service order params.
     *
     * @param serviceId the service id
     * @param queryId   the query id
     * @return the query service order params
     */
    public static QueryServiceOrderParams byOutQueryId(String serviceId, String queryId) {
        return new QueryServiceOrderParams(serviceId, null, queryId);
    }
}
