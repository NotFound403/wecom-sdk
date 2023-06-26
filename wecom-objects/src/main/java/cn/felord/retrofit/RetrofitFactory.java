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

package cn.felord.retrofit;

import cn.felord.json.JacksonObjectMapperFactory;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * The type Retrofit factory.
 *
 * @author dax
 * @since 2023 /5/21
 */
public final class RetrofitFactory {
    private static final String BASE_URL = "https://qyapi.weixin.qq.com/cgi-bin/";
    /**
     * The constant JACKSON_CONVERTER_FACTORY.
     */
    public static final JacksonConverterFactory JACKSON_CONVERTER_FACTORY = JacksonConverterFactoryBuilder.build();
    /**
     * The constant RETROFIT_.
     */
    public static final Retrofit RETROFIT_ = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient(HttpLoggingInterceptor.Level.NONE))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addCallAdapterFactory(ResponseBodyCallAdapterFactory.INSTANCE)
            .addConverterFactory(JACKSON_CONVERTER_FACTORY)
            .build();

    private RetrofitFactory() {
    }

    /**
     * Create retrofit.
     *
     * @param <T>            the type parameter
     * @param tokenApi       the token api
     * @param connectionPool the connection pool
     * @param level          the level
     * @return the retrofit
     */
    public static <T extends TokenApi> Retrofit create(T tokenApi, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient(tokenApi, connectionPool, level))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addCallAdapterFactory(ResponseBodyCallAdapterFactory.INSTANCE)
                .addConverterFactory(JACKSON_CONVERTER_FACTORY)
                .build();
    }

    private static OkHttpClient okHttpClient(TokenApi tokenApi, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(level);
        return new OkHttpClient.Builder()
                .connectionPool(connectionPool)
                .addInterceptor(new TokenInterceptor(tokenApi))
                .addInterceptor(httpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    private static OkHttpClient okHttpClient(HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(level);
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    /**
     * The type Jackson converter factory builder.
     */
    static final class JacksonConverterFactoryBuilder {
        private JacksonConverterFactoryBuilder() {
        }

        /**
         * Build jackson converter factory.
         *
         * @return the jackson converter factory
         */
        public static JacksonConverterFactory build() {
            return JacksonConverterFactory.create(JacksonObjectMapperFactory.create());
        }
    }
}
