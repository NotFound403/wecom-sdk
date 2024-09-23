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

import cn.felord.enumeration.ApvlBankAccountType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The type Bank account value.
 *
 * @author dax
 * @since 2024 /1/20
 */
@ToString
@Getter
public class BankAccountValue implements ContentDataValue {

    private final BankAccount bankAccount;


    /**
     * Instantiates a new Bank account value.
     *
     * @param bankAccount the bank account
     */
    @JsonCreator
    BankAccountValue(@JsonProperty("bank_account") BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * 银行账户控件赋值
     *
     * @param accountType   the account type
     * @param accountName   the account name
     * @param accountNumber the account number
     * @param bank          the bank
     * @param remark        the remark
     * @return the bank account value
     */
    protected static BankAccountValue from(@NonNull ApvlBankAccountType accountType,
                                        @NonNull String accountName,
                                        @NonNull String accountNumber,
                                        @NonNull BankInfo bank,
                                        String remark) {
        return new BankAccountValue(new BankAccount(accountType, accountName, accountNumber, bank, remark));
    }

    /**
     * 官方尚未支持
     *
     * @param accountType   the account type
     * @param accountName   the account name
     * @param accountNumber the account number
     * @param bank          the bank
     * @return the bank account value
     */
    protected static BankAccountValue from(@NonNull ApvlBankAccountType accountType,
                                        @NonNull String accountName,
                                        @NonNull String accountNumber,
                                        @NonNull BankInfo bank) {
        return new BankAccountValue(new BankAccount(accountType, accountName, accountNumber, bank));
    }

    /**
     * 银行账户信息
     */
    @ToString
    @Getter
    public static class BankAccount {

        /**
         * 账户类型  2 个人账户
         */
        private final ApvlBankAccountType accountType;
        /**
         * 账户名称
         */
        private final String accountName;
        /**
         * 卡号
         */
        private final String accountNumber;
        /**
         * 开户行信息
         */
        private final BankInfo bank;
        /**
         * 备注
         */
        private final String remark;

        /**
         * Instantiates a new Bank account.
         *
         * @param accountType   the account type
         * @param accountName   the account name
         * @param accountNumber the account number
         * @param bank          the bank
         */
        BankAccount(ApvlBankAccountType accountType, String accountName, String accountNumber, BankInfo bank) {
            this(accountType, accountName, accountNumber, bank, null);
        }

        /**
         * Instantiates a new Bank account.
         *
         * @param accountType   the account type
         * @param accountName   the account name
         * @param accountNumber the account number
         * @param bank          the bank
         * @param remark        the remark
         */
        @JsonCreator
        BankAccount(@JsonProperty("account_type") ApvlBankAccountType accountType,
                    @JsonProperty("account_name") String accountName,
                    @JsonProperty("account_number") String accountNumber,
                    @JsonProperty("bank") BankInfo bank,
                    @JsonProperty("remark") String remark) {
            this.accountType = accountType;
            this.accountName = accountName;
            this.accountNumber = accountNumber;
            this.bank = bank;
            this.remark = remark;
        }
    }

}
