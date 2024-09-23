
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

package cn.felord.domain.corpay.external;

import cn.felord.enumeration.RefundStatus;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/6/29 16:20
 */
@Data
public class RefundInfo {

    private String outRefundNo;
    private String refundComment;
    private Long refundFee;
    private Instant refundReqtime;
    private RefundStatus refundStatus;
    private String refundUserid;
}
