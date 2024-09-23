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
 * The TransactionType
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum TransactionType {
    /**
     * 退款
     */
    REFUND(1),
    /**
     * 交易手续费
     */
    TRANSACTION_FEES(2),
    /**
     * 收款
     */
    COLLECTION(3),
    /**
     * 提现
     */
    WITHDRAWALS(4),
    /**
     * 其他
     */
    OTHER(5);

    private final int type;

    TransactionType(int type) {
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
     * Deserialize moment task type.
     *
     * @param type the type
     * @return the moment task type
     */
    @JsonCreator
    public static TransactionType deserialize(int type) {
        return Arrays.stream(TransactionType.values())
                .filter(transactionType -> transactionType.type == type)
                .findFirst()
                .orElse(null);
    }
}
