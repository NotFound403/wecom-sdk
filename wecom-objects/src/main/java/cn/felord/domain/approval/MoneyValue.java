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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * The type Money value.
 *
 * @author dax
 * @since 2024/5/26
 */
@ToString
@Getter
public class MoneyValue implements ContentDataValue {
    private final String newMoney;

    /**
     * 仅反序列化时使用，初始化推荐使用{@code from(newMoney)}系列静态方法
     *
     * @param newMoney 最多保留两位小数，否则会报错
     */
    @JsonCreator
    MoneyValue(@JsonProperty("new_money") String newMoney) {
        this.newMoney = newMoney;
    }

    /**
     * From money value.
     *
     * @param newMoney 强制四舍五入两位小数
     * @return the money value
     */
    public static MoneyValue from(long newMoney) {
        String money = BigDecimal.valueOf(newMoney)
                .setScale(2, RoundingMode.HALF_UP)
                .toPlainString();
        return new MoneyValue(money);
    }

    /**
     * From money value.
     *
     * @param newMoney 强制四舍五入两位小数
     * @return the money value
     */
    public static MoneyValue from(int newMoney) {
        String money = BigDecimal.valueOf(newMoney)
                .setScale(2, RoundingMode.HALF_UP)
                .toPlainString();
        return new MoneyValue(money);
    }

    /**
     * From money value.
     *
     * @param newMoney 强制四舍五入两位小数
     * @return the money value
     */
    public static MoneyValue from(double newMoney) {
        String money = BigDecimal.valueOf(newMoney)
                .setScale(2, RoundingMode.HALF_UP)
                .toPlainString();
        return new MoneyValue(money);
    }

    /**
     * From money value.
     *
     * @param newMoney 强制四舍五入两位小数
     * @return the money value
     */
    public static MoneyValue from(float newMoney) {
        String money = BigDecimal.valueOf(newMoney)
                .setScale(2, RoundingMode.HALF_UP)
                .toPlainString();
        return new MoneyValue(money);
    }

    /**
     * From money value.
     *
     * @param newMoney 传{@code null}将被转换为0，非空强制四舍五入两位小数
     * @return the money value
     */
    public static MoneyValue from(BigDecimal newMoney) {
        String money = Optional.ofNullable(newMoney).orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP)
                .toPlainString();
        return new MoneyValue(money);
    }
}
