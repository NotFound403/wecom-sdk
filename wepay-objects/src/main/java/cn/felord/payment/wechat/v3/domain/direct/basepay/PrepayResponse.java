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

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * The type Prepay response.
 *
 * @author dax
 * @since 2024/8/11
 */
@Data
public class PrepayResponse {
    private String prepayId;
    @JsonAlias(value = {"code_url", "h5_url"})
    private String url;
}
