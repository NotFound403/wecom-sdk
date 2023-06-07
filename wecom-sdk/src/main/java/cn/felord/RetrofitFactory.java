package cn.felord;

import cn.felord.api.TokenApi;
import cn.felord.json.JacksonObjectMapperFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author dax
 * @since 2023/5/21
 */
public final class RetrofitFactory {
    private static final String BASE_URL = "https://qyapi.weixin.qq.com/cgi-bin/";
    public static final JacksonConverterFactory JACKSON_CONVERTER_FACTORY = JacksonConverterFactoryBuilder.build();

    public static final Retrofit RETROFIT_ = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addCallAdapterFactory(ResponseBodyCallAdapterFactory.INSTANCE)
            .addConverterFactory(JACKSON_CONVERTER_FACTORY)
            .build();

    public static <T extends TokenApi> Retrofit create(Class<T> tokenApiClazz) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient(RETROFIT_.create(tokenApiClazz)))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addCallAdapterFactory(ResponseBodyCallAdapterFactory.INSTANCE)
                .addConverterFactory(JACKSON_CONVERTER_FACTORY)
                .build();
    }

    private static OkHttpClient okHttpClient(TokenApi tokenApi) {
        return new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor(tokenApi))
                .build();
    }

    private static OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    static final class JacksonConverterFactoryBuilder {
        private JacksonConverterFactoryBuilder() {
        }

        public static JacksonConverterFactory build() {
            return JacksonConverterFactory.create(JacksonObjectMapperFactory.create());
        }
    }
}
