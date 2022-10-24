package cn.felord.callbacks;

import cn.felord.domain.callback.CallbackEventBody;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * The interface Callback consumer.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public final class CallbackAsyncConsumer {
    private final ExecutorService executor;
    private final Consumer<CallbackEventBody> eventBodyConsumer;


    /**
     * Instantiates a new Callback async consumer.
     *
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackAsyncConsumer(Consumer<CallbackEventBody> eventBodyConsumer) {
        this(5, 20, 60L, 100, eventBodyConsumer);
    }

    /**
     * Instantiates a new Callback async consumer.
     *
     * @param corePoolSize      the core pool size
     * @param maximumPoolSize   the maximum pool size
     * @param keepAliveSecond   the keep alive second
     * @param capacity          the capacity
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackAsyncConsumer(int corePoolSize,
                                 int maximumPoolSize,
                                 long keepAliveSecond,
                                 int capacity,
                                 Consumer<CallbackEventBody> eventBodyConsumer) {

        this(new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveSecond, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(capacity),
                new CustomizableThreadFactory("WECOM-CALLBACK-THREAD-POOL-")), eventBodyConsumer);

    }


    /**
     * Instantiates a new Callback async consumer.
     *
     * @param executor          the executor
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackAsyncConsumer(ExecutorService executor, Consumer<CallbackEventBody> eventBodyConsumer) {
        this.executor = executor;
        this.eventBodyConsumer = eventBodyConsumer;
    }

    /**
     * Action.
     *
     * @param eventBody the event body
     */
    public void asyncAction(CallbackEventBody eventBody) {
        Thread thread = new Thread(() -> eventBodyConsumer.accept(eventBody));
        executor.execute(thread);
    }


}
