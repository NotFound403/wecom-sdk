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

package cn.felord.callbacks;

import cn.felord.callback.CallbackAsyncConsumer;
import cn.felord.xml.XStreamXmlReader;
import cn.felord.xml.XmlReader;

import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

/**
 * The type Callback crypto builder.
 *
 * @author dax
 * @since 2021 /11/12
 */
public class CallbackCryptoBuilder {

    private final CallbackAsyncConsumer<CallbackEventBody> callbackAsyncConsumer;
    private final XmlReader xmlReader;

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param callbackAsyncConsumer the callback async consumer
     */
    public CallbackCryptoBuilder(CallbackAsyncConsumer<CallbackEventBody> callbackAsyncConsumer) {
        this(XStreamXmlReader.INSTANCE, callbackAsyncConsumer);
    }

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackCryptoBuilder(Consumer<CallbackEventBody> eventBodyConsumer) {
        this(XStreamXmlReader.INSTANCE, new CallbackAsyncConsumer<>(eventBodyConsumer));
    }

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param xmlReader             the xml reader
     * @param callbackAsyncConsumer the callback async consumer
     */
    public CallbackCryptoBuilder(XmlReader xmlReader, CallbackAsyncConsumer<CallbackEventBody> callbackAsyncConsumer) {
        this.xmlReader = xmlReader;
        this.callbackAsyncConsumer = callbackAsyncConsumer;
    }

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param executor          the executor
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackCryptoBuilder(ExecutorService executor, Consumer<CallbackEventBody> eventBodyConsumer) {
        this(new CallbackAsyncConsumer<>(executor, eventBodyConsumer));
    }

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param xmlReader         the xml reader
     * @param executor          the executor
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackCryptoBuilder(XmlReader xmlReader, ExecutorService executor, Consumer<CallbackEventBody> eventBodyConsumer) {
        this(xmlReader, new CallbackAsyncConsumer<>(executor, eventBodyConsumer));
    }

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param xmlReader         the xml reader
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackCryptoBuilder(XmlReader xmlReader, Consumer<CallbackEventBody> eventBodyConsumer) {
        this(xmlReader, new CallbackAsyncConsumer<>(eventBodyConsumer));
    }


    /**
     * Build callback crypto.
     *
     * @param callbackSettingsService the callback authentication service
     * @return the callback crypto
     */
    public CallbackCrypto build(CallbackSettingsService callbackSettingsService) {
        return new CallbackCrypto(xmlReader, callbackSettingsService, callbackAsyncConsumer);
    }


}
