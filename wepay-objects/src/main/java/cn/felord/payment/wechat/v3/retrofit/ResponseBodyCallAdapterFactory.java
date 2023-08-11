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


import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;
import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Token interceptor.
 *
 * @author felord.cn
 * @since 2.0.0
 */
final class ResponseBodyCallAdapterFactory extends CallAdapter.Factory {
    private final WechatPaySigner wechatPaySigner;


    ResponseBodyCallAdapterFactory(WechatPaySigner wechatPaySigner) {
        this.wechatPaySigner = wechatPaySigner;
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return new ResponseBodyCallAdapter<>(wechatPaySigner, returnType);
    }

    /**
     * The type Body call adapter.
     *
     * @param <R> the type parameter
     */
    static final class ResponseBodyCallAdapter<R> implements CallAdapter<R, R> {
        private final WechatPaySigner wechatPaySigner;
        private final Type returnType;

        ResponseBodyCallAdapter(WechatPaySigner wechatPaySigner, Type returnType) {
            this.wechatPaySigner = wechatPaySigner;
            this.returnType = returnType;
        }

        @Override
        public Type responseType() {
            return this.returnType;
        }

        @Override
        public R adapt(Call<R> call) {

            Response<R> response;
            try {
                response = call.execute();
            } catch (IOException e) {
                throw new PayException(e.getMessage(), e);
            }

            Headers responseHeaders = response.headers();
            if (response.isSuccessful()) {
                String serialNumber = responseHeaders.get(HttpHeaders.WECHAT_PAY_SERIAL.headerName());


                return response.body();
            }

            throw new PayException("RequestID: " + responseHeaders.get(HttpHeaders.REQUEST_ID.headerName()) + " Response is not successful, " + response.message());
        }
    }
}
