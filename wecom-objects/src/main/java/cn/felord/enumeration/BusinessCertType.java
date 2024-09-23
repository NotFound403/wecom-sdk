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
 * The BusinessCertType
 *
 * @author dax
 * @since 2024/7/1 8:34
 */
public enum BusinessCertType {

    /**
     * 统一社会信用代码证书
     */
    CERTIFICATE_2389(2389),

    /**
     * 社会团体法人登记证书
     */
    CERTIFICATE_2394(2394),
    /**
     * 民办非企业单位登记证书
     */
    CERTIFICATE_2395(2395),

    /**
     * 基金会法人登记证书
     */
    CERTIFICATE_2396(2396),
    /**
     * 宗教活动场所登记证
     */
    CERTIFICATE_2399(2399),

    /**
     * 政府部门下发的其他有效证明文件
     */
    CERTIFICATE_2400(2400),
    /**
     * 执业许可证/执业证
     */
    CERTIFICATE_2520(2520),
    /**
     * 基层群众性自治组织特别法人统一社会信用代码证
     */
    CERTIFICATE_2521(2521),
    /**
     * 农村集体经济组织登记证
     */
    CERTIFICATE_2522(2522);
    private final int type;

    BusinessCertType(int type) {
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
     * Deserialize BusinessCertType
     *
     * @param type the type
     * @return the date ctrl type
     */
    @JsonCreator
    public static BusinessCertType deserialize(int type) {
        return Arrays.stream(BusinessCertType.values())
                .filter(businessCertType -> businessCertType.type == type)
                .findFirst()
                .orElse(null);
    }
}
