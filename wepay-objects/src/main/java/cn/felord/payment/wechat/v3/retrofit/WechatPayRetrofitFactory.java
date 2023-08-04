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
import cn.felord.payment.wechat.v3.crypto.DefaultRequestAuthenticator;
import cn.felord.payment.wechat.v3.crypto.MerchantConfig;
import cn.felord.payment.wechat.v3.crypto.MerchantKeyLoader;
import cn.felord.payment.wechat.v3.crypto.RequestAuthenticator;
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
    private static final String BASE_URL = "https://api.mch.weixin.qq.com/";
    private final String baseUrl;
    private final RequestAuthenticator requestAuthenticator;

    /**
     * Instantiates a new Wechat pay retrofit factory.
     *
     * @param requestAuthenticator the request authenticator
     */
    public WechatPayRetrofitFactory(RequestAuthenticator requestAuthenticator) {
        this(BASE_URL, requestAuthenticator);
    }

    /**
     * Instantiates a new Wechat pay retrofit factory.
     *
     * @param merchantKeyLoader the merchant key loader
     */
    public WechatPayRetrofitFactory(MerchantKeyLoader merchantKeyLoader) {
        this(BASE_URL, merchantKeyLoader);
    }

    /**
     * Instantiates a new Wechat pay retrofit factory.
     *
     * @param baseUrl              the base url
     * @param requestAuthenticator the request authenticator
     */
    public WechatPayRetrofitFactory(String baseUrl, RequestAuthenticator requestAuthenticator) {
        this.baseUrl = baseUrl;
        this.requestAuthenticator = requestAuthenticator;
    }

    /**
     * Instantiates a new Wechat pay retrofit factory.
     *
     * @param baseUrl           the base url
     * @param merchantKeyLoader the merchant key loader
     */
    public WechatPayRetrofitFactory(String baseUrl, MerchantKeyLoader merchantKeyLoader) {
        this(baseUrl, new DefaultRequestAuthenticator(merchantKeyLoader));
    }

    /**
     * 带TokenApi拦截器的Retrofit客户端
     *
     * @param merchantConfig the merchant config
     * @param connectionPool the connection pool
     * @param level          the level
     * @return the retrofit
     */
    public Retrofit create(MerchantConfig merchantConfig, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient(requestAuthenticator, merchantConfig, connectionPool, level))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addCallAdapterFactory(ResponseBodyCallAdapterFactory.INSTANCE)
                .addConverterFactory(JsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient okHttpClient(RequestAuthenticator requestAuthenticator, MerchantConfig merchantConfig, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(level);
        WechatAuthorizationInterceptor authorizationInterceptor = new WechatAuthorizationInterceptor(requestAuthenticator, merchantConfig);
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
