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

package cn.felord.callback;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * 异步消费事件数据
 *
 * @param <EVENT> the type parameter
 * @author felord.cn
 * @since 1.0.0
 */
public final class CallbackAsyncConsumer<EVENT> {
    private final ExecutorService executor;
    private final Consumer<EVENT> eventBodyConsumer;


    /**
     * Instantiates a new Callback async consumer.
     *
     * @param eventBodyConsumer the event body consumer
     */
    public CallbackAsyncConsumer(Consumer<EVENT> eventBodyConsumer) {
        this(20, 100, 90L, 1500, eventBodyConsumer);
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
                                 Consumer<EVENT> eventBodyConsumer) {

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
    public CallbackAsyncConsumer(ExecutorService executor, Consumer<EVENT> eventBodyConsumer) {
        this.executor = executor;
        this.eventBodyConsumer = eventBodyConsumer;
    }

    /**
     * Action.
     *
     * @param eventBody the event body
     */
    public void asyncAction(EVENT eventBody) {
        Thread thread = new Thread(() -> eventBodyConsumer.accept(eventBody));
        executor.execute(thread);
    }
}
