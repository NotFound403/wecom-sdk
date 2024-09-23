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
import cn.felord.payment.wechat.v3.crypto.AppMerchant;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;

import java.util.concurrent.TimeUnit;

/**
 * The WechatPayRetrofitFactory.
 *
 * @author felord.cn
 * @since 2.0.0
 */
public final class WechatPayRetrofitFactory {
    private static final String DEFAULT_BASE_URL = "https://api.mch.weixin.qq.com/";
    private final String baseUrl;
    private final TenpayKeyCache tenpayKeyCache;
    private final ConnectionPool connectionPool;
    private final HttpLoggingInterceptor.Level level;

    /**
     * Instantiates a new Wechat pay retrofit factory.
     *
     * @param tenpayKeyCache the tenpay key cache
     */
    public WechatPayRetrofitFactory(TenpayKeyCache tenpayKeyCache) {
        this(DEFAULT_BASE_URL, tenpayKeyCache);
    }

    /**
     * Instantiates a new Wechat pay retrofit factory.
     *
     * @param baseUrl        the base url
     * @param tenpayKeyCache the tenpay key cache
     */
    public WechatPayRetrofitFactory(String baseUrl, TenpayKeyCache tenpayKeyCache) {
        this(baseUrl, tenpayKeyCache, new ConnectionPool(), HttpLoggingInterceptor.Level.NONE);
    }

    /**
     * Instantiates a new Wechat pay retrofit factory.
     *
     * @param baseUrl        the base url
     * @param tenpayKeyCache the tenpay key cache
     * @param connectionPool the connection pool
     * @param level          the level
     */
    public WechatPayRetrofitFactory(String baseUrl, TenpayKeyCache tenpayKeyCache, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
        this.baseUrl = baseUrl;
        this.tenpayKeyCache = tenpayKeyCache;
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
                .client(okHttpClient(baseUrl, appMerchant, tenpayKeyCache, connectionPool, level))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addCallAdapterFactory(ResponseBodyCallAdapterFactory.INSTANCE)
                .addConverterFactory(JsonConverterFactory.create())
                .build();
    }

    /**
     * 不走过滤器的Retrofit
     *
     * @return the retrofit
     */
    public static Retrofit withNoAuth() {
        return new Retrofit.Builder()
                .baseUrl(DEFAULT_BASE_URL)
                .client(okHttpClient(new ConnectionPool(), HttpLoggingInterceptor.Level.NONE))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addCallAdapterFactory(ResponseBodyCallAdapterFactory.INSTANCE)
                .addConverterFactory(JsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient okHttpClient(ConnectionPool connectionPool,
                                             HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(level);
        return new OkHttpClient.Builder()
                .connectionPool(connectionPool)
                .addInterceptor(httpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();
    }

    private static OkHttpClient okHttpClient(String baseUrl, AppMerchant appMerchant,
                                             TenpayKeyCache tenpayKeyCache,
                                             ConnectionPool connectionPool,
                                             HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(level);
        TenpayCertificateService tenpayCertificateService = new TenpayCertificateService(baseUrl, appMerchant, tenpayKeyCache);
        WechatAuthorizationInterceptor authorizationInterceptor = new WechatAuthorizationInterceptor(appMerchant, tenpayCertificateService);
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
