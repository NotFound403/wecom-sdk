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
 * The RefundStatus
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum RefundStatus {


    /**
     * 已申请退款
     */
    APPLYING(0),
    /**
     * 退款处理中
     */
    DOING(1),
    /**
     * 退款成功
     */
    SUCCESS(2),
    /**
     * 退款关闭
     */
    CLOSED(3),
    /**
     * 退款异常
     */
    ERROR(4),
    /**
     * 正在审批中
     */
    UNDER_APPROVAL(5),
    /**
     * 审批失败
     */
    FAIL_TO_APPROVAL(6),

    /**
     * 审批取消
     */
    APPROVAL_CANCELLED(7);

    private final int status;

    RefundStatus(int status) {
        this.status = status;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    @JsonValue
    public int getStatus() {
        return status;
    }

    /**
     * Deserialize RefundStatus
     *
     * @param status the status
     * @return the RefundStatus
     */
    @JsonCreator
    public static RefundStatus deserialize(int status) {
        return Arrays.stream(RefundStatus.values())
                .filter(mchBindStatus -> mchBindStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
