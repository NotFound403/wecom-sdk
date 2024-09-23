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

package cn.felord.domain.message;

/**
 * The interface Message body builder.
 *
 * @author dax
 * @since 2024 /4/29
 */
public interface MessageBodyBuilder {
    /**
     * Touser message body builder.
     *
     * @param touser the touser
     * @return the message body builder
     */
    MessageBodyBuilder touser(String touser);

    /**
     * Touser string.
     *
     * @return the string
     */
    String touser();

    /**
     * Toparty message body builder.
     *
     * @param toparty the toparty
     * @return the message body builder
     */
    MessageBodyBuilder toparty(String toparty);

    /**
     * Toparty string.
     *
     * @return the string
     */
    String toparty();

    /**
     * Totag message body builder.
     *
     * @param totag the totag
     * @return the message body builder
     */
    MessageBodyBuilder totag(String totag);

    /**
     * Totag string.
     *
     * @return the string
     */
    String totag();

    /**
     * Build abstract message body.
     *
     * @return the abstract message body
     */
    AbstractMessageBody build();
}
