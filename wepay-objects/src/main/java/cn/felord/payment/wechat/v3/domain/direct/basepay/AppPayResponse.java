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

package cn.felord.payment.wechat.v3.domain.direct.basepay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author dax
 * @since 2023/8/11
 */
@Data
public class AppPayResponse {
    private final String appid;
    private final String partnerid;
    private final String prepayid;
    @JsonProperty("package")
    private final String packAge;
    private final String nonceStr;
    private final String timeStamp;
    private final String signType;
    private final String paySign;
}
