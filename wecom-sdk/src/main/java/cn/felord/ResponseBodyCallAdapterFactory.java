/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package cn.felord;


import okhttp3.ResponseBody;
import retrofit2.*;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * The type Token interceptor.
 *
 * @author dax
 * @since 2023 /5/22 14:59
 */
public final class ResponseBodyCallAdapterFactory extends CallAdapter.Factory {

    /**
     * The constant INSTANCE.
     */
    public static final ResponseBodyCallAdapterFactory INSTANCE = new ResponseBodyCallAdapterFactory();

    private ResponseBodyCallAdapterFactory() {
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return new ResponseBodyCallAdapter<>(returnType, annotations, retrofit);
    }

    /**
     * The type Body call adapter.
     *
     * @param <R> the type parameter
     */
    static final class ResponseBodyCallAdapter<R> implements CallAdapter<R, R> {

        private final Type returnType;

        private final Retrofit retrofit;

        private final Annotation[] annotations;

        /**
         * Instantiates a new Body call adapter.
         *
         * @param returnType  the return type
         * @param annotations the annotations
         * @param retrofit    the retrofit
         */
        ResponseBodyCallAdapter(Type returnType, Annotation[] annotations, Retrofit retrofit) {
            this.returnType = returnType;
            this.retrofit = retrofit;
            this.annotations = annotations;
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
                throw new WeComException(e.getMessage());
            }

            if (response.isSuccessful()) {
                return response.body();
            }

            Converter<ResponseBody, R> responseBodyRConverter = retrofit.responseBodyConverter(responseType(), annotations);
            try (ResponseBody errorBody = response.errorBody()) {
                return errorBody == null ? null : responseBodyRConverter.convert(errorBody);
            } catch (IOException e) {
                throw new WeComException(e.getMessage());
            }
        }
    }
}
