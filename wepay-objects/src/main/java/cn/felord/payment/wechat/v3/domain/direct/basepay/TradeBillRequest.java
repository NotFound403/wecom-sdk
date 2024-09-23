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

import cn.felord.payment.wechat.enumeration.TarType;
import cn.felord.payment.wechat.enumeration.TradeBillType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

/**
 * 申请交易账单请求参数
 *
 * @author felord.cn
 * @since 1.0.3.RELEASE
 */
@RequiredArgsConstructor
@Getter
public class TradeBillRequest {
    /**
     * 账单日期，必传。
     * <p>
     * 格式yyyy-MM-DD，仅支持三个月内的账单下载申请。
     */
    private final LocalDate billDate;
    /**
     * 账单类型,不填则默认值为{@link TradeBillType#ALL}
     *
     * @see TradeBillType
     */
    private TradeBillType billType;
    /**
     * 压缩类型，不填默认值为数据流
     *
     * @see TarType
     */
    private TarType tarType;

    /**
     * Bill type trade bill request.
     *
     * @param billType the bill type
     * @return the trade bill request
     */
    public TradeBillRequest billType(TradeBillType billType) {
        this.billType = billType;
        return this;
    }

    /**
     * Tar type trade bill request.
     *
     * @param tarType the tar type
     * @return the trade bill request
     */
    public TradeBillRequest tarType(TarType tarType) {
        this.tarType = tarType;
        return this;
    }
}
