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

package cn.felord.payment.wechat.v3.direct;

import cn.felord.payment.wechat.v3.crypto.AppMerchant;
import cn.felord.payment.wechat.v3.retrofit.WechatPayRetrofitFactory;
import okhttp3.ConnectionPool;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 微信支付API入口
 *
 * @author dax
 * @since 2023 /8/6
 */
public final class WechatPayApi {
    private final WechatPayRetrofitFactory factory;


    private WechatPayApi(WechatPayRetrofitFactory factory) {
        this.factory = factory;
    }

    /**
     * Direct base pay api direct base pay api.
     *
     * @param appMerchant the app merchant
     * @return the direct base pay api
     */
    public DirectBasePayApi directBasePayApi(AppMerchant appMerchant) {
        return new DirectBasePayApi(factory, appMerchant);
    }


    /**
     * The type Builder.
     */
    public static class Builder {
        private static final String DEFAULT_BASE_URL = "https://api.mch.weixin.qq.com/";
        private String baseUrl = DEFAULT_BASE_URL;
        private ConnectionPool connectionPool = new ConnectionPool();
        private HttpLoggingInterceptor.Level logLevel = HttpLoggingInterceptor.Level.NONE;

        /**
         * Base url builder.
         *
         * @param baseUrl the base url
         * @return the builder
         */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        /**
         * Connection pool builder.
         *
         * @param connectionPool the connection pool
         * @return the builder
         */
        public Builder connectionPool(ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
            return this;
        }

        /**
         * Log level builder.
         *
         * @param logLevel the log level
         * @return the builder
         */
        public Builder logLevel(HttpLoggingInterceptor.Level logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        /**
         * Build wechat pay api.
         *
         * @return the wechat pay api
         */
        public WechatPayApi build() {
            WechatPayRetrofitFactory retrofitFactory = new WechatPayRetrofitFactory(baseUrl, connectionPool, logLevel);
            return new WechatPayApi(retrofitFactory);
        }
    }

}