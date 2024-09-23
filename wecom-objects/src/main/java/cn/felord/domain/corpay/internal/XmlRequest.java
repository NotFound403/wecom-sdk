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

package cn.felord.domain.corpay.internal;

import cn.felord.callback.XmlEntity;
import cn.felord.enumeration.PaySignType;

/**
 * The interface Xmlable.
 *
 * @author dax
 * @since 2024/6/25 15:24
 */
public interface XmlRequest extends XmlEntity {

    /**
     * Xml string.
     *
     * @param paySecret the pay secret
     * @param signType  the sign type
     * @return the string
     */
    String xmlBody(String paySecret, PaySignType signType);

    /**
     * Workwx sign.
     *
     * @param agentSecret the agent secret
     */
    void workWxSign(String agentSecret);
}
