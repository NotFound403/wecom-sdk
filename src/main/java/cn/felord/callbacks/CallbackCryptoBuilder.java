package cn.felord.callbacks;

import cn.felord.domain.callback.CallbackEventBody;

import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

/**
 * The type Callback crypto builder.
 *
 * @author dax
 * @since 2022 /11/12
 */
public class CallbackCryptoBuilder {

    private final CallbackAsyncConsumer callbackAsyncConsumer;
    private final XmlReader xmlReader;

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param callbackAsyncConsumer the callback async consumer
     */
    public CallbackCryptoBuilder(CallbackAsyncConsumer callbackAsyncConsumer) {
        this(new XStreamXmlReader(), callbackAsyncConsumer);
    }

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackCryptoBuilder(Consumer<CallbackEventBody> eventBodyConsumer) {
        this(new XStreamXmlReader(), new CallbackAsyncConsumer(eventBodyConsumer));
    }

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param xmlReader             the xml reader
     * @param callbackAsyncConsumer the callback async consumer
     */
    public CallbackCryptoBuilder(XmlReader xmlReader, CallbackAsyncConsumer callbackAsyncConsumer) {
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
        this(new CallbackAsyncConsumer(executor, eventBodyConsumer));
    }

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param xmlReader         the xml reader
     * @param executor          the executor
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackCryptoBuilder(XmlReader xmlReader, ExecutorService executor, Consumer<CallbackEventBody> eventBodyConsumer) {
        this(xmlReader, new CallbackAsyncConsumer(executor, eventBodyConsumer));
    }

    /**
     * Instantiates a new Callback crypto builder.
     *
     * @param xmlReader         the xml reader
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackCryptoBuilder(XmlReader xmlReader, Consumer<CallbackEventBody> eventBodyConsumer) {
        this(xmlReader, new CallbackAsyncConsumer(eventBodyConsumer));
    }


    /**
     * Build callback crypto.
     *
     * @param callbackAuthenticationService the callback authentication service
     * @return the callback crypto
     */
    public CallbackCrypto build(CallbackAuthenticationService callbackAuthenticationService) {
        return new CallbackCrypto(xmlReader, callbackAuthenticationService, callbackAsyncConsumer);
    }


}
