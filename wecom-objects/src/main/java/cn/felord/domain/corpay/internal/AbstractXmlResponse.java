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
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Objects;

/**
 * @author dax
 * @since 2023/6/26 13:50
 */
@Data
public abstract class AbstractXmlResponse implements XmlEntity {
    @XStreamAlias("return_code")
    private String returnCode;
    @XStreamAlias("return_msg")
    private String returnMsg;
    @XStreamAlias("result_code")
    private String resultCode;
    @XStreamAlias("err_code")
    private String errCode;
    @XStreamAlias("err_code_des")
    private String errCodeDes;


    public final boolean isSuccessful() {
        return Objects.equals(returnCode, "SUCCESS") &&
                Objects.equals(resultCode, "SUCCESS");
    }
}
