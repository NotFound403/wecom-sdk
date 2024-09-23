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

package cn.felord.payment.wechat.v3.retrofit;

import cn.felord.retrofit.json.JsonConverterFactory;
import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.AppMerchant;
import cn.felord.payment.wechat.v3.crypto.TenpayKey;
import com.nimbusds.jose.jwk.JWK;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 微信支付平台证书API
 *
 * @author dax
 * @since 2024/8/10 10:04
 */
class TenpayCertificateService {

    private final AppMerchant appMerchant;
    private final TenpayKeyCache tenpayKeyCache;
    private final InternalCertificateApi certificateApi;


    /**
     * Instantiates a new Tenpay certificate api.
     *
     * @param baseUrl        the base url
     * @param appMerchant    the app merchant
     * @param tenpayKeyCache the tenpay key cache
     */
    TenpayCertificateService(String baseUrl, AppMerchant appMerchant, TenpayKeyCache tenpayKeyCache) {
        this.appMerchant = appMerchant;
        this.tenpayKeyCache = tenpayKeyCache;
        this.certificateApi = new TenpayCertificateRetrofitFactory(baseUrl)
                .app(appMerchant)
                .create(InternalCertificateApi.class);
    }

    /**
     * 根据商户号和v3密钥获取平台证书列表
     *
     * @throws PayException the pay exception
     */
    public void certificates() throws PayException {
        synchronized (appMerchant) {
            certificateApi.certificates()
                    .getData()
                    .forEach(tenpayCertificate -> {
                        String merchantId = appMerchant.merchantId();
                        String serialNo = tenpayCertificate.getSerialNo();
                        JWK tenPayJwk = tenpayCertificate.getEncryptCertificate()
                                .toJwk(appMerchant.getApiV3Secret());
                        TenpayKey tenpayKey = new TenpayKey(merchantId, serialNo, tenPayJwk);
                        tenpayKeyCache.putTenpayKey(merchantId, serialNo, tenpayKey);
                    });
        }
    }

    /**
     * Gets tenpay key.
     *
     * @param serialNumber the serial number
     * @return the tenpay key
     */
    public TenpayKey getTenpayKey(String serialNumber) {
        TenpayKey tenpayKey = tenpayKeyCache.getTenpayKey(appMerchant.merchantId(), serialNumber);
        if (Objects.isNull(tenpayKey)) {
            this.certificates();
            tenpayKey = tenpayKeyCache.getTenpayKey(appMerchant.merchantId(), serialNumber);
            if (Objects.isNull(tenpayKey)) {
                throw new PayException("Fail to load tenpayKey");
            }
        }
        return tenpayKey;
    }


    /**
     * The type Tenpay certificate retrofit factory.
     */
    static class TenpayCertificateRetrofitFactory {
        private static final String DEFAULT_BASE_URL = "https://api.mch.weixin.qq.com/";
        private final String baseUrl;
        private final ConnectionPool connectionPool;
        private final HttpLoggingInterceptor.Level level;

        /**
         * Instantiates a new Wechat pay retrofit factory.
         */
        public TenpayCertificateRetrofitFactory() {
            this(DEFAULT_BASE_URL);
        }

        /**
         * Instantiates a new Wechat pay retrofit factory.
         *
         * @param baseUrl the base url
         */
        public TenpayCertificateRetrofitFactory(String baseUrl) {
            this(baseUrl, new ConnectionPool(), HttpLoggingInterceptor.Level.NONE);
        }

        /**
         * Instantiates a new Wechat pay retrofit factory.
         *
         * @param baseUrl        the base url
         * @param connectionPool the connection pool
         * @param level          the level
         */
        public TenpayCertificateRetrofitFactory(String baseUrl, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
            this.baseUrl = baseUrl;
            this.connectionPool = connectionPool;
            this.level = level;
        }

        /**
         * 带拦截器的Retrofit客户端
         *
         * @param appMerchant the app merchant
         * @return the retrofit
         */
        public Retrofit app(AppMerchant appMerchant) {
            return new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient(appMerchant, connectionPool, level))
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addCallAdapterFactory(new ResponseBodyCallAdapterFactory())
                    .addConverterFactory(JsonConverterFactory.create())
                    .build();
        }

        private static OkHttpClient okHttpClient(AppMerchant appMerchant,
                                                 ConnectionPool connectionPool,
                                                 HttpLoggingInterceptor.Level level) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.level(level);
            TenpayCertificateAuthorizationInterceptor authorizationInterceptor = new TenpayCertificateAuthorizationInterceptor(appMerchant);
            return new OkHttpClient.Builder()
                    .connectionPool(connectionPool)
                    .addInterceptor(authorizationInterceptor)
                    .addInterceptor(httpLoggingInterceptor)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .build();
        }
    }

    /**
     * The type Wechat authorization interceptor.
     */
    static class TenpayCertificateAuthorizationInterceptor extends AbstractAuthorizationInterceptor {
        /**
         * Instantiates a new Tenpay certificate authorization interceptor.
         *
         * @param appMerchant the app merchant
         */
        public TenpayCertificateAuthorizationInterceptor(AppMerchant appMerchant) {
            super(appMerchant);
        }

        @Override
        protected void verifyResponse(Response response) throws PayException {
            // do nothing
        }

    }
}
