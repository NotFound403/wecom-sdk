package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Objects;

/**
 * 银行账户类型
 * <ol>
 *     <li>若主体为企业/政府机关/事业单位/社会组织，可填写：74-对公账户。</li>
 *     <li>主体为小微/个人卖家，可选择：75-对私账户。</li>
 *     <li>若主体为个体工商户，可填写：74-对公账户、75-对私账户。</li>
 * </ol>
 *
 * @author dax
 * @since 2023 /7/3 15:28
 */
public enum BankAccountType {
    /**
     * 对公账户
     */
    CORP_ACCOUNT("74"),
    /**
     * 对私账户
     */
    PERSONAL_ACCOUNT("75");

    private final String type;

    BankAccountType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }

    /**
     * Deserialize BankAccountType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static BankAccountType deserialize(String type) {
        return Arrays.stream(BankAccountType.values())
                .filter(bankAccountType -> Objects.equals(bankAccountType.type, type))
                .findFirst()
                .orElse(null);
    }

}
