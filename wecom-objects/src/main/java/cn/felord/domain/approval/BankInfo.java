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

package cn.felord.domain.approval;

/**
 * @author dax
 * @since 2024/1/24
 */

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 开户行信息
 */
@ToString
@Getter
public class BankInfo {
    /**
     * 开户银行
     */
    private final String bankAlias;
    /**
     * 开户银行代码（微信侧定义）
     */
    private final String bankAliasCode;
    /**
     * 开户地区省份（微信侧定义）
     */
    private final String province;
    /**
     * 开户地区所在省编码（微信侧定义）
     */
    private final String provinceCode;
    /**
     * 开户地区城市（微信侧定义）
     */
    private final String city;
    /**
     * 开户地区所在城市编码（微信侧定义）
     */
    private final String cityCode;
    /**
     * 开户支行名称（微信侧定义）
     */
    private final String bankBranchName;
    /**
     * 开户支行代码（微信侧定义）
     */
    private final String bankBranchId;

    /**
     * Instantiates a new Bank info.
     *
     * @param bankAlias     the bank alias
     * @param bankAliasCode the bank alias code
     * @param province      the province
     * @param provinceCode  the province code
     * @param city          the city
     * @param cityCode      the city code
     */
    public BankInfo(String bankAlias, String bankAliasCode, String province, String provinceCode, String city, String cityCode) {
        this(bankAlias, bankAliasCode, province, provinceCode, city, cityCode, null, null);
    }

    /**
     * Instantiates a new Bank info.
     *
     * @param bankAlias      the bank alias
     * @param bankAliasCode  the bank alias code
     * @param province       the province
     * @param provinceCode   the province code
     * @param city           the city
     * @param cityCode       the city code
     * @param bankBranchName the bank branch name
     * @param bankBranchId   the bank branch id
     */
    @JsonCreator
    public BankInfo(@JsonProperty("bank_alias") String bankAlias,
                    @JsonProperty("bank_alias_code") String bankAliasCode,
                    @JsonProperty("province") String province,
                    @JsonProperty("province_code") String provinceCode,
                    @JsonProperty("city") String city,
                    @JsonProperty("city_code") String cityCode,
                    @JsonProperty("bank_branch_name") String bankBranchName,
                    @JsonProperty("bank_branch_id") String bankBranchId) {
        this.bankAlias = bankAlias;
        this.bankAliasCode = bankAliasCode;
        this.province = province;
        this.provinceCode = provinceCode;
        this.city = city;
        this.cityCode = cityCode;
        this.bankBranchName = bankBranchName;
        this.bankBranchId = bankBranchId;
    }
}
