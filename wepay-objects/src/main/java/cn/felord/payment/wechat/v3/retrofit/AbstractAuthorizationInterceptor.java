package cn.felord.payment.wechat.v3.retrofit;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.AppMerchant;
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;
import cn.felord.utils.OkHttpUtil;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import static cn.felord.payment.wechat.v3.WepaySdkVersion.USER_AGENT;

/**
 * The type Abstract authorization interceptor.
 *
 * @author dax
 * @since 2023 /8/16 9:36
 */
public abstract class AbstractAuthorizationInterceptor implements Interceptor {
    private static final String APPLICATION_JSON_UTF_8 = "application/json; charset=UTF-8";
    private final AppMerchant appMerchant;

    /**
     * Instantiates a new Abstract authorization interceptor.
     *
     * @param appMerchant the app merchant
     */
    public AbstractAuthorizationInterceptor(AppMerchant appMerchant) {
        this.appMerchant = appMerchant;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Headers headers = request.headers();
        String mediaBody = headers.get(HttpHeaders.META.headerName());
        String bodyStr = Objects.nonNull(mediaBody) ? mediaBody :
                Optional.ofNullable(request.body())
                        .map(OkHttpUtil::requestBodyToString)
                        .orElse("");
        HttpUrl httpUrl = request.url();
        String authorization = WechatPaySigner.sign(appMerchant, httpUrl.uri(), request.method(), bodyStr);

        Headers.Builder headerBuilder = headers.newBuilder();
        String contentType = HttpHeaders.CONTENT_TYPE.headerName();
        if (Objects.isNull(headers.get(contentType))) {
            headerBuilder.set(contentType, APPLICATION_JSON_UTF_8);
        }
        Request requestWithAuth = request.newBuilder()
                .url(httpUrl)
                .header(HttpHeaders.AUTHORIZATION.headerName(), authorization)
                .header(HttpHeaders.USER_AGENT.headerName(), USER_AGENT)
                .header(HttpHeaders.ACCEPT.headerName(), "*/*")
                .build();
        Response response = chain.proceed(requestWithAuth);
        this.consume(response);
        return response;
    }

    /**
     * Consume.
     *
     * @param response the response
     * @throws PayException the pay exception
     */
    protected abstract void consume(Response response) throws PayException;

}
