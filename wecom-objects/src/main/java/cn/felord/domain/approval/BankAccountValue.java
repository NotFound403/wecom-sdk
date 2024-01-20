package cn.felord.domain.approval;

import cn.felord.enumeration.ApvlBankAccountType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Bank account value.
 *
 * @author dax
 * @since 2024/1/20
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
    public BankAccountValue(@JsonProperty("bank_account") BankAccount bankAccount) {
        this.bankAccount = bankAccount;
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
        public BankAccount(ApvlBankAccountType accountType, String accountName, String accountNumber, BankInfo bank) {
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
        public BankAccount(@JsonProperty("account_type") ApvlBankAccountType accountType,
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

    /**
     * 开户行信息
     */
    @ToString
    @Getter
    public static class BankInfo {
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
        private String bankBranchName;
        /**
         * 开户支行代码（微信侧定义）
         */
        private String bankBranchId;

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
            this.bankAlias = bankAlias;
            this.bankAliasCode = bankAliasCode;
            this.province = province;
            this.provinceCode = provinceCode;
            this.city = city;
            this.cityCode = cityCode;
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
}
