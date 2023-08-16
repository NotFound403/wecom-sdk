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

package cn.felord.payment.wechat.v3.retrofit;

import cn.felord.json.JsonConverterFactory;
import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.AppMerchant;
import cn.felord.payment.wechat.v3.crypto.TenpayKey;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 微信支付平台证书API
 *
 * @author dax
 * @since 2023 /8/10 10:04
 */
public final class TenpayCertificateApi {

    private final AppMerchant appMerchant;
    private final InternalCertificateApi certificateApi;
    private static final Set<TenpayKey> TENPAY_KEYS = Collections.synchronizedSet(new HashSet<>());

    /**
     * Instantiates a new Tenpay certificate api.
     */
    TenpayCertificateApi(AppMerchant appMerchant) {
        this.certificateApi = new TenpayCertificateRetrofitFactory().app(appMerchant)
                .create(InternalCertificateApi.class);
        this.appMerchant = appMerchant;
    }

    /**
     * 根据商户号和v3密钥获取平台证书列表
     *
     * @throws PayException the pay exception
     */
    public void certificates() throws PayException {
        Set<TenpayKey> tenpayKeys = certificateApi.certificates()
                .getData()
                .stream()
                .map(tenpayCertificate ->
                        new TenpayKey(appMerchant.merchantId(), tenpayCertificate.getSerialNo(),
                                tenpayCertificate.getEncryptCertificate().toJwk(appMerchant.getApiV3Secret())))
                .collect(Collectors.toSet());
        TENPAY_KEYS.addAll(tenpayKeys);
    }

    /**
     * Gets tenpay key.
     *
     * @param serialNumber the serial number
     * @return the tenpay key
     */
    public TenpayKey getTenpayKey(String serialNumber) {
        return TENPAY_KEYS.stream()
                .filter(tenpayKey ->
                        Objects.equals(tenpayKey.getSerialNumber(), serialNumber))
                .filter(tenpayKey -> {
                    boolean after = tenpayKey.getTenPayJwk()
                            .getExpirationTime()
                            .after(new Date());
                    if (!after) {
                        TENPAY_KEYS.remove(tenpayKey);
                    }
                    return after;
                })
                .findAny()
                .orElseGet(() -> {
                    certificates();
                    return TENPAY_KEYS.stream()
                            .filter(tenpayKey ->
                                    Objects.equals(tenpayKey.getSerialNumber(), serialNumber))
                            .findAny()
                            .orElseThrow(() -> new PayException("Fail to load tenpayKey"));
                });
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
        public TenpayCertificateAuthorizationInterceptor(AppMerchant appMerchant) {
            super(appMerchant);
        }

        @Override
        protected void consume(Response response) throws PayException {
            // do nothing
        }

    }
}
