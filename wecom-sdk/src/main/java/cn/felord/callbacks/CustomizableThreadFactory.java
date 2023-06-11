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
package cn.felord.callbacks;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Customizable thread factory.
 *
 * @author Juergen Hoeller
 * @since 2023 /5/24
 */
public class CustomizableThreadFactory implements ThreadFactory, Serializable {

    private final String threadNamePrefix;

    private int threadPriority = Thread.NORM_PRIORITY;

    private boolean daemon = false;

    @Nullable
    private ThreadGroup threadGroup;

    private final AtomicInteger threadCount = new AtomicInteger();

    /**
     * Create a new CustomizableThreadCreator with the given thread name prefix.
     *
     * @param threadNamePrefix the prefix to use for the names of newly created threads
     */
    public CustomizableThreadFactory(@NotNull String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return this.createThread(runnable);
    }


    /**
     * Return the thread name prefix to use for the names of newly
     * created threads.
     *
     * @return the thread name prefix
     */
    public String getThreadNamePrefix() {
        return this.threadNamePrefix;
    }

    /**
     * Set the priority of the threads that this factory creates.
     * Default is 5.
     *
     * @see Thread#NORM_PRIORITY
     */
    public void setThreadPriority(int threadPriority) {
        this.threadPriority = threadPriority;
    }

    /**
     * Return the priority of the threads that this factory creates.
     */
    public int getThreadPriority() {
        return this.threadPriority;
    }

    /**
     * Set whether this factory is supposed to create daemon threads,
     * just executing as long as the application itself is running.
     * <p>Default is "false": Concrete factories usually support explicit cancelling.
     * Hence, if the application shuts down, Runnables will by default finish their
     * execution.
     * <p>Specify "true" for eager shutdown of threads which still actively execute
     * a {@link Runnable} at the time that the application itself shuts down.
     *
     * @see Thread#setDaemon
     */
    public void setDaemon(boolean daemon) {
        this.daemon = daemon;
    }

    /**
     * Return whether this factory should create daemon threads.
     */
    public boolean isDaemon() {
        return this.daemon;
    }

    /**
     * Specify the name of the thread group that threads should be created in.
     *
     * @see #setThreadGroup
     */
    public void setThreadGroupName(String name) {
        this.threadGroup = new ThreadGroup(name);
    }

    /**
     * Specify the thread group that threads should be created in.
     *
     * @see #setThreadGroupName
     */
    public void setThreadGroup(@Nullable ThreadGroup threadGroup) {
        this.threadGroup = threadGroup;
    }

    /**
     * Return the thread group that threads should be created in
     * (or {@code null} for the default group).
     */
    @Nullable
    public ThreadGroup getThreadGroup() {
        return this.threadGroup;
    }


    /**
     * Template method for the creation of a new {@link Thread}.
     * <p>The default implementation creates a new Thread for the given
     * {@link Runnable}, applying an appropriate thread name.
     *
     * @param runnable the Runnable to execute
     * @see #nextThreadName()
     */
    public Thread createThread(Runnable runnable) {
        Thread thread = new Thread(getThreadGroup(), runnable, nextThreadName());
        thread.setPriority(getThreadPriority());
        thread.setDaemon(isDaemon());
        return thread;
    }

    /**
     * Return the thread name to use for a newly created {@link Thread}.
     * <p>The default implementation returns the specified thread name prefix
     * with an increasing thread count appended: e.g. "SimpleAsyncTaskExecutor-0".
     *
     * @see #getThreadNamePrefix()
     */
    protected String nextThreadName() {
        return getThreadNamePrefix() + this.threadCount.incrementAndGet();
    }

}
