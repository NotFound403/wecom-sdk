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
import cn.felord.payment.wechat.v3.crypto.AppMerchantService;
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;
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
    private final WechatPaySigner wechatPaySigner;
    private final TenpayCertificateApi tenpayCertificateApi;
    private final AppMerchantService appMerchantService;
    private final ConnectionPool connectionPool;
    private final HttpLoggingInterceptor.Level level;


    /**
     * Instantiates a new Wechat pay retrofit factory.
     *
     * @param wechatPaySigner the wechat pay signer
     * @param appMerchantService the merchant service
     */
    public WechatPayRetrofitFactory(WechatPaySigner wechatPaySigner, AppMerchantService appMerchantService) {
        this(DEFAULT_BASE_URL, wechatPaySigner, appMerchantService);
    }

    /**
     * Instantiates a new Wechat pay retrofit factory.
     *
     * @param baseUrl         the base url
     * @param wechatPaySigner the wechat pay signer
     * @param appMerchantService the merchant service
     */
    public WechatPayRetrofitFactory(String baseUrl, WechatPaySigner wechatPaySigner, AppMerchantService appMerchantService) {
        this(baseUrl, wechatPaySigner, appMerchantService, new ConnectionPool(), HttpLoggingInterceptor.Level.NONE);
    }

    /**
     * Instantiates a new Wechat pay retrofit factory.
     *
     * @param baseUrl         the base url
     * @param wechatPaySigner the wechat pay signer
     * @param appMerchantService the merchant service
     * @param connectionPool  the connection pool
     * @param level           the level
     */
    public WechatPayRetrofitFactory(String baseUrl, WechatPaySigner wechatPaySigner, AppMerchantService appMerchantService, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
        this.baseUrl = baseUrl;
        this.wechatPaySigner = wechatPaySigner;
        this.tenpayCertificateApi = new TenpayCertificateApi(this);
        this.appMerchantService = appMerchantService;
        this.connectionPool = connectionPool;
        this.level = level;
    }

    private static OkHttpClient okHttpClient(String merchantId,
                                             WechatPaySigner wechatPaySigner,
                                             TenpayCertificateApi tenpayCertificateApi,
                                             ConnectionPool connectionPool,
                                             HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(level);
        WechatAuthorizationInterceptor authorizationInterceptor = new WechatAuthorizationInterceptor(merchantId, wechatPaySigner, tenpayCertificateApi);
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

    /**
     * Wechat pay signer wechat pay signer.
     *
     * @return the wechat pay signer
     */
    public WechatPaySigner wechatPaySigner() {
        return wechatPaySigner;
    }

    /**
     * 带TokenApi拦截器的Retrofit客户端
     *
     * @param merchantId the merchant id
     * @return the retrofit
     */
    public Retrofit merchant(String merchantId) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient(merchantId, wechatPaySigner, tenpayCertificateApi, connectionPool, level))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addCallAdapterFactory(new ResponseBodyCallAdapterFactory())
                .addConverterFactory(JsonConverterFactory.create())
                .build();
    }

    /**
     * Tenpay certificate api tenpay certificate api.
     *
     * @return the tenpay certificate api
     */
    public TenpayCertificateApi tenpayCertificateApi() {
        return tenpayCertificateApi;
    }

    /**
     * Merchant service merchant service.
     *
     * @return the merchant service
     */
    public AppMerchantService merchantService() {
        return appMerchantService;
    }
}
