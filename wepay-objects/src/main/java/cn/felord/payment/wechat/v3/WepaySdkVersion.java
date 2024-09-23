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

package cn.felord.payment.wechat.v3;

import java.util.Optional;

/**
 * @author dax
 * @since 2023/8/4
 */
public final class WepaySdkVersion {
    public static final String WEPAY_VERSION = "1.2";
    public static final String WEPAY_SDK = "Wepay-sdk/";
    public static final String USER_AGENT = WEPAY_SDK +
            Optional.ofNullable(WepaySdkVersion.class.getPackage().getImplementationVersion()).orElse(WEPAY_VERSION) +
            "/Java/" + System.getProperty("java.version") +
            "/" + System.getProperty("os.name") +
            "/" + System.getProperty("os.version");

    WepaySdkVersion() {
    }


}
