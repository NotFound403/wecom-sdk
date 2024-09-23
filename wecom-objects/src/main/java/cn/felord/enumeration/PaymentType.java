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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The PaymentType
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum PaymentType {
    /**
     * 在聊天中收款
     */
    IN_CHAT(0),
    /**
     * 收款码收款
     */
    SCAN_QRCODE(1),
    /**
     * 在直播间收款
     */
    IN_LIVE_ROOM(2),
    /**
     * 产品图册
     */
    PRODUCT_BROCHURE(3),
    /**
     * 转账
     */
    TRANSFER(14),
    /**
     * 小程序（仅部分灰度企业可在小程序中接入对外收款账户进行收款）
     */
    MINIPROGRAM(15);

    private final int type;

    PaymentType(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

    /**
     * Deserialize PaymentType
     *
     * @param type the type
     * @return the PaymentType
     */
    @JsonCreator
    public static PaymentType deserialize(int type) {
        return Arrays.stream(PaymentType.values())
                .filter(paymentType -> paymentType.type == type)
                .findFirst()
                .orElse(null);
    }
}
